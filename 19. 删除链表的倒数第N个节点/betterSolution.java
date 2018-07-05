/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode fast = head;
        ListNode slow = dummy;
        
        while (fast != null && n > 0) {
            fast = fast.next;
            n--;
        }
        
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        
        ListNode tmp = null;
        if (slow.next != null) {
            tmp = slow.next.next;
        }
        
        slow.next = tmp;
        
        return dummy.next;
    }
}