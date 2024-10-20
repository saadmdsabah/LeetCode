class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1 || numRows == s.length()){
            return s;
        }
        String[] temp = new String[numRows];
        Arrays.fill(temp, "");
        int index = 0;
        boolean front = true;
        int left = 0;

        for(int i=0; i<s.length(); i++){
            if(index == 0){
                front = true;
                left = i;
            }
            if(front){
                temp[index] = temp[index] + s.charAt(i);
                index++;
            }
            if(!front){
                temp[index] = temp[index] + s.charAt(i);
                index--;
            }
            if(i-left+1 == numRows){
                front = false;
                index -= 2;
            }
        }
        String t = "";
        for(String r : temp){
            t += r;
        }
        return t;
    }
}