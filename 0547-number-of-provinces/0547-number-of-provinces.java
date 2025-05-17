class Solution {

    public void bfs(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int source){
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

    public int findCircleNum(int[][] isConnected) {
        boolean[] visited = new boolean[isConnected.length];

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(isConnected.length);
        for(int i=0; i<isConnected.length; i++){
            adj.add(new ArrayList<Integer>());
        }
        for(int i=0; i<isConnected.length; i++){
            for(int j=0; j<isConnected[0].length; j++){
                if(i != j && isConnected[i][j] == 1){
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
}