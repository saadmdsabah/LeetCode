class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> result = new ArrayList<>();

        int prev = groups[0];
        result.add(words[0]);

        for(int i=1; i<words.length; i++){
            if(groups[i] != prev){
                prev = groups[i];
                result.add(words[i]);
            }
        }
        return result;
    }
}