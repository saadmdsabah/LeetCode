//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] edge = new int[m][3];
            for (int i = 0; i < m; i++) {
                edge[i][0] = sc.nextInt();
                edge[i][1] = sc.nextInt();
                edge[i][2] = sc.nextInt();
            }
            Solution obj = new Solution();
            int res[] = obj.shortestPath(n, m, edge);
            for (int i = 0; i < n; i++) {
                System.out.print(res[i] + " ");
            }
            System.out.println();

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    
    class Pair{
        int node;
        int weight;
        public Pair(int node, int weight){
            this.node = node;
            this.weight = weight;
        }
    }
    
    public void dfs(ArrayList<ArrayList<Pair>> graph, boolean[] visited, int source, Stack<Integer> topo){
        visited[source] = true;
        for(int i=0; i<graph.get(source).size(); i++){
            Pair currPair = graph.get(source).get(i);
            int currNode = currPair.node;
            if(!visited[currNode]){
                dfs(graph, visited, currNode, topo);
            }
        }
        topo.push(source);
    }
    
    public int[] shortestPath(int V, int E, int[][] edges) {
        ArrayList<ArrayList<Pair>> graph = new ArrayList<>();
        for(int i=0; i<V; i++){
            graph.add(new ArrayList<Pair>());
        }
        
        for(int i=0; i<E; i++){
            graph.get(edges[i][0]).add(new Pair(edges[i][1], edges[i][2]));
        }
        
        Stack<Integer> topo = new Stack<>();
        boolean[] visited = new boolean[V];
        for(int i=0; i<V; i++){
            if(!visited[i]){
                dfs(graph, visited, 0, topo);
            }
        }
        
        int[] result = new int[V];
        Arrays.fill(result, (int) 1e9);
        
        result[0] = 0;
        while(!topo.isEmpty()){
            int node = topo.pop();
            
            for(int i=0; i<graph.get(node).size(); i++){
                Pair currPair = graph.get(node).get(i);
                int currNode = currPair.node;
                int weight = currPair.weight;
                
                int valueOfNode = result[node];
                if(valueOfNode + weight < result[currNode]){
                    result[currNode] = valueOfNode + weight;
                }
            }
        }
        
        for(int i=0; i<V; i++){
            if(result[i] == (int) 1e9) result[i] = -1;
        }
        
        return result;
    }
}