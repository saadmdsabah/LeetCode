import java.util.Collection;
class Solution {
    public int countLargestGroup(int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;

        for(int i=1; i<=n; i++){
            int sum = 0;
            int num = i;
            while(num > 0){
                sum += num%10;
                num = num / 10;
            }
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