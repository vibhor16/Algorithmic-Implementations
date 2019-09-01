/**
 * Run 1ms 98.34%, space 100% 
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode curr = head, pre = null, temp = null;
        
        if(head == null)
            return null;
        
        while(curr != null) {
            if(curr.val == val) {
                if(curr == head){
                    head = head.next;
                } else if(curr.next == null){
                    pre.next = null;
                } else {
                    temp = pre;
                    pre.next = pre.next.next;
                    curr = pre;
                    pre = temp;
                }
            }
            pre = curr;
            curr = curr.next;
        }
        return head;
    }
}
