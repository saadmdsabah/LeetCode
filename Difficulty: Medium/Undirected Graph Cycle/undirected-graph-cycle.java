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
    
    class Pair{
        int node;
        int parent;
        public Pair(int node, int parent){
            this.node = node;
            this.parent = parent;
        }
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
        
        for (int i = 0; i < V; i++) {
            if(!visited[i]) {
                Queue<Pair> q = new LinkedList<>();
                visited[i] = true;
                q.add(new Pair(i, -1));
        
                while (!q.isEmpty()) {
                    Pair currPair = q.remove();
                    int currNode = currPair.node;
                    int parent = currPair.parent;
        
                    for (int nextNode : graph.get(currNode)) {
                        if (visited[nextNode] && nextNode != parent) return true;
                        if (!visited[nextNode]) {
                            visited[nextNode] = true;
                            q.add(new Pair(nextNode, currNode));
                        }
                    }
                }
            }
        }

        
        return false;
    }
}