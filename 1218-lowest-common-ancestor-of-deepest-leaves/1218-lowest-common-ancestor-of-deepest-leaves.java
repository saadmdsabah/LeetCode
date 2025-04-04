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

    TreeNode node1 = null;
    TreeNode node2 = null;
    int treeLevel = 0;

    public void dfs(TreeNode root, int level){
        if(root == null){
            return;
        }
        level += 1;
        treeLevel = Math.max(treeLevel, level);
        dfs(root.left, level);
        dfs(root.right, level);
    }

    public void dfsNodes(TreeNode root, int level){
        if(root == null){
            return;
        }
        level += 1;
        if(level == treeLevel){
            if(node1 == null){
                node1 = root;
            }else{
                node2 = root;
            }
        }
        dfsNodes(root.left, level);
        dfsNodes(root.right, level);
    }

    public TreeNode lca(TreeNode a, TreeNode b, TreeNode root){
        if(root == null){
            return null;
        }else if(root == a || root == b){
            return root;
        }
        TreeNode left = lca(a,b,root.left);
        TreeNode right = lca(a,b,root.right);
        if(left != null && right != null){
            return root;
        }else if(left == null && right == null){
            return null;
        }else if(left == null){
            return right;
        }else{
            return left;
        }
    }

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        dfs(root, 0);
        dfsNodes(root, 0);
        if(node1 == null){
            return node2;
        }else if(node2 == null){
            return node1;
        }else{
            TreeNode result = lca(node1, node2, root);
            return result;
        }
    }
}