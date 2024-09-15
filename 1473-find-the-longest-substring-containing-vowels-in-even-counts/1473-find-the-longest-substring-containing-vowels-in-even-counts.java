class Solution {
    public int findTheLongestSubstring(String s) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); // value, index
        HashMap<Character, Integer> charMap = new HashMap<>();
        charMap.put('a', 0);
        charMap.put('e', 1);
        charMap.put('i', 2);
        charMap.put('o', 3);
        charMap.put('u', 4);
        int count = 0;
        int max = 0;

        for(int i=0; i<s.length(); i++){
            if(charMap.containsKey(s.charAt(i))){
                count = count ^ (1 << charMap.get(s.charAt(i)));
            }
            if(map.containsKey(count)){
                max = Math.max(max, i - map.get(count));
            }else{
                map.put(count, i);
            }
        }
        return max;
    }
}