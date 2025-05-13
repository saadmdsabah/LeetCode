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

    public TreeNode recursiveBuild(int[] inorder, int[] postorder, int inLeft, int inRight, HashMap<Integer, Integer> map, int postLeft, int postRight) {
        if (inLeft > inRight || postLeft > postRight) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[postRight]);
        int index = map.get(postorder[postRight]);
        int leftSize = index - inLeft;

        // Build left subtree
        root.left = recursiveBuild(inorder, postorder, inLeft, index - 1, map, postLeft, postLeft + leftSize - 1);
        // Build right subtree
        root.right = recursiveBuild(inorder, postorder, index + 1, inRight, map, postLeft + leftSize, postRight - 1);

        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i], i);
        }
        return recursiveBuild(inorder, postorder, 0, inorder.length - 1, map, 0, postorder.length-1);
    }
}