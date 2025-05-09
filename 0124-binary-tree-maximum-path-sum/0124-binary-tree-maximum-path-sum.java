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
    int max = -1001;
    public int pathSum(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = Math.max(0, pathSum(root.left));
        int right = Math.max(0, pathSum(root.right));
        max = Math.max(max, left + right + root.val);
        return root.val + Math.max(left, right);
    }

    public int maxPathSum(TreeNode root) {
        max = Math.max(pathSum(root), max);
        return max;
    }
}