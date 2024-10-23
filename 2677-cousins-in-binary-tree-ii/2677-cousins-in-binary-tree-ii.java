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

    public void bfs(TreeNode root, Queue<TreeNode> queue, ArrayList<Integer> sum){
        queue.add(root);
        queue.add(null);

        int temp = 0;

        while(!queue.isEmpty()){
            TreeNode curr = queue.remove();
            if(curr == null){
                sum.add(temp);
                temp = 0;
                if(queue.isEmpty()){
                    break;
                }else{
                    queue.add(null);
                }
            }else{
                temp += curr.val;
                if(curr.left != null){
                    queue.add(curr.left);
                }
                if(curr.right != null){
                    queue.add(curr.right);
                }
            }
        }
    }

    public void changeValue(TreeNode root, ArrayList<Integer> sum, int index){
        if(root == null || (root.left == null && root.right == null)){
            return;
        }
        int twoSum = 0;
        if(root.left != null){
            twoSum += root.left.val;
        }
        if(root.right != null){
            twoSum += root.right.val;
        }
        int val = sum.get(index) - twoSum;
        if(root.left != null){
            root.left.val = val;
        }
        if(root.right != null){
            root.right.val = val;
        }
        changeValue(root.left, sum, index + 1);
        changeValue(root.right, sum, index + 1);
    }

    public TreeNode replaceValueInTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> sum = new ArrayList<>();
        bfs(root, queue, sum);
        root.val = 0;
        changeValue(root, sum, 1);
        return root;
    }
}