class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        int previousEnd = Integer.MIN_VALUE;
        boolean taken = false;
        int i = 0;

        for(; i<intervals.length; i++){
            if(newInterval[0] > previousEnd && newInterval[1] < intervals[i][0]){
                list.add(new ArrayList<Integer>(Arrays.asList(newInterval[0], newInterval[1])));
                taken = true;
                break;
            }else if((intervals[i][0] <= newInterval[0] && newInterval[0] <= intervals[i][1]) || 
            (newInterval[0] <= intervals[i][0] && intervals[i][0] <= newInterval[1])){
                int newStart = Math.min(intervals[i][0], newInterval[0]);
                int newEnd = Math.max(intervals[i][1], newInterval[1]);
                while(i < intervals.length && intervals[i][0] <= newEnd){
                    newEnd = Math.max(newEnd, intervals[i][1]);
                    i++;
                }
                taken = true;
                list.add(new ArrayList<Integer>(Arrays.asList(newStart, newEnd)));
                break;
            }else{
                list.add(new ArrayList<Integer>(Arrays.asList(intervals[i][0], intervals[i][1])));
                previousEnd = intervals[i][1];
            }
        }

        for(; i<intervals.length; i++){
            list.add(new ArrayList<Integer>(Arrays.asList(intervals[i][0], intervals[i][1])));
        }
        
        if(!taken){
            list.add(new ArrayList<Integer>(Arrays.asList(newInterval[0], newInterval[1])));
        }
        int[][] result = new int[list.size()][2];
        for(int j=0; j<result.length; j++){
            result[j][0] = list.get(j).get(0);
            result[j][1] = list.get(j).get(1);
        }
        return result;
    }
}