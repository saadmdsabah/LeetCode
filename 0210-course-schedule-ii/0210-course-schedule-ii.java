class Solution {
    public int[] findOrder(int N, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<N; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] i : prerequisites){
            adj.get(i[1]).add(i[0]);
        }
        
        int indegree[] = new int[N];
        for (int i = 0; i < N; i++) {
            for (Integer it : adj.get(i)) {
                indegree[it]++;
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        while (!q.isEmpty()) {
            int node = q.poll();
            result.add(node);
            for (int it : adj.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) {
                    q.add(it);
                }
            }
        }

        if(result.size() != N){
            return new int[0]; 
        }

        int[] topo = new int[N];
        for(int i=0; i<N; i++){
            topo[i] = result.get(i);
        }
        return topo;
    }
}
