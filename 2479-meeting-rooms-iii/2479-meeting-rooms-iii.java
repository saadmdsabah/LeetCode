class Solution {
    public int mostBooked(int n, int[][] meetings) {
        int[] roomCount = new int[n];
        long[] roomLastEndTime = new long[n];
        Arrays.sort(meetings, (a,b)-> Integer.compare(a[0], b[0]));

        for(int i=0; i<meetings.length; i++){
            int start = meetings[i][0];
            int end = meetings[i][1];
            long minEndTime = Long.MAX_VALUE;
            int minRoomNumber = 0;
            boolean available = false;

            for(int room=0; room<n; room++){
                if(roomLastEndTime[room] <= start){
                    roomLastEndTime[room] = end;
                    roomCount[room]++;
                    available = true;
                    break;
                }

                if(minEndTime > roomLastEndTime[room]){
                    minEndTime = roomLastEndTime[room];
                    minRoomNumber = room;
                }
            }

            if(!available){
                roomLastEndTime[minRoomNumber] = minEndTime + end - start;
                roomCount[minRoomNumber]++;
            }
        }

        int roomNumber = 0;
        int max = 0;
        for(int i=0; i<n; i++){
            if(roomCount[i] > max){
                max = roomCount[i];
                roomNumber = i;
            }
        }
        return roomNumber;
    }
}