class Solution {
    public int findComplement(int num) {
        String num_binary = "";
        while(num > 0){
            int rem = num%2;
            if(rem==1) rem = 0;
            else rem = 1;
            num_binary = rem + num_binary;
            num = num/2;
        }
        return Integer.parseInt(num_binary,2);
    }
}