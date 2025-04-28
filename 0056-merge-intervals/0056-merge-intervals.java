class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length == 1){
            return intervals;
        }
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0],b[0]));
        List<List<Integer>> result = new ArrayList<>();

        for(int i=0;i<intervals.length; i++){
            int start = intervals[i][0];
            int end = intervals[i][1];
            int j = i+1;

            for(;j<intervals.length;j++){
                if(end >= intervals[j][0]){
                    if(end < intervals[j][1]){
                        end = intervals[j][1];
                    }
                }else{
                    break;
                }
            }
            i = j-1;
            result.add(new ArrayList<>(List.of(start, end)));
        }
        int[][] r = new int[result.size()][2];
        int i = 0;
        for(List<Integer> temp : result){
            r[i][0] = temp.get(0); 
            r[i][1] = temp.get(1); 
            i++;
        }
        return r;
    }
}