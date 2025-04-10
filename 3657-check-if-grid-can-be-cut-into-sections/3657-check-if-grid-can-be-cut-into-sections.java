class Solution {

    public boolean countIntervalsX(int[][] intervals){
        int count = 0;
        int prev = intervals[0][2];
        for(int i=1; i<intervals.length; i++){
            if(intervals[i][0] >= prev){
                count++;
                if(count == 2){
                    return true;
                }
            }
            prev = Math.max(prev, intervals[i][2]);
        }
        return false;
    }

    public boolean countIntervalsY(int[][] intervals){
        int count = 0;
        int prev = intervals[0][3];
        for(int i=1; i<intervals.length; i++){
            if(intervals[i][1] >= prev){
                count++;
                if(count == 2){
                    return true;
                }
            }
            prev = Math.max(prev, intervals[i][3]);
        }
        return false;
    }

    public boolean checkValidCuts(int n, int[][] rectangles) {
        Arrays.sort(rectangles, (a,b)->Integer.compare(a[0], b[0]));
        boolean x = countIntervalsX(rectangles);
        Arrays.sort(rectangles, (a,b)->Integer.compare(a[1], b[1]));
        boolean y = countIntervalsY(rectangles);
        return x || y;
    }
}