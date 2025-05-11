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

    class Pair{
        TreeNode node;
        int index;
        public Pair(TreeNode node, int index){
            this.node = node;
            this.index = index;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        int max = 1;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));

        while(!q.isEmpty()){
            int range = q.size();
            int first = q.peek().index;
            int last = -1;

            for(int i=0; i<range; i++){
                Pair currPair = q.remove();
                TreeNode currNode = currPair.node;
                int currIndex = currPair.index;

                int newIndex = currIndex - first;
                if(i == range - 1) last = currIndex;
                if(currNode.left != null){
                    q.add(new Pair(currNode.left, 2*newIndex + 1));
                }
                if(currNode.right != null){
                    q.add(new Pair(currNode.right, 2*newIndex + 2));
                }
            }
            max = Math.max(max, last - first + 1);
        }
        return max;
    }
}