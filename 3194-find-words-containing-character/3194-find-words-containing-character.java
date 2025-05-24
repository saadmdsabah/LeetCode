class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> result = new ArrayList<>();

        for(int i=0; i<words.length; i++){
            if(words[i].chars().anyMatch(ch->ch==x)){
                result.add(i);
            }
        }
        return result;
    }
}