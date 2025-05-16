class Solution {

    public boolean compareStrings(String s1, String s2, int group1, int group2){
        if(group1 == group2 || s1.length() != s2.length())  return false;
        
        int count = 0;
        for(int i=0; i<s1.length(); i++){
            if(s1.charAt(i) != s2.charAt(i)) count++;
        }
        return count == 1;
    }

    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        int[] dp = new int[words.length];
        Arrays.fill(dp, 1);
        int[] prevIndex = new int[words.length];
        for(int i=0; i<words.length; i++){
            prevIndex[i] = i;
        }

        int max = 0;
        int maxIndex = 0;
        for(int i=0; i<words.length; i++){
            for(int j=0; j<i; j++){
                if(compareStrings(words[i], words[j], groups[i], groups[j])){
                    if(dp[j] + 1 > dp[i]){
                        dp[i] = dp[j] + 1;
                        prevIndex[i] = j;
                    }
                }
            }
            if(dp[i] > max){
                max = dp[i];
                maxIndex = i;
            }
        }
        LinkedList<String> list = new LinkedList<>();
        while(prevIndex[maxIndex] != maxIndex){
            list.addFirst(words[maxIndex]);
            maxIndex = prevIndex[maxIndex];
        }
        list.addFirst(words[maxIndex]);
        List<String> result = new ArrayList<>(list);
        return result;
    }
}