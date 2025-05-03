class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        ArrayList<Integer> possibleCandidates = new ArrayList<>();
        possibleCandidates.add(tops[0]);
        possibleCandidates.add(bottoms[0]);
        int result = Integer.MAX_VALUE;
        for(int i : possibleCandidates){
            boolean valid = true;
            int countTops = 0;
            int countBottoms = 0;
            for(int j=0; j<tops.length; j++){
                if(!(tops[j] == i || bottoms[j] == i)){
                    valid = false;
                    break;
                }else if(tops[j] != i){
                    countTops++;
                }else if(bottoms[j] != i){
                    countBottoms++;
                }
            }
            if(valid) result = Math.min(result, Math.min(countTops, countBottoms));
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}