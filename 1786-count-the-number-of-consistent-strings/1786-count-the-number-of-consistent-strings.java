import java.util.ArrayList;

class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int count = 0;
        ArrayList<String> list = new ArrayList<>();
        String[] allowed_arr = allowed.split("");
        for(String e:allowed_arr){
            list.add(e);
        }
        boolean t_f = true;
        for(String word:words){
            for(char word_char : word.toCharArray()){
                if(list.contains(String.valueOf(word_char)) == false){
                    t_f = false;
                    break;
                }
                else{
                    t_f= true;
                }
            }
            if(t_f){
                count +=1;
            }
        }
        return count;
    }
}