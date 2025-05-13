class Solution {
    public int[] findEvenNumbers(int[] digits) {
        int[] map = new int[10];
        for(int i : digits){
            map[i]++;
        }

        ArrayList<Integer> result = new ArrayList<>();
        for(int i=1; i<10; i++){
            if(map[i] == 0) continue;
            map[i]--;
            for(int j=0; j<10; j++){
                if(map[j] == 0) continue;
                map[j]--;
                for(int k=0; k<=8; k+=2){
                    if(map[k] == 0) continue;
                    map[k]--;
                    int digit = 100*i+10*j+k;
                    result.add(digit);
                    map[k]++;
                }
                map[j]++;
            }
            map[i]++;
        }

        int[] d = new int[result.size()];
        for(int i=0; i<result.size(); i++){
            d[i] = result.get(i);
        }
        return d;
    }
}