//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        while (tc-- > 0) {
            int V = sc.nextInt();
            int E = sc.nextInt();
            int[][] edges = new int[E][2];
            for (int i = 0; i < E; i++) {
                edges[i][0] = sc.nextInt();
                edges[i][1] = sc.nextInt();
            }

            Solution obj = new Solution();
            boolean ans = obj.isCyclic(V, edges);
            System.out.println(ans ? "true" : "false");
        }
        sc.close();
    }
}
// } Driver Code Ends


class Solution {
    
    public boolean dfs(int source, ArrayList<ArrayList<Integer>> graph, boolean[] visited, boolean[] pathVisited){
        if(visited[source] && pathVisited[source]){
            return true;
        }
        if(visited[source]){
            return false;
        }
        visited[source] = true;
        pathVisited[source] = true;
        
        for(int i=0; i<graph.get(source).size(); i++){
            if(dfs(graph.get(source).get(i), graph, visited, pathVisited)) return true;
        }
        pathVisited[source] = false;
        return false;
    }
    
    public boolean isCyclic(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0; i<V; i++){
            graph.add(new ArrayList<>());
        }
        
        for(int i=0; i<edges.length; i++){
            graph.get(edges[i][0]).add(edges[i][1]);
        }
        
        boolean[] visited = new boolean[V];
        boolean[] pathVisited = new boolean[V];
        
        for(int i=0; i<V; i++){
            if(dfs(i, graph, visited, pathVisited)) return true;
        }
        return false;
    }
}