class Solution {
    public int candy(int[] ratings) {
        int[] left = new int[ratings.length];
        for(int i=0; i<ratings.length; i++){
            if(i - 1 >= 0){
                if(ratings[i] > ratings[i-1]){
                    left[i] = left[i-1] + 1;
                }else{
                    left[i] = 1;
                }
            }else{
                left[i] = 1;
            }
        }

        int sum = Math.max(1, left[ratings.length - 1]);
        int curr = 1;
        int prev = 1;
        for(int i=ratings.length-2; i>=0; i--){
            if(ratings[i] > ratings[i+1]){
                curr = prev + 1;
                prev = curr;
            }else{
                curr = 1;
                prev = 1;
            }
            sum += Math.max(curr, left[i]);
        }
        return sum;
    }
}