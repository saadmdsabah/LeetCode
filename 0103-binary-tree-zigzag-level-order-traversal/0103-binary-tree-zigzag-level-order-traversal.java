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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int flag = 0;

        while(!q.isEmpty()){
            int len = q.size();
            int[] row = new int[len];
            int i = flag == 0 ? 0 : len - 1;
            while(i >= 0 && i < len){
                TreeNode curr = q.remove();
                if(curr.left != null){
                    q.add(curr.left);
                }
                if(curr.right != null){
                    q.add(curr.right);
                }
                row[i] = curr.val;
                i = i + (flag == 0 ? 1 : -1);
            }
            List<Integer> rowList = Arrays.stream(row)
                              .boxed()
                              .collect(Collectors.toList());
            result.add(rowList);
            flag = flag == 0 ? 1 : 0;
        }
        return result;
    }
}