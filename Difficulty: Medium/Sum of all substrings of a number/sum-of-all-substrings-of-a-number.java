class Solution {
    
    static class Pair{
        int startingIndex;
        int endingIndex;
        public Pair(int startingIndex, int endingIndex){
            this.startingIndex = startingIndex;
            this.endingIndex = endingIndex;
        }
    }
    
    public static int sumSubstrings(String s) {
        int sum = 0;
        Queue<Pair> q = new LinkedList<>();
        
        for(int i=0; i<s.length(); i++){
            q.add(new Pair(i, i));
        }
            
        while(!q.isEmpty()){
            Pair currPair = q.remove();
            int startingIndex = currPair.startingIndex;
            int endingIndex = currPair.endingIndex;
            
            String currString = s.substring(startingIndex, endingIndex + 1);
            sum += Integer.parseInt(currString);
            if(endingIndex + 1 < s.length()){
                q.add(new Pair(startingIndex, endingIndex + 1));
            }
        }
        return sum;
    }
}