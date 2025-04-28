class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length == 1){
            return intervals;
        }
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0],b[0]));
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>(Arrays.asList(intervals[0][0], intervals[0][1])));
        
        for(int i=1; i<intervals.length; i++){
            int prevEnd = result.get(result.size() - 1).get(1);
            if(intervals[i][0] <= prevEnd){
                prevEnd = Math.max(intervals[i][1], prevEnd);
                result.get(result.size() - 1).set(1, prevEnd);
            }else{
                result.add(new ArrayList<>(Arrays.asList(intervals[i][0], intervals[i][1])));
            }
        }

        int[][] r = new int[result.size()][2];
        for(int i=0; i<result.size(); i++){
            r[i][0] = result.get(i).get(0);
            r[i][1] = result.get(i).get(1);
        }
        return r;
    }
}