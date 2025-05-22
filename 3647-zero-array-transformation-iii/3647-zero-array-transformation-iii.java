class Solution {
    public int maxRemoval(int[] nums, int[][] queries) {
        int n = nums.length;
        PriorityQueue<Integer> usedQuery = new PriorityQueue<>(); // Min-heap 
        PriorityQueue<Integer> availableQuery = new PriorityQueue<>((a, b) -> b - a); // Max-heap 
        
        Arrays.sort(queries, (a, b) -> Integer.compare(a[0], b[0]));
        
        int queryPos = 0;
        int appliedCount = 0;

        for (int i = 0; i < n; i++) {
            // Push all queries starting at `i` into availableQuery
            while (queryPos < queries.length && queries[queryPos][0] == i) {
                availableQuery.offer(queries[queryPos][1]);
                queryPos++;
            }
            
            // add available queries to usedQuery, if usedQuery isn't sufficient
            while (usedQuery.size() < nums[i] && !availableQuery.isEmpty() && availableQuery.peek() >= i) {
                int end = availableQuery.poll();
                usedQuery.offer(end);
                appliedCount++;
            }
            
            // If still nums[i] is non zero 
            if (usedQuery.size() < nums[i]) return -1;
            
            // Remove queries that end at `i` from usedQuery
            while (!usedQuery.isEmpty() && usedQuery.peek() == i) {
                usedQuery.poll();
            }
        }
        
        return queries.length - appliedCount;
    }
}