//{ Driver Code Starts
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = Integer.parseInt(sc.nextLine());

        while (t-- > 0) {
            int V = Integer.parseInt(sc.nextLine());
            int E = Integer.parseInt(sc.nextLine());

            List<int[]> edgeList = new ArrayList<>();

            for (int i = 0; i < E; i++) {
                String[] parts = sc.nextLine().split(" ");
                int u = Integer.parseInt(parts[0]);
                int v = Integer.parseInt(parts[1]);
                int w = Integer.parseInt(parts[2]);
                edgeList.add(new int[] {u, v, w});
                edgeList.add(new int[] {v, u, w});
            }

            int[][] edges = new int[edgeList.size()][3];
            for (int i = 0; i < edgeList.size(); i++) {
                edges[i] = edgeList.get(i);
            }

            int src = Integer.parseInt(sc.nextLine());

            Solution obj = new Solution();
            int[] res = obj.dijkstra(V, edges, src);

            for (int val : res) {
                System.out.print(val + " ");
            }
            System.out.println();
            System.out.println("~");
        }

        sc.close();
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    
    class Pair{
        int node;
        int value;
        public Pair(int n, int v){
            this.node = n;
            this.value = v;
        }
    }
    
    public int[] dijkstra(int V, int[][] edges, int src) {
        ArrayList<ArrayList<Pair>> graph = new ArrayList<>();
        for(int i=0; i<V; i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0; i<edges.length; i++){
            graph.get(edges[i][0]).add(new Pair(edges[i][1], edges[i][2]));
            graph.get(edges[i][1]).add(new Pair(edges[i][0], edges[i][2]));
        }
        
        
        int[] values = new int[V];
        Arrays.fill(values, Integer.MAX_VALUE);
        boolean[] visited = new boolean[V];
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.value - b.value);
        pq.add(new Pair(src, 0));
        values[src] = 0;
        
        while(!pq.isEmpty()){
            Pair curr = pq.remove();
            int currNode = curr.node;
            int value = curr.value;
            visited[currNode] = true;
            
            for(int i=0; i<graph.get(currNode).size(); i++){
                Pair p = graph.get(currNode).get(i);
                int node = p.node;
                if(visited[node]) continue;
                int edgeWeight = p.value;
                if(value + edgeWeight < values[node]){
                    values[node] = value + edgeWeight;
                    pq.add(new Pair(node, values[node]));
                }
            }
        }
        return values;
    }
}






