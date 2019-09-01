/**
 * It ran in 0 ms and faster than 100%
 * Optimizer: Just have a pre pointer for current pointer in list one
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // pre is a pointer before c1
        ListNode head1 = l1, head2 = l2, c1 = l1, c2 = l2, temp, temp2, pre = null;
        
        if(l1 == null && l2 != null)
            return l2;
        else if(l1 != null && l2 == null)
            return l1;
        
        while(true) {
            
            // if c1 ends but c2 still has some nodes left
            if(c1 == null && c2 != null) {
                pre.next = c2;
                pre = c2;
                break;
            }
            
            // if we come to the end of c2
            if(c2 == null) break;
            
            
            if(c2.val <= c1.val){
                temp2 = c2.next;
                if(c1 == head1) {
                    // Make c2 as head1
                    c2.next = c1;
                    head1 = c2;
                } else {
                    temp = head1;  
                    pre.next = c2;
                    c2.next = c1;
                }
                pre = c2;
                c2 = temp2;
            } else {
                pre = c1;
                c1 = c1.next;
            }
        }
        return head1;
    }
}

