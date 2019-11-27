//Using quick select
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
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num:nums){
            map.put(num, map.getOrDefault(num,0) + 1);
        }
        
        List<Node> ar = new ArrayList<>(); 
        for(int key:map.keySet()){
            ar.add(new Node(key, map.get(key)));
        }
        
        int pivot = getPivot(0,ar.size()-1,ar);
        int needIndex = ar.size() - k;
        
        int left = 0, right = ar.size() - 1;
        while(pivot != needIndex){
            if(pivot < needIndex){
                left = pivot + 1;
            } else if(pivot > needIndex){
                right = pivot - 1;
            }
            
            pivot = getPivot(left,right,ar);
        }
        
        List<Integer> res = new ArrayList<>();
        for(int i=pivot;i<ar.size();i++){
            res.add(ar.get(i).x);
        }
        return res;
        
    }
    
    private int getPivot(int left, int right, List<Node> ar){
        
        int pivot = ar.get(right).val;
        int low = left - 1;
        while(left<=right){
            if(ar.get(left).val < pivot){
                low++;
                Node k = ar.get(low);
                ar.set(low, ar.get(left));
                ar.set(left, k);
            }
            left++;
        }
        
        low++;
        if(low<=ar.size()-1){
                Node k = ar.get(low);
                ar.set(low, ar.get(right));
                ar.set(right, k); 
        }
        
        return low;
        
    }
}
