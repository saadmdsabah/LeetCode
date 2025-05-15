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

    Stack<TreeNode> nextStack = new Stack<>();
    Stack<TreeNode> beforeStack = new Stack<>();

    public void nextInitialize(TreeNode root){
        while(root != null){
            nextStack.push(root);
            root = root.left;
        }
    }

    public TreeNode next(){
        TreeNode curr = nextStack.pop();
        TreeNode result = curr;
        curr = curr.right;
        while(curr != null){
            nextStack.push(curr);
            curr = curr.left;
        }
        return result;
    }

    public void beforeInitialize(TreeNode root){
        while(root != null){
            beforeStack.push(root);
            root = root.right;
        }
    }

    public TreeNode before(){
        TreeNode curr = beforeStack.pop();
        TreeNode result = curr;
        curr = curr.left;
        while(curr != null){
            beforeStack.push(curr);
            curr = curr.right;
        }
        return result;
    }

    public boolean findTarget(TreeNode root, int k) {
        // if(root.left == null && root.right == null){
        //     return false;
        // }
        nextInitialize(root);
        beforeInitialize(root);

        TreeNode i = next();
        TreeNode j = before();
        // if(i.val + j.val == k){
        //     return true;
        // }

        while(!nextStack.isEmpty() && !beforeStack.isEmpty()){
            if(i == j){
                return false;
            }
            int sum = i.val + j.val;
            if(sum == k){
                return true;
            }
            if(sum > k){    
                j = before();
            }else{
                i = next();
            }
        }
        return false;
    }
}