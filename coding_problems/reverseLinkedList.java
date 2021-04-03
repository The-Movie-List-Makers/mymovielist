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
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode next = head.next.next;
        ListNode curr = head.next;
        curr.next = head;
        head.next = null;
        if (next == null) return curr;
        if (next.next == null) {
        	next.next = curr;
        	return next;
        }
        ListNode prev = curr;
        curr = next;
     
        while (curr.next != null) {
        	next = curr.next;
        	curr.next = prev;
        	prev = curr;
        	curr = next;
        }
        curr.next = prev;

        return curr;
    }
}