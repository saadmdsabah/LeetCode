class Solution {
    public int findKthPositive(int[] arr, int k) {
        int prev = 0;
        int missing = -1;
        for(int i=0; i<arr.length; i++){
            missing = arr[i] - prev - 1;
            if(missing >= k){
                return prev + k;
            }else{
                k -= missing;
            }
            prev = arr[i];
        }
        // if(missing == -1){
        //     return arr[arr.length - 1] + k;
        // }else{
        //     return arr[]
        // }
        return arr[arr.length - 1] + k;
    }
}