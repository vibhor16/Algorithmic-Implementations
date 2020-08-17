class Solution {
    public int minDays(int n) {
        
        // BFS
        Set<Integer> already = new HashSet<>();
        
        Queue<Integer> q = new LinkedList<>();
        int days = 0;
        q.add(n);
        
        while(!q.isEmpty()){
            
            days++;
            
            int size = q.size();
            for(int i=1;i<=size;i++){
                int curr = q.poll();
                if(curr == 0)
                    return days - 1;
                
                if(already.contains(curr)){
                    continue;
                } else 
                    already.add(curr);
                
                if(curr%3==0)
                    q.offer(curr/3);
                
                if(curr%2 == 0)
                    q.offer(curr/2);
                
                q.offer(curr-1);
                
            }
            
        }
        
        return days;
        
    }
}
