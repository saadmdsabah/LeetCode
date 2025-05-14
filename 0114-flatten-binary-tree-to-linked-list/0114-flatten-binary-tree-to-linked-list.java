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
    public void flatten(TreeNode root) {
        
        TreeNode curr = root;
        while(curr != null){
            if(curr.left != null){
                TreeNode next = curr.left;
                while(next.right != null){
                    next = next.right;
                }
                next.right = curr.right;
                curr.right = curr.left;
            }
            curr = curr.right;
        }
        curr = root;
        while(curr != null){
            curr.left = null;
            curr = curr.right;
        }
    }
}