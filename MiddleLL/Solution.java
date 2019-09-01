/**
 * Run 0ms, 100%  Space 100%
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode middleNode(ListNode head) {
        if(head == null)
            return null;
        
        if(head.next == null)
            return head;
        
        ListNode mid = head, last = head;
        while(true){
            if(last == null) break;
            if(last.next == null) break;
            mid = mid.next;
            last = last.next.next;
        }
        return mid;
    }
}
