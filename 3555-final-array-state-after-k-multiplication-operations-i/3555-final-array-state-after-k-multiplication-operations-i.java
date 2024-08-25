class Solution {

    class Pair implements Comparable<Pair>{
        int number;
        int index;
        public Pair(int number, int index){
            this.number = number;
            this.index = index;
        }

        @Override
        public int compareTo(Pair other){
            if(this.number == other.number){
                return this.index - other.index;
            }
            return this.number - other.number;
        }
    }

    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(int i=0; i<nums.length; i++){
            pq.add(new Pair(nums[i], i));
        }
        for(int i=0; i<k; i++){
            Pair p = pq.remove();
            int number = p.number;
            int index = p.index;
            nums[index] = multiplier*number;
            pq.add(new Pair(nums[index], index));
        }
        return nums;
    }
}