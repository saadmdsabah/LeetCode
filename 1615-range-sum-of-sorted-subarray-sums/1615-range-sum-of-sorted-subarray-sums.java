class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        ArrayList<Integer> list = new ArrayList<>();
        int mod = (int) 1e9 + 7;

        for(int i=0; i<n; i++){
            long sum = 0;
            for(int j=i; j<n; j++){
                sum = (sum + nums[j])%mod;
                list.add((int) sum);
            }
        }

        Collections.sort(list);

        long result = 0;
        for(int i=left-1; i<right; i++){
            result = (result + list.get(i))%mod;
        }
        return (int) result%mod;
    }
}