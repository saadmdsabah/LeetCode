class Solution {
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int count = 0;
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                for(int k=j+1;k<arr.length;k++){
                    int d = Math.abs(arr[i] - arr[j]);
                    int e = Math.abs(arr[j] - arr[k]);
                    int f = Math.abs(arr[i] - arr[k]);
                    if(d<=a && e<=b && f<=c){
                        count += 1;
                    }
                }
            }
        }
        return count;
    }
}