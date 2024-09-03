class Solution {
    public int getLucky(String s, int k) {
        int sum=0;
        String temp = "";

        for(int i=0;i<s.length();i++){
            temp = temp + ((int) s.charAt(i) - 96);
        }

        while(k>0){
            sum = 0;
            for(int i=0;i<temp.length();i++){
                sum += temp.charAt(i) - '0';
            }
            temp = String.valueOf(sum);
            k--;
        }
        return sum;
    }
}