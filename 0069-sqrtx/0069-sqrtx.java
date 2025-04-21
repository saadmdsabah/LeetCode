class Solution {
    public int mySqrt(int x) {
        if(x == 0 || x == 1){
            return x;
        }
        long low = 1;
        long high = x;
        long compare = (long) x;
        while(low <= high){
            long mid = (high - low)/2 + low;
            long val = mid*mid;
            if(val == compare){
                return (int) mid;
            }else if(val > compare){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return (int) high;
    }
}