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

    public List<Integer> eventualSafeNodes(int[][] adj) {
        int V = adj.length;
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<V; i++){
            graph.add(new ArrayList<Integer>());
        }

        for(int i=0; i<adj.length; i++){
            for(int j=0; j<adj[i].length; j++){
                graph.get(i).add(adj[i][j]);
            }
        }

        List<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[V];
        boolean[] pathVisited = new boolean[V];
        
        for(int i=0; i<V; i++){
            if(!visited[i]){
                dfs(result, graph, visited, pathVisited, i);
            }
        }
        Collections.sort(result);
        return result;
    }
}