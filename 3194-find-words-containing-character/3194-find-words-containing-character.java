class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> result = new ArrayList<>();

        for(int i=0; i<words.length; i++){
            int j = 0;
            int k = words[i].length() - 1;

            while(j <= k){
                if(words[i].charAt(j) == x || words[i].charAt(k) == x){
                    result.add(i);
                    break;
                }
                j++;k--;
            }
        }
        return result;
    }
}