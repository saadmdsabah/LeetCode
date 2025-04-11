class Solution {
    public String frequencySort(String s) {
        int[] freq = new int[62];
        for(int i=0; i<s.length(); i++){
            int ascii = (int) s.charAt(i);
            if(ascii >= 48 && ascii <= 57){
                freq[ascii - 48]++;
            }else if(ascii >= 97 && ascii <= 122){
                freq[ascii - 87]++;
            }else{
                freq[ascii - 29]++;
            }
        }

        int charCount = 0;
        for(int i=0; i<62; i++){
            if(freq[i] != 0){
                charCount++;
            }
        }

        StringBuilder sb = new StringBuilder("");
        
        for(int i=0; i<charCount; i++){
            int maxCount = 0;
            char maxChar = '/';
            int maxCharindex = 0;
            for(int j=0; j<62; j++){
                if(freq[j] > maxCount){
                    maxCount = freq[j];
                    maxCharindex = j;
                    if(j >= 0 && j <= 9){
                        maxChar = (char) (j + 48);
                    }else if(j >= 10 && j <= 35){
                        maxChar = (char) (j + 87);
                    }else{
                        maxChar = (char) (j + 29);
                    }
                }
            }
            freq[maxCharindex] = 0;
            for(int j=0; j<maxCount; j++){
                sb.append(maxChar);
            }
        }

        return sb.toString();
    }
}