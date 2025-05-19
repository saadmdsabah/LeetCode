//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int V = sc.nextInt();
            int E = sc.nextInt();
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }

            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                adj.get(u).add(v);
                adj.get(v).add(u); // Since the graph is undirected
            }

            int src = sc.nextInt();

            Solution obj = new Solution();
            int[] res = obj.shortestPath(adj, src);

            for (int i = 0; i < res.length; i++) {
                System.out.print(res[i] + " ");
            }
            System.out.println();
            System.out.println("~");
        }
    }
}

// } Driver Code Ends



class Solution {
    
    class Pair{
        int node;
        int value;
        public Pair(int node, int value){
            this.node = node;
            this.value = value;
        }
    }
    
    public int[] shortestPath(ArrayList<ArrayList<Integer>> graph, int src) {
        int[] result = new int[graph.size()];
        
        Arrays.fill(result, (int) 1e9);
        result[src] = 0;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(src, 0));
        
        while(!q.isEmpty()){
            Pair currPair = q.remove();
            int currNode = currPair.node;
            int currValue = currPair.value;
            
            for(int i=0; i<graph.get(currNode).size(); i++){
                int newNode = graph.get(currNode).get(i);
                if(currValue + 1 < result[newNode]){
                    result[newNode] = currValue + 1;
                    q.add(new Pair(newNode, result[newNode]));
                }
            }
        }
        
        for(int i=0; i<result.length; i++){
            if(result[i] == (int) 1e9){
                result[i] = -1;
            }
        }
        return result;
        
    }
}
