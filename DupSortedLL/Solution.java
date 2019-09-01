/**
 * Ran in 0ms and 100%
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head, next1 = curr;
            
        if(head == null)
            return null;
        
        while(curr.next != null){
            
            while(next1 != null && (next1.val == curr.val))
                next1 = next1.next;
            
            if(next1 == null){
                curr.next = null;
                break;
            } else {
                curr.next = next1;
                curr = next1;
            }
        }
        return head;
    }
}
