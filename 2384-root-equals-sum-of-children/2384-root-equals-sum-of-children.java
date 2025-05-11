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
    public boolean checkTree(TreeNode root) {
        if(root == null){
            return false;
        }
        if(root.left != null && root.right != null){
            return (root.val == root.left.val + root.right.val) && checkTree(root.left) && checkTree(root.right);
        }else if(root.left != null){
            return (root.val == root.left.val) && checkTree(root.left);
        }else if(root.right != null){
            return (root.val == root.right.val) && checkTree(root.right);
        }else{
            return true;
        }
    }
}