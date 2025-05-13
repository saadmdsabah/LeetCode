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

    public TreeNode recursiveBuild(int[] inorder, int[] preorder, int inLeft, int inRight, HashMap<Integer, Integer> map, int preLeft, int preRight){
        if(inLeft > inRight  || preLeft > preRight){
            return null;
        }
        TreeNode root = new TreeNode(preorder[preLeft], null, null);
        int index = map.get(preorder[preLeft]);
        int range = index - inLeft;
        root.left = recursiveBuild(inorder, preorder, inLeft, index - 1, map, preLeft+1, preRight + range);
        root.right = recursiveBuild(inorder, preorder, index + 1, inRight, map, preLeft+range+1, preRight);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i], i);
        }
        return recursiveBuild(inorder, preorder, 0, inorder.length - 1, map, 0, preorder.length-1);
    }
}