class Solution {
    public int numIslands(char[][] grid) {
         if(grid.length == 0){
            return 0;
        }
        
        int[][] visited = new int[grid.length][grid[0].length];
       
        int result = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == '1' && visited[i][j] == 0){
                    result += DSF(grid,visited,i,j);
                }
            }
        }
        return result;
    }
    public int DSF(char[][] grid, int[][] visited, int r, int c){
        if(r<0 || c<0 || r>=grid.length || c>=grid[0].length || visited[r][c] == 1 || grid[r][c] == '0'){
            return 0;
        }
        
        
        visited[r][c] = 1;
        
        DSF(grid,visited,r-1,c);
        DSF(grid,visited,r,c+1);
        DSF(grid,visited,r+1,c);
        DSF(grid,visited,r,c-1);
        return 1;
    }
}
