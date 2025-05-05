class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        if(intervals.length == 0){
            list.add(new ArrayList<Integer>(Arrays.asList(newInterval[0], newInterval[1])));
            int[][] result = new int[list.size()][2];
            for(int i=0; i<result.length; i++){
                result[i][0] = list.get(i).get(0);
                result[i][1] = list.get(i).get(1);
            }
            return result;
        }
        int previousEnd = Integer.MIN_VALUE;
        boolean taken = false;

        for(int i=0; i<intervals.length; i++){
            if(newInterval[0] > previousEnd && newInterval[1] < intervals[i][0]){
                list.add(new ArrayList<Integer>(Arrays.asList(newInterval[0], newInterval[1])));
                for(; i<intervals.length; i++){
                    list.add(new ArrayList<Integer>(Arrays.asList(intervals[i][0], intervals[i][1])));
                }
                taken = true;
                break;
            }else if(intervals[i][0] <= newInterval[0] && newInterval[0] <= intervals[i][1]){
                int newStart = intervals[i][0];
                int newEnd = Math.max(intervals[i][1], newInterval[1]);
                while(i < intervals.length && intervals[i][0] <= newEnd){
                    newEnd = Math.max(newEnd, intervals[i][1]);
                    i++;
                }
                taken = true;
                list.add(new ArrayList<Integer>(Arrays.asList(newStart, newEnd)));
                for(; i<intervals.length; i++){
                    list.add(new ArrayList<Integer>(Arrays.asList(intervals[i][0], intervals[i][1])));
                }
                break;
            }else if(newInterval[0] <= intervals[i][0] && intervals[i][0] <= newInterval[1]){
                int newStart = Math.min(intervals[i][0], newInterval[0]);
                int newEnd = Math.max(intervals[i][1], newInterval[1]);
                while(i < intervals.length && intervals[i][0] <= newEnd){
                    newEnd = Math.max(newEnd, intervals[i][1]);
                    i++;
                }
                taken = true;
                list.add(new ArrayList<Integer>(Arrays.asList(newStart, newEnd)));
                for(; i<intervals.length; i++){
                    list.add(new ArrayList<Integer>(Arrays.asList(intervals[i][0], intervals[i][1])));
                }
                break;
            }else{
                list.add(new ArrayList<Integer>(Arrays.asList(intervals[i][0], intervals[i][1])));
                previousEnd = intervals[i][1];
            }
        }

        if(!taken){
            list.add(new ArrayList<Integer>(Arrays.asList(newInterval[0], newInterval[1])));
        }

        int[][] result = new int[list.size()][2];
        for(int i=0; i<result.length; i++){
            result[i][0] = list.get(i).get(0);
            result[i][1] = list.get(i).get(1);
        }
        return result;
    }
}