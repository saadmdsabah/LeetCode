class Solution {

    public int lowerBS(int[] arr, int left, int right, int target){
        int result = -1;
        while(left <= right){
            int mid = (left + right) / 2;
            if(arr[mid] <= target){
                result = mid;
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return result;
    }

    public int higherBS(int[] arr, int left, int right, int target){
        int result = -1;
        while(left <= right){
            int mid = (left + right) / 2;
            if(arr[mid] >= target){
                result = mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return result;
    }

    public long countFairPairs(int[] arr, int lower, int upper) {
        long count = 0;
        Arrays.sort(arr);

        for(int i = 0; i < arr.length - 1; i++){
            int l = higherBS(arr, i + 1, arr.length - 1, lower - arr[i]);
            int r = lowerBS(arr, i + 1, arr.length - 1, upper - arr[i]);
            
            if(l != -1 && r != -1 && r >= l){
                count += (r - l + 1);
            }
        }
        return count;
    }
}
