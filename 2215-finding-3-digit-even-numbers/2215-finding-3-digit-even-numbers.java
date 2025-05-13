class Solution {
    public int[] findEvenNumbers(int[] digits) {
        int[] map = new int[10];
        for(int i : digits){
            map[i]++;
        }

        // ArrayList<Integer> result = new ArrayList<>();
        // for(int i=0; i<10; i++){
        //     if(map[i] == 0) continue;
        //     map[i]--;
        //     for(int j=i+1; j<10; j++){
        //         if(map[j] == 0) continue;
        //         map[j]--;
        //         for(int k=j+1; k<10; k++){
        //             if(map[k] == 0) continue;
        //             map[k]--;
        //             int digit = 100*i+10*j+k;
        //             if(digit >= 100 && digit%2 == 0){
        //                 result.add(100*i+10*j+k);
        //             }
        //             map[k]++;
        //         }
        //         map[j]++;
        //     }
        //     map[i]++;
        // }

        HashSet<Integer> result = new HashSet<>();
        for(int i=0; i<digits.length; i++){
            for(int j=0; j<digits.length; j++){
                for(int k=0; k<digits.length; k++){
                    if(i == j || j == k || k == i){
                        continue;
                    }
                    int digit = 100*digits[i] + 10*digits[j] + digits[k];
                    if(digit >= 100 && digit%2 == 0){
                        result.add(digit);
                    }
                }
            }
        }

        int[] d = new int[result.size()];
        int j = 0;
        for(int i : result){
            d[j++] = i;
        }
        Arrays.sort(d);
        return d;
    }
}