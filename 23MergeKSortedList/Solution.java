// Remember -
// 1) Create class with list node and its index
// 2) Add all k in one go 1 time
// 3) Keep on removing one and adding the next element after that.
/
**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    class comp implements Comparator<data> {
        public int compare(data a, data b){
            return a.l.val - b.l.val;
        }
    }
    
    class data{
        ListNode l;
        int index;
        data(ListNode l, int index){
            this.l = l;
            this.index = index;
        }
    }
    
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0){
            return null;
        }
        
        PriorityQueue<data> pq = new PriorityQueue<>(new comp());
        ListNode headRes = null, curr = null, temp = null;
        
        int n = lists.length;
        
        for(int i=0;i<n;i++){
                if(lists[i] != null){
                    pq.add(new data(lists[i], i));
                }
        }
        
        while(pq.size() > 0){
            
            data node = pq.poll();
            temp = node.l;    
            int index = node.index;
            lists[index] = lists[index].next;
                
            if(lists[index]!=null){
                pq.add(new data(lists[index],index));
            }
                
            if(headRes == null){
                headRes = temp;
                curr = headRes;
                curr.next = null;
             } else {
                curr.next = temp;
                curr = temp;
                curr.next = null;
             }
        }
        
        return headRes;
    }
}
