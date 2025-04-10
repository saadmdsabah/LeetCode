class Solution {

    public boolean countIntervals(int[][] intervals){
        int count = 0;
        int prev = intervals[0][1];
        for(int i=1; i<intervals.length; i++){
            if(intervals[i][0] >= prev){
                count++;
                if(count == 2){
                    break;
                }
            }
            prev = Math.max(prev, intervals[i][1]);
        }
        if(count == 2){
            return true;
        }
        return false;
    }

    public boolean checkValidCuts(int n, int[][] rectangles) {
        int[][] xIntervals = new int[rectangles.length][2];
        int[][] yIntervals = new int[rectangles.length][2];

        for(int i=0; i<rectangles.length; i++){
            xIntervals[i][0] = rectangles[i][0];
            xIntervals[i][1] = rectangles[i][2];
            yIntervals[i][0] = rectangles[i][1];
            yIntervals[i][1] = rectangles[i][3];
        }

        Arrays.sort(xIntervals, (a,b)->Integer.compare(a[0], b[0]));
        Arrays.sort(yIntervals, (a,b)->Integer.compare(a[0], b[0]));
    
        return countIntervals(xIntervals) || countIntervals(yIntervals);
    }
}