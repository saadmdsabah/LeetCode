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

    TreeNode first = null;
    TreeNode middle = null;
    TreeNode last = null;
    TreeNode prev = new TreeNode(Integer.MIN_VALUE);

    public void inorder(TreeNode root){
        if(root == null){
            return;
        }
        inorder(root.left);
        
        if(prev != null && root.val < prev.val){
            if(first == null && middle == null){
                first = prev;
                middle = root;
            }else{
                last = root;
            }
        }
        prev = root;
        inorder(root.right);
    }

    public void recoverTree(TreeNode root) {
        inorder(root);
        if(first != null && last != null){
            int temp = last.val;
            last.val = first.val;
            first.val = temp;
        }else if(first != null && middle != null){
            int temp = middle.val;
            middle.val = first.val;
            first.val = temp;
        }
    }
}