class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->Integer.compare(a[1], b[1]));

        int endTime = -Integer.MIN_VALUE;
        int result = 0;
        for(int i=0; i<intervals.length; i++){
            if(intervals[i][0] >= endTime){
                result++;
                endTime = intervals[i][1];
            }
        }
        return intervals.length - result;
    }
}