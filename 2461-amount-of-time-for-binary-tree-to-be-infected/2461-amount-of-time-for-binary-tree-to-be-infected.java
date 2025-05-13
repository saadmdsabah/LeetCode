/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int amountOfTime(TreeNode root, int start) {
        HashMap<TreeNode, TreeNode> map = new HashMap<>(); // (node, node's parent)
        map.put(root, null);
        int max = 0;

        TreeNode targetNode = root;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int range = q.size();
            for(int i=0; i<range; i++){
                TreeNode curr = q.remove();
                if(curr.val == start){
                    targetNode = curr;
                }
                max = Math.max(max, curr.val);
                if(curr.left != null){
                    q.add(curr.left);
                    map.put(curr.left, curr);
                }
                if(curr.right != null){
                    q.add(curr.right);
                    map.put(curr.right, curr);
                }
            }
        }

        boolean[] visited = new boolean[max + 1];
        q.add(targetNode);
        visited[targetNode.val] = true;

        int count = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int j=0; j<size; j++){
                TreeNode curr = q.remove();
                if(curr.left != null && !visited[curr.left.val]){
                    q.add(curr.left);
                    visited[curr.left.val] = true;
                }
                if(curr.right != null && !visited[curr.right.val]){
                    q.add(curr.right);
                    visited[curr.right.val] = true;
                }
                if(map.get(curr) != null && !visited[map.get(curr).val]){
                    q.add(map.get(curr));
                    visited[map.get(curr).val] = true;
                }
            }
            count++;
        }
        return count - 1;
    }
}