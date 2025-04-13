class Solution {
    public double myPow(double x, int n) {
        long N = n;
        N = Math.abs(N);
        double result = 1.0;
        while(N > 0){
            if(N%2 == 1){
                result *= x;
            }
            x = x*x;
            N = N/2;
        }
        if(n < 0){
            return 1/result;
        }
        return result;
    }
}