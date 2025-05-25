class Solution {
    public int longestPalindrome(String[] words) {
        HashMap<String, Integer> map = new HashMap<>();

        for(int i=0; i<words.length; i++){
            if(map.containsKey(words[i])){
                map.put(words[i], map.get(words[i]) + 1);
            }else{
                map.put(words[i], 1);
            }
        }

        int count = 0;
        boolean odd = false;

        for(int i=0; i<words.length; i++){
            StringBuilder temp = new StringBuilder(words[i]);
            temp.reverse();
            String newString = temp.toString();
            if(map.containsKey(newString)){
                if(newString.charAt(0) == newString.charAt(1)){
                    if(map.get(newString) >= 2){
                        count += 4;
                        map.put(newString, map.get(newString) - 2);
                    }else if(map.get(newString) != 0 && !odd){
                        count += 2;
                        odd = true;
                        map.put(newString, map.get(newString) - 1);
                    }
                }else{
                    if(map.containsKey(words[i]) && map.get(words[i]) != 0 && map.get(newString) != 0){
                        count += 4;
                        map.put(words[i], map.get(words[i]) - 1);
                        map.put(newString, map.get(newString) - 1);
                    }
                }
            }
        }
        return count;
    }
}