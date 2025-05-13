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

    public int count(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftHeight = leftH(root);
        int rightHeight = rightH(root);
        if(leftHeight == rightHeight){
            return (int) (Math.pow(2, leftHeight) - 1);
        }else{
            return 1 + count(root.left) + count(root.right);
        }
    }

    public int leftH(TreeNode root){
        int count = 0;
        while(root!=null){
            count++;
            root = root.left;
        }
        return count;
    }

    public int rightH(TreeNode root){
        int count = 0;
        while(root!=null){
            count++;
            root = root.right;
        }
        return count;
    }

    public int countNodes(TreeNode root) {
        return count(root);
    }
}