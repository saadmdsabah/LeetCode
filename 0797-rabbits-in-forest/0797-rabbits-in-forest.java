class Solution {
    public int numRabbits(int[] answers) {
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<answers.length; i++){
            if(answers[i] == 0){
                count++;
            }else if(!map.containsKey(answers[i])){
                count += 1 + answers[i];
                map.put(answers[i], answers[i]);
            }else{
                map.put(answers[i], map.get(answers[i]) - 1);
                if(map.get(answers[i]) == 0){
                    map.remove(answers[i]);
                }
            }
        }
        return count;
    }
}