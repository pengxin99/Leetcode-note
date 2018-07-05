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
        ArrayList allListNode = new ArrayList();
        int index = 0;
        ListNode temp = head;
        while(temp != null){
            allListNode.add(temp);
            temp = temp.next;
            index ++;
        }
        if(n == index){
            head = head.next;
            return head;
        }else if(n==1){
            ListNode before = (ListNode)allListNode.get(index-2);
            before.next = null;
            return head;
        }else{
            int m = index - n ;
            ListNode before = (ListNode)allListNode.get(m-1);
            ListNode after = (ListNode)allListNode.get(m+1);
            before.next = after;
            return head;
        }
    }
}