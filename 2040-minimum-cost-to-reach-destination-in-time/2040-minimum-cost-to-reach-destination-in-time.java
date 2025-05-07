class Solution {
    class State {
        int node, time, cost;
        public State(int node, int time, int cost) {
            this.node = node;
            this.time = time;
            this.cost = cost;
        }
    }

    public int minCost(int maxTime, int[][] edges, int[] passingFees) {
        int n = passingFees.length;
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for (int[] edge : edges) {
            graph.get(edge[0]).add(new int[]{edge[1], edge[2]});
            graph.get(edge[1]).add(new int[]{edge[0], edge[2]});
        }

        int[][] minCostAtTime = new int[n][maxTime + 1];
        for (int[] row : minCostAtTime) Arrays.fill(row, Integer.MAX_VALUE);
        PriorityQueue<State> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.cost));
        
        pq.add(new State(0, 0, passingFees[0]));
        minCostAtTime[0][0] = passingFees[0];

        while (!pq.isEmpty()) {
            State curr = pq.poll();
            int node = curr.node, time = curr.time, cost = curr.cost;

            if (node == n - 1) return cost;

            for (int[] neighbor : graph.get(node)) {
                int nextNode = neighbor[0];
                int travelTime = neighbor[1];
                int newTime = time + travelTime;
                if (newTime > maxTime) continue;
                int newCost = cost + passingFees[nextNode];
                if (minCostAtTime[nextNode][newTime] > newCost) {
                    minCostAtTime[nextNode][newTime] = newCost;
                    pq.add(new State(nextNode, newTime, newCost));
                }
            }
        }
        return -1;
    }
}
