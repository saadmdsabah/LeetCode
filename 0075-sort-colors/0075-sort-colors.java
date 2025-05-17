class Solution {

    public void swap(int i, int j, int[] arr){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void sortColors(int[] arr) {
        int low = 0;
        int mid = 0;
        int high = arr.length - 1;

        while(mid <= high){
            if(arr[mid] == 2){
                swap(mid, high, arr);
                high--;
            }else if(arr[mid] == 0){
                swap(low, mid, arr);
                mid++;
                low++;
            }else{
                mid++;
            }
        }
    }
}