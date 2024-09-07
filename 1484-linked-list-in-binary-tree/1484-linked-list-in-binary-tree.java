/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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

    public void allNodes(TreeNode root, int val, ArrayList<TreeNode> allStartingNodes){
        if(root == null){
            return;
        }
        allNodes(root.left, val,allStartingNodes);
        if(root.val == val){
            allStartingNodes.add(root);
        }
        allNodes(root.right, val,allStartingNodes);
    }

    public boolean validNode(ListNode head, TreeNode root){
        if(head == null){
            return true;
        }else if(root == null){
            return false;
        }else if(head.val != root.val){
            return false;
        }
        boolean leftSide = validNode(head.next, root.left);
        boolean rightSide = validNode(head.next, root.right);
        return leftSide || rightSide;
    }

    public boolean isSubPath(ListNode head, TreeNode root) {
        ArrayList<TreeNode> allStartingNodes = new ArrayList<>();
        allNodes(root, head.val, allStartingNodes);
        boolean result = false;
        for(int i=0; i<allStartingNodes.size(); i++){
           result = result || validNode(head, allStartingNodes.get(i));
        }
        return result;
    }
}