class Solution {
    public int longestPalindrome(String[] words) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        int count = 0;
        boolean hasOddCenter = false;

        for (String word : map.keySet()) {
            String reversed = new StringBuilder(word).reverse().toString();

            // Case 1: symmetric word like "gg"
            if (word.equals(reversed)) {
                int freq = map.get(word);
                count += (freq / 2) * 4;
                if (freq % 2 == 1) {
                    hasOddCenter = true;
                }
            } 
            // Case 2: word and its reverse (e.g., "ab" & "ba")
            else if (map.containsKey(reversed)) {
                int pairs = Math.min(map.get(word), map.get(reversed));
                count += pairs * 4;
                // To prevent double-counting
                map.put(word, 0);
                map.put(reversed, 0);
            }
        }

        if (hasOddCenter) {
            count += 2;  // center piece
        }

        return count;
    }
}
