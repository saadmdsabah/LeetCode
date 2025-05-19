//{ Driver Code Starts
// Initial Template for Java
import java.util.*;


// } Driver Code Ends

// User function Template for Java
class Solution {
    public String findOrder(String[] words) {
    ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    for (int i = 0; i < 26; i++) {
        graph.add(new ArrayList<>());
    }

    int[] indegree = new int[26];
    Arrays.fill(indegree, -1);

    // Initialize indegree for all present characters
    for (String word : words) {
        for (char c : word.toCharArray()) {
            indegree[c - 'a'] = 0;
        }
    }

    for (int i = 0; i < words.length - 1; i++) {
        String s1 = words[i];
        String s2 = words[i + 1];

        // Check for invalid prefix condition
        if (s1.startsWith(s2) && s1.length() > s2.length()) {
            return "";
        }

        int len = Math.min(s1.length(), s2.length());
        for (int k = 0; k < len; k++) {
            char c1 = s1.charAt(k);
            char c2 = s2.charAt(k);
            if (c1 != c2) {
                int u = c1 - 'a';
                int v = c2 - 'a';
                graph.get(u).add(v);
                indegree[v]++;
                break;
            }
        }
    }

    Queue<Integer> q = new LinkedList<>();
    for (int i = 0; i < 26; i++) {
        if (indegree[i] == 0) {
            q.add(i);
        }
    }

    StringBuilder sb = new StringBuilder();
    while (!q.isEmpty()) {
        int curr = q.poll();
        sb.append((char)(curr + 'a'));
        for (int neighbor : graph.get(curr)) {
            indegree[neighbor]--;
            if (indegree[neighbor] == 0) {
                q.add(neighbor);
            }
        }
    }

    // Check if topological sort included all unique letters
    int totalChars = 0;
    for (int val : indegree) {
        if (val != -1) totalChars++;
    }

    return sb.length() == totalChars ? sb.toString() : "";
}

}


//{ Driver Code Starts.

public class GFG {
    private static boolean validate(String[] original, String order) {
        Map<Character, Integer> mp = new HashMap<>();
        for (String word : original) {
            for (char ch : word.toCharArray()) {
                mp.put(ch, 1);
            }
        }
        for (char ch : order.toCharArray()) {
            if (!mp.containsKey(ch)) {
                return false;
            }
            mp.remove(ch);
        }
        if (!mp.isEmpty()) {
            return false;
        }

        Map<Character, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            indexMap.put(order.charAt(i), i);
        }

        for (int i = 0; i < original.length - 1; i++) {
            String a = original[i];
            String b = original[i + 1];
            int k = 0, n = a.length(), m = b.length();

            while (k < n && k < m && a.charAt(k) == b.charAt(k)) {
                k++;
            }

            if (k < n && k < m &&
                indexMap.get(a.charAt(k)) > indexMap.get(b.charAt(k))) {
                return false;
            }
            if (k != n && k == m) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine()); // Number of test cases

        while (t-- > 0) {
            String[] words = sc.nextLine().split(" ");
            String[] original = Arrays.copyOf(words, words.length);

            Solution ob = new Solution();
            String order = ob.findOrder(words);

            if (order.isEmpty()) {
                System.out.println("\"\"");
            } else {
                System.out.println(validate(original, order) ? "true" : "false");
            }
            System.out.println("~");
        }

        sc.close();
    }
}

// } Driver Code Ends