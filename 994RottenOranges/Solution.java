class Solution {
    ArrayList<ArrayList<Integer>> q = new ArrayList<>();
    public int orangesRotting(int[][] grid) {
        ArrayList<ArrayList<Integer>> ones = new ArrayList<ArrayList<Integer>>();
        
        for(int r=0;r<grid.length;r++){
            for(int c=0;c<grid[0].length;c++){
                if(grid[r][c] == 2){
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(r);
                    temp.add(c);
                    q.add(temp);
                } else if(grid[r][c] == 1){
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(r);
                    temp.add(c);
                    ones.add(temp);
                }
                
                
            }
        }
        
        return result(grid, q, ones);
        
    } 
    
    public int result(int[][] grid, ArrayList<ArrayList<Integer>> q, ArrayList<ArrayList<Integer>> ones){
        ArrayList<ArrayList<Integer>> children;
        int ans = 0;
        ArrayList<ArrayList<Integer>> temp;
        
        
        while(true){
            temp = new ArrayList<ArrayList<Integer>>();
            for(ArrayList<Integer> child: q){
                children = getChildren(grid, child.get(0), child.get(1));
                
                for(ArrayList<Integer> c: children){
                    temp.add(c);
                    grid[c.get(0)][c.get(1)] = 2;
                }
            }
            
            if(temp.size() == 0){
                boolean oneFound = false;
                for(ArrayList<Integer> o: ones){
                    if(grid[o.get(0)][o.get(1)] == 1){
                        oneFound = true;
                        break;
                    }
                }
                if(oneFound){
                    return -1;
                } else {
                    break;
                }
            }
            
            
            ans++;
            q = new ArrayList<ArrayList<Integer>>();
            for(ArrayList<Integer> c: temp){
             q.add(c);
            
            }
        }
        return ans;
    }
    
    public ArrayList<ArrayList<Integer>> getChildren(int[][] grid, int x, int y){
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int r = grid.length-1;
        int c = grid[0].length-1;   
        ArrayList<Integer> temp;
        
        int x1,y1;
        
        // top
        if(x>0){
            x1 = x-1;
            y1 = y;
            if(grid[x1][y1] == 1){
                temp = new ArrayList<>();
                temp.add(x1);
                temp.add(y1);
                res.add(temp);
            }
        
        }
        
        //bottom
        if(x<r){
            x1 = x+1;
            y1 = y;
            if(grid[x1][y1] == 1){
                temp = new ArrayList<>();
                temp.add(x1);
                temp.add(y1);
                res.add(temp);
            }
        
        }
        
        // left
        if(y>0){
            x1 = x;
            y1 = y-1;
            if(grid[x1][y1] == 1){
                temp = new ArrayList<>();
                temp.add(x1);
                temp.add(y1);
                res.add(temp);
            }
        
        }
        
        
        //right
        if(y<c){
            x1 = x;
            y1 = y+1;
            if(grid[x1][y1] == 1){
                temp = new ArrayList<>();
                temp.add(x1);
                temp.add(y1);
                res.add(temp);
            }
        
        }
        
        return res;
    }
    
}
