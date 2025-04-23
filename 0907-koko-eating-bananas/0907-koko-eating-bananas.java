class Solution {

    public boolean isValid(int[] piles, int rate, int h){
        long hours = 0;
        for(int i : piles){
            hours += (i + rate - 1) / rate; 
            if (hours > h) return false;
        }
        return hours <= h;
    }


    public int minEatingSpeed(int[] piles, int h) {
        long low = 1;
        long high = 0;
        for(int i : piles){
            high = Math.max(high, i);
        }
        int min = (int) high;

        while(low <= high){
            long mid = (high - low)/2 + low;
            if(isValid(piles, (int) mid, h)){
                min = Math.min(min, (int) mid);
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return min;
    }
}