class Solution {
    public int lengthAfterTransformations(String s, int t) {
        int[] map = new int[26];
        int mod = 1000000007;
        for(int i=0; i<s.length(); i++){
            map[s.charAt(i) - 'a']++;
        }

        for(int i=0; i<t; i++){
            int z = map[25];
            map[25] = 0;
            for(int j=25; j>=1; j--){
                map[j] = map[j-1];
            }
            map[0] = z;
            map[1] = (map[1] + z)%mod;
        }

        int result = 0;
        for(int i=0; i<26; i++){
            result = (result + map[i])%mod;
        }
        return result;
    }
}