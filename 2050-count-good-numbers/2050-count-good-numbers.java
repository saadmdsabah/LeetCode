class Solution {
    int mod = 1000000007;
    public long pow(long x, long n){
        long result = 1;
        while(n > 0){
            if(n%2 == 1){
                result = (result*x)%mod;
            }
            n = n/2;
            x = (x*x)%mod;
        }
        return result;
    }

    public int countGoodNumbers(long n) {
        long r = n/2;
        long result = pow(20, n/2);
        if(n%2 == 1){
            result = (result*5)%mod;
        }
        return (int) result;
    }
}