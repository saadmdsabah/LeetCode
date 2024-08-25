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

    TreeNode prev =  null;
    int min = Integer.MAX_VALUE;
    public void minDis(TreeNode root){
        if(root == null){
            return;
        }
        minDis(root.left);
        if(prev != null){
            min = Math.min(min, root.val - prev.val);
        }
        prev = root;
        minDis(root.right);
    }

    public int minDiffInBST(TreeNode root) {
        minDis(root);
        return min;
    }
}