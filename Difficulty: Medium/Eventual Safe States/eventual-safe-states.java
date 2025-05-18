//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int V = sc.nextInt();
            int E = sc.nextInt();

            List<List<Integer>> adj = new ArrayList<>();

            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();

                adj.get(u).add(v);
            }

            Solution obj = new Solution();
            List<Integer> safeNodes = obj.eventualSafeNodes(V, adj);
            for (int i : safeNodes) {
                System.out.print(i + " ");
            }
            System.out.println();
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    
    public boolean dfs(List<Integer> result, List<List<Integer>> adj, boolean[] visited, boolean[] pathVisited, int source){
        if(visited[source] && pathVisited[source]){
            return true;
        }    
        if(visited[source]){
            return false;
        }
        
        visited[source] = true;
        pathVisited[source] = true;
        boolean cyclePresent = false;
        for(int i=0; i<adj.get(source).size(); i++){
            if(dfs(result, adj, visited, pathVisited, adj.get(source).get(i))){
                cyclePresent = true;
                break;
            }
        }
        if(cyclePresent){
            return true;
        }
        pathVisited[source] = false;
        result.add(source);
        return false;
    }
    
    List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {
        List<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[V];
        boolean[] pathVisited = new boolean[V];
        
        for(int i=0; i<V; i++){
            if(!visited[i]){
                dfs(result, adj, visited, pathVisited, i);
            }
        }
        Collections.sort(result);
        return result;
    }
}
