// Keep rolling in one direction until u stop at a wall
// Put this stop position in the queue
// Start again with this stopped position

class Solution {
    
    ArrayList<Integer> parent = new ArrayList<>();
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
         return BFS(start, destination, maze);
    }
    
    public boolean BFS(int[] start, int[] dest, int[][] maze){
        
        Queue<int[]> q = new LinkedList<>();
        int[][] visited = new int[maze.length][maze[0].length];
        
        int[] temp = new int[2];
        
        q.add(start);
         
        int dr[] ={-1,1,0,0};
        int dc[] ={0,0,1,-1};
        
        visited[start[0]][start[1]] = 1;
        
        while(q.size()>0) { 
           
            int[] node = q.remove();
            if(node[0] == dest[0] && node[1] == dest[1])
                return true;
            
            
            for(int k = 0;k<4;k++){
                
                int x = node[0]+dr[k];
                int y = node[1]+dc[k];
                while(x>=0 && y>=0 && x<maze.length && y<maze[0].length && maze[x][y] == 0){
                    x += dr[k];
                    y += dc[k];
                }
                
                x = x - dr[k];
                y = y - dc[k];
                
               // temp = new int[2];
                
                
                if(visited[x][y] == 0){
                    visited[x][y] = 1;
                    q.add(new int[] {x,y});
                }
            }
            
        }
        
        return false;
        
    }
}
