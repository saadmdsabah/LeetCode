/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {

    public TreeNode lca(TreeNode root, TreeNode p, TreeNode q){
        if(root == null || root == p || root == q) return root;
    

        TreeNode left = null;
        TreeNode right = null;
        if(root.val > p.val && root.val > q.val){
            left = lca(root.left, p, q);
        }else if(root.val < p.val && root.val < q.val){
            right = lca(root.right, p, q);
        }
        else{
            left = lca(root.left, p, q);
            right = lca(root.right, p, q);
        }
        
        if(left == p && right == q || left == q && right == p){
            return root;
        }else if(left == null && right == null){
            return null;
        }else if(left == null){
            return right;
        }else{
            return left;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return lca(root, p, q);
    }
}