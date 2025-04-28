class Solution {

    public int jump(int[] arr) {
        int l = 0;
        int r = 0;
        int steps = 0;
        
        while(r < arr.length - 1){
            int farthest = 0;
            for(int i=l; i<=r; i++){
                farthest = Math.max(farthest, arr[i] + i);
            }
            steps++;
            l = r + 1;
            r = farthest;
        }
        return steps;
    }
}