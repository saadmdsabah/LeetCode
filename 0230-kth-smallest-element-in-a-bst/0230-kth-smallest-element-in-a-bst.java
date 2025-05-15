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
    public int kthSmallest(TreeNode root, int k) {
        int result = -1;
        int count = 0;

        while(root != null){
            if(root.left == null){
                count++;
                if(count == k){
                    return root.val;
                }
                root = root.right;
            }else{
                TreeNode next = root.left;
                while(next.right != null && next.right != root){
                    next = next.right;
                }
                
                if(next.right == null){
                    next.right = root;
                    root = root.left;
                }else{
                    count++;
                    if(count == k){
                        return root.val;
                    }
                    next.right = null;
                    root = root.right;
                }
            }
        }
        return result;
    }
}