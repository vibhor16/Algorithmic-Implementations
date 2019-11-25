class Solution {
    
    class Node{
        int x,y;
        double dist;
        Node(int x, int y){
            this.x = x;
            this.y = y;
            dist = Math.sqrt(Math.pow(x,2) + Math.pow(y,2));
        }
    }
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>(){
            
            public int compare(Node a, Node b){
                double diff = a.dist - b.dist;
                if(diff < 0)
                    return -1;
                
                if(diff>0)
                    return 1;
                
                return 0;
            }
            
        });
        
        for(int i=0;i<points.length;i++){
            Node temp = new Node(points[i][0],points[i][1]);
            pq.add(temp);
        }
        
        int[][] res = new int[K][2];
        for(int i=0;i<K;i++){
            Node temp = pq.remove();
            res[i][0] = temp.x;
            res[i][1] = temp.y;
        }
        
        return res;
    }
}
