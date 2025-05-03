class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        if(tops.length != bottoms.length){
            return -1;
        }
        int[] map = new int[7];
        for(int i=0; i<tops.length; i++){
            map[tops[i]]++;
            map[bottoms[i]]++;
        }
        int result = Integer.MAX_VALUE;

        for(int i=1; i<7; i++){
            if(map[i] >= tops.length){
                boolean valid = true;
                int countTops = 0;
                int countBottoms = 0;
                for(int j=0; j<tops.length; j++){
                    if(!(tops[j] == i || bottoms[j] == i)){
                        valid = false;
                        break;
                    }else if(tops[j] != i){
                        countTops++;
                    }
                }
                if(!valid) break;
                for(int j=0; j<bottoms.length; j++){
                    if(bottoms[j] != i){
                        countBottoms++;
                    }
                }
                result = Math.min(result, Math.min(countTops, countBottoms));
            }
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}