class Solution {
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int count = 0;
        int[] freq = new int[1001];
        int n = arr.length;
        for(int j=0; j<n-1; j++){
            for(int k=j+1; k<n; k++){
                if(Math.abs(arr[j] - arr[k]) <= b){
                    int r = Math.min(arr[j] + a, arr[k] + c);
                    r = Math.min(r, 1000);
                    int l = Math.max(arr[j] - a, arr[k] - c);
                    l = Math.max(l, 0);
                    if(l <= r){
                        count += freq[r] - (l == 0 ? 0 : freq[l - 1]);
                    }
                }
            }
            for(int i=arr[j]; i<1001; i++){
                freq[i]++;
            }
        }
        return count;
    }
}