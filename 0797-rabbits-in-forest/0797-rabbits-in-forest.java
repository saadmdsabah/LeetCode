class Solution {
    public int numRabbits(int[] answers) {
        int count = 0;
        int[] map = new int[1001];

        for(int i=0; i<answers.length; i++){
            if(answers[i] == 0){
                count++;
            }else if(map[answers[i]] == 0){
                count += 1 + answers[i];
                map[answers[i]] = answers[i];
            }else{
                map[answers[i]]--;
            }
        }
        return count;
    }
}