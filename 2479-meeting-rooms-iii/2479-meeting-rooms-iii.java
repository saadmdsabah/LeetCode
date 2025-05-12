class Solution {

    class Pair implements Comparable<Pair> {
        int room;
        int endTime;
        public Pair(int room, int endTime){
            this.room = room;
            this.endTime = endTime;
        }

        public int compareTo(Pair p){
            if(this.endTime == p.endTime){
                return this.room - p.room;
            }
            return this.endTime - p.endTime;
        }
    }


    public int mostBooked(int n, int[][] meetings) {
        int[] roomCount = new int[n];
        Arrays.sort(meetings, (a,b)-> Integer.compare(a[0], b[0]));
        PriorityQueue<Pair> nextAvailableRoom = new PriorityQueue<>();
        PriorityQueue<Integer> roomAllotment = new PriorityQueue<>();

        for(int i=0; i<n; i++){
            roomAllotment.add(i);
        }

        for(int i=0; i<meetings.length; i++){
            int start = meetings[i][0];
            int end = meetings[i][1];

            while(!nextAvailableRoom.isEmpty() && nextAvailableRoom.peek().endTime <= start){
                Pair availableRoom = nextAvailableRoom.remove();
                int roomNumber = availableRoom.room;
                roomAllotment.add(roomNumber);
            }
            if(roomAllotment.isEmpty()){
                Pair nextAvailable = nextAvailableRoom.remove();
                int availableRoomNumber = nextAvailable.room;
                int endTimeForCurrentRoom = nextAvailable.endTime;
                roomCount[availableRoomNumber]++;
                nextAvailableRoom.add(new Pair(availableRoomNumber, endTimeForCurrentRoom + (end - start)));
            }else{
                int availableRoomNumber = roomAllotment.remove();
                roomCount[availableRoomNumber]++;
                nextAvailableRoom.add(new Pair(availableRoomNumber, end));
            }
        }

        int max = 0;
        int roomNumber = 0;
        for(int i=0; i<n; i++){
            if(roomCount[i] > max){
                max = roomCount[i];
                roomNumber = i;
            }
        }
        return roomNumber;
    }
}