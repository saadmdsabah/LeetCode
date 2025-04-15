class Solution {
    public int reverse(int x) {
        int result = 0;
        String num = String.valueOf(Math.abs(x)); 

        for(int i=num.length()-1; i>=0; i--){
            try{
                int n = num.charAt(i) - '0';
                int mul = (int) Math.pow(10, i);
                int add = Math.multiplyExact(n, mul);
                result = Math.addExact(result, add);
            } catch(ArithmeticException e){
                return 0;
            }   
        }
        if(x < 0){
            try{
                result = Math.multiplyExact(result, -1);
            } catch(ArithmeticException e){
                return 0;
            }
        }
        return result;
    }
}