class Solution {
    public int minBitFlips(int start, int goal) {
        int xor = start^goal;
        int nof1 = 0;
        while(xor > 0){
            if(xor%2==1){
                nof1 += 1;
            }
            xor = xor/2;
        }
        return nof1;
    }
}