//{ Driver Code Starts
// Initial Template for Java
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
            boolean ans = obj.isCycle(V, edges);
            System.out.println(ans ? "true" : "false");
            System.out.println("~");
        }
        sc.close();
    }
}

// } Driver Code Ends


class Solution {
    
    public boolean dfs(boolean[] visited, int parent, ArrayList<ArrayList<Integer>> graph, int source){
        visited[source] = true;
        for(int i=0; i<graph.get(source).size(); i++){
            int nextNode = graph.get(source).get(i);
            if(visited[nextNode] && nextNode != parent){
                return true;
            }
            if(!visited[nextNode]){
                if(dfs(visited, source, graph, nextNode)) return true;
            }
        }
        return false;
    }
    
    public boolean isCycle(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        
        for(int i=0; i<V; i++){
            graph.add(new ArrayList<Integer>());
        }
        
        for(int i=0; i<edges.length; i++){
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }
        
        boolean[] visited = new boolean[V];
        
        
        for(int i=0; i<V; i++){
            if(!visited[i]){
                if(dfs(visited, -1, graph, i)) return true;
            }
        }
        
        return false;
    }
}