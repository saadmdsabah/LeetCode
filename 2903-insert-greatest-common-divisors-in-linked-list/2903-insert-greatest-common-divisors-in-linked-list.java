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
class Solution {
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null){
            int gcd = 0;
            for(int i=1;i<=Math.min(slow.val,fast.val);i++){
                if(slow.val%i==0 && fast.val%i==0) gcd=i;
            }
            ListNode temp = new ListNode(gcd);
            slow.next = temp;
            temp.next = fast;
            slow = slow.next.next;
            fast = fast.next;
        }
        return head;
    }
}