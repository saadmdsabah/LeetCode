class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        if(tops.length != bottoms.length){
            return -1;
        }
        int[] map = new int[7];
        for(int i : tops){
            map[i]++;
        }
        for(int i : bottoms){
            map[i]++;
        }
        boolean notPossible = true;
        for(int i=1; i<7; i++){
            if(map[i] >= tops.length){
                notPossible = false;
                break;
            }
        }
        if(notPossible){
            return -1;
        }

        int result = Integer.MAX_VALUE;

        for(int i=1; i<7; i++){
            if(map[i] >= tops.length){
                boolean[] present = new boolean[tops.length];
                for(int j=0; j<tops.length; j++){
                    if(tops[j] == i || bottoms[j] == i){
                        present[j] = true;
                    }else{
                        present[j] = false;
                    }
                }
                boolean valid = true;
                for(boolean p : present){
                    if(!p){
                        valid = false;
                        break;
                    }
                }
                int countTops = 0;
                int countBottoms = 0;
                if(valid){
                    for(int j=0; j<tops.length; j++){
                        if(tops[j] != i){
                            countTops++;
                        }
                    }
                    for(int j=0; j<bottoms.length; j++){
                        if(bottoms[j] != i){
                            countBottoms++;
                        }
                    }
                    result = Math.min(result, Math.min(countTops, countBottoms));
                }
            }
        }
        if(result == Integer.MAX_VALUE){
            return -1;
        }
        return result;
    }
}