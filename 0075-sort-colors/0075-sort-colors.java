class Solution {
    public void sortColors(int[] arr) {
        int zeros = 0;
        int ones = 0;
        int twos = 0;
        
        for(int i=0; i<arr.length; i++){
            if(arr[i] == 0){
                zeros++;
            }else if(arr[i] == 1){
                ones++;
            }else{
                twos++;
            }
        }
        int i = 0;
        while(zeros > 0 && i < arr.length){
            arr[i] = 0;
            zeros--;
            i++;
        }
        while(ones > 0 && i < arr.length){
            arr[i] = 1;
            ones--;
            i++;
        }
        while(twos > 0 && i < arr.length){
            arr[i] = 2;
            twos--;
            i++;
        }
    }
}