class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] prefix = new int[arr.length + 1];

        for(int i=1; i<prefix.length; i++){
            prefix[i] = arr[i-1]^prefix[i-1];
        }
        int[] result = new int[queries.length];
        int index = 0;
        for(int i[] : queries){
            result[index++] = prefix[i[1] + 1]^prefix[i[0]];
        }
        return result;
    }
}