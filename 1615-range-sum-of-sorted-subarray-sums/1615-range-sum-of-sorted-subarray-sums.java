class Solution {

    class Pair{
        int val;
        int index;
        public Pair(int v, int i){
            this.val = v;
            this.index = i;
        }
    }

    public int rangeSum(int[] nums, int n, int left, int right) {
        int count = 1;
        int mod = (int) 1e9 + 7;
        PriorityQueue<Pair> sum = new PriorityQueue<>((a,b)->a.val - b.val);

        for(int i=0; i<n; i++){
            sum.add(new Pair(nums[i], i));
        }

        long result = 0;
        while(count <= right){
            Pair currPair = sum.remove();
            int currSum = currPair.val;
            int index = currPair.index;

            if(count >= left) result = (result + currSum)%mod;
            if(index + 1 < n){
                sum.add(new Pair(currSum + nums[index+1], index+1));
            }
            count++;
        }
        return (int) result;
    }
}