import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {

    class Pair implements Comparable<Pair> {
        int node;
        double prob;

        public Pair(int node, double prob) {
            this.node = node;
            this.prob = prob;
        }

        @Override
        public int compareTo(Pair other) {
            if (this.prob > other.prob) {
                return -1;
            } else if (this.prob < other.prob) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        Map<Integer, Map<Integer, Double>> graph = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            double p = succProb[i];
            graph.computeIfAbsent(u, k -> new HashMap<>()).put(v, p);
            graph.computeIfAbsent(v, k -> new HashMap<>()).put(u, p);
        }

        double[] maxProb = new double[n];
        maxProb[start] = 1.0;

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.offer(new Pair(start, 1.0));

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int node = curr.node;
            double prob = curr.prob;

            if (node == end) {
                return prob;
            }

            if (graph.containsKey(node)) {
                for (Map.Entry<Integer, Double> entry : graph.get(node).entrySet()) {
                    int neighbor = entry.getKey();
                    double edgeProb = entry.getValue();
                    double newProb = prob * edgeProb;
                    if (newProb > maxProb[neighbor]) {
                        maxProb[neighbor] = newProb;
                        pq.offer(new Pair(neighbor, newProb));
                    }
                }
            }
        }

        return maxProb[end];
    }
}