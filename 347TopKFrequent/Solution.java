// Use a min heap
class Solution {
    
    class Node{
        int x;
        int val;
        Node(int x,int val){
            this.x = x;
            this.val = val;
        }
    }
    public List<Integer> topKFrequent(int[] nums, int k) {
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>(){
            
            public int compare(Node a, Node b){
                return b.val - a.val;
            }
            
        });
        
        
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
        
        for(int num:nums){
            map.put(num, map.getOrDefault(num,0) + 1);
        }
        
        for(int key:map.keySet()){
            pq.add(new Node(key, map.get(key)));
        }
        
        System.out.println(map);
        
        List<Integer> ar = new ArrayList<>();
        for(int i=0;i<k;i++)
            ar.add(pq.remove().x);
        
        return ar;
    }
}
