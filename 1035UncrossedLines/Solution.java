class Solution {
    Integer[][] dp;
    public int maxUncrossedLines(int[] A, int[] B) {
        dp = new Integer[A.length][B.length];
        return find(0,0,A,B);
    }
    
    
    int find(int i, int j, int[] A, int[] B){
        if(i>=A.length || j>=B.length){
            return 0;
        }
        
        if(dp[i][j] != null) return dp[i][j];
        if(A[i] == B[j]){
            dp[i][j] = 1 + find(i+1, j+1, A, B);
        } else {
            dp[i][j] = Math.max(find(i, j+1, A, B), find(i+1, j, A, B));
        }
        
        return dp[i][j];
    }
}
