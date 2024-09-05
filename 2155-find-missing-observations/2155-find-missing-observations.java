class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int sum = 0;
        for(int i : rolls){
            sum += i;
        }
        int m = rolls.length + n;
        int toFind = mean*m - sum;

        int[] result = new int[n];
        while(toFind != 0){
            for(int i=0; i<n; i++){
                if(toFind == 0){
                    break;
                }
                result[i] += 1;
                if(result[i] >= 7){
                    return new int[0];
                }
                toFind -= 1;
            }
        }
        for(int i=0; i<n; i++){
            if(result[i] == 0){
                return new int[0];
            }
        }
        return result;
    }
}