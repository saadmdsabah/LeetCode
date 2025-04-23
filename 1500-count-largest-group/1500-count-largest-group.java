import java.util.Collection;
class Solution {

    public int numberSum(int n){
        if(n < 10){
            return n;
        }
        int len = (int) Math.floor(Math.log10(n)) + 1;
        int right = numberSum(n%((int) Math.pow(10, len/2)));
        n = n/((int) Math.pow(10, len/2));
        int left = numberSum(n);
        return left + right;
    }

    public int countLargestGroup(int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;

        for(int i=1; i<=n; i++){
            int sum = numberSum(i);
            if(map.containsKey(sum)){
                map.put(sum, map.get(sum) + 1);
                max = Math.max(map.get(sum),max);
            }else{
                map.put(sum, 1);
                max = Math.max(max, 1);
            }
        }
        int count = 0;
        Collection<Integer> values = map.values();
        for(int i : values){
            if(i == max){
                count++;
            }
        }
        return count;
    }
}