class Solution {
    public int removeElement(int[] arr, int target) {
        int i = 0;
        int prev = 0;
        int n = arr.length;

        while (i < n) {
            if (arr[i] != target) {
                arr[prev] = arr[i];
                prev++;
            }
            i++;
        }
        return prev;   
    }
}