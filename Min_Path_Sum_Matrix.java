/* Single array DP soln (Best Understood) - 
1) Maintain 1 row dp, start from topLeft
2) At every cell, put min path sum from top and left
3) Very Important = dpRow[y] = Math.min(dpRow[y] + grid[x][y], dpRow[y-1] + grid[x][y]);
*/

class Solution {
    public int minPathSum(int[][] grid) {
        
        if(grid.length == 0 || grid[0].length == 0)
            return 0;
        
        int dpRow[] = new int[grid[0].length];
        
        dpRow[0] = grid[0][0];
        for(int j=1;j<grid[0].length;j++){
            dpRow[j] = grid[0][j] + dpRow[j-1];
        }
        
        for(int x = 1;x < grid.length; x++){
            dpRow[0] += grid[x][0];
            for(int y = 1;y < grid[0].length; y++){
                dpRow[y] = Math.min(dpRow[y] + grid[x][y], dpRow[y-1] + grid[x][y]);
            }
        }
              
        return dpRow[dpRow.length - 1];
    }
}
