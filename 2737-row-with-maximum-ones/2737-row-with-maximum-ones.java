class Solution {

    public int indexAndCountBinarySearch(int[][] mat, int row){
        int low = 0;
        int high = mat[row].length - 1;
        int index = mat[row].length;
        while(low <= high){
            int mid = (high - low)/2 + low;
            if(mat[row][mid] == 1){
                index = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return mat[row].length - index;
    }

    public int[] rowAndMaximumOnes(int[][] mat) {
        int index = 0;
        int count = 0;
        for(int i=0; i<mat.length; i++){
            Arrays.sort(mat[i]);
        }
        for(int i=0; i<mat.length; i++){
            int curr = indexAndCountBinarySearch(mat, i);
            if(curr > count){
                index = i;
                count = curr;
            }
        }
        return new int[]{index,count};
    }
}