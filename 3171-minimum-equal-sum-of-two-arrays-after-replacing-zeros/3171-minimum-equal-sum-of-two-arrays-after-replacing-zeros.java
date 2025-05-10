class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        long sum1 = 0;
        long sum2 = 0;
        int count1 = 0;
        int count2 = 0;
        for(int i : nums1){
            if(i == 0){
                count1++;
                sum1++;
            }
            sum1 += i;
        }
        for(int i : nums2){
            if(i == 0){
                count2++;
                sum2++;
            }
            sum2 += i;
        }
        if(sum1 > sum2 && count2 == 0){
            return -1;
        }
        if(sum2 > sum1 && count1 == 0){
            return -1;
        }
        return Math.max(sum1, sum2);
    }
}