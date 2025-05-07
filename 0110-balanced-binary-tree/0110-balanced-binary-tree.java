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

    public int height(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = height(root.left);
        int right = height(root.right);
        root.val = Math.abs(right - left);
        return Math.max(left, right) + 1;
    }

    public boolean dfs(TreeNode root){
        if(root == null){
            return true;
        }
        if(root.val > 1){
            return false;
        }
        return dfs(root.left) && dfs(root.right);
    }

    public boolean isBalanced(TreeNode root) {
        height(root);
        return dfs(root);
    }
}