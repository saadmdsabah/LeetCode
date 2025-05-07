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

    public int height(TreeNode root, ArrayList<Integer> list){
        if(root == null){
            return 0;
        }
        int left = height(root.left, list);
        int right = height(root.right, list);
        list.add(Math.abs(right - left));
        return Math.max(left, right) + 1;
    }

    public boolean isBalanced(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        height(root, list);
        for(int i : list){
            if(i > 1){
                return false;
            }
        }
        return true;
    }
}