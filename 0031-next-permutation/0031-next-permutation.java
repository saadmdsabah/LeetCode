class Solution {

    public void swap(int[] arr, int i, int j){
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    public void reverse(int[] arr, int i, int j){
        while(j>i){
            swap(arr,i,j);
            i++;
            j--;
        }
    }

    public void nextPermutation(int[] nums) {
        if(nums.length == 1 || nums.length ==0) return;
        int minInd = -1;
        for(int i=nums.length-2; i>=0; i--){
            if(nums[i] < nums[i+1]){
                minInd = i;
                break;
            }
        }
        if(minInd>=0){
            int maxInd = nums.length - 1;
            for(int i=nums.length - 1; i>=0; i--){
                if(nums[i] > nums[minInd]){
                    maxInd = i;
                    break;
                }
            }
            swap(nums,minInd,maxInd);
        }
        reverse(nums,minInd+1,nums.length-1);
    }
}