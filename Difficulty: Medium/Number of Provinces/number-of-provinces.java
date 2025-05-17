//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int V = Integer.parseInt(read.readLine());
            
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            for(int i=0; i<V; i++)
            {
                String S[] = read.readLine().split(" ");
                ArrayList<Integer> temp = new ArrayList<>();
                for(int j=0; j<V; j++)
                    temp.add(Integer.parseInt(S[j]));
                adj.add(temp);
            }

            Solution ob = new Solution();
            System.out.println(ob.numProvinces(adj,V));
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    
    public static void bfs(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int source){
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        visited[source] = true;
        while(!q.isEmpty()){
            int currNode = q.remove();
            for(int i=0; i<adj.get(currNode).size(); i++){
                if(!visited[adj.get(currNode).get(i)]){
                    q.add(adj.get(currNode).get(i));
                    visited[adj.get(currNode).get(i)] = true;
                }
            }
        }
    }
    
    static int numProvinces(ArrayList<ArrayList<Integer>> isConnected, int V) {
        boolean[] visited = new boolean[V];

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(V);
        for(int i=0; i<V; i++){
            adj.add(new ArrayList<Integer>());
        }
        
        for(int i=0; i<V; i++){
            for(int j=0; j<V; j++){
                if(i != j && isConnected.get(i).get(j) == 1){
                    adj.get(i).add(j);
                }
            }
        }

        int count = 0;
        for(int i=0; i<adj.size(); i++){
            if(!visited[i]){
                count++;
                bfs(adj, visited, i);
            }
        }
        return count;
    }
};