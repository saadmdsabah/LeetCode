class Solution {
    public String countAndSay(int n) {
        StringBuilder result = new StringBuilder("1");
        for(int i=0; i<n-1; i++){
            StringBuilder temp = new StringBuilder("");
            for(int j=0; j<result.length(); j++){
                char present = result.charAt(j);
                int count = 1;
                int k = j+1;
                while(k<result.length() && present == result.charAt(k)){
                    count++;
                    k++;
                }
                j = k-1;
                temp.append(count + "" +present);
            }
            result = temp;
        }
        return result.toString();
    }
}