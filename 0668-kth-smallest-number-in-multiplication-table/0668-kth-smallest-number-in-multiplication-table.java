class Solution {

    public int upperBound(int target, int n, int m){
        int count = 0;
        for(int row=1; row<=n; row++){
            int low = 0, high = m - 1;
            while(low <= high){
                int mid = low + (high - low) / 2;
                if(row*(mid+1) <= target){
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            count += low;
        }
        return count;
    }

    public int findKthNumber(int n, int m, int k) {
        int low = 1;
        int high = n*m;

        while(low < high){
            int mid = low + (high - low) / 2;
            int count = upperBound(mid, n, m);
            if(count >= k){
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}