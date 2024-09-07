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

    public void allNodes(TreeNode root, ListNode head){
        if(root == null){
            return;
        }
        allNodes(root.left, head);
        if(root.val == head.val){
            ListNode temp = head;
            result = result || validNode(temp, root);
        }
        allNodes(root.right, head);
    }

    boolean result = false;
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
        allNodes(root, head);
        return result;
    }
}