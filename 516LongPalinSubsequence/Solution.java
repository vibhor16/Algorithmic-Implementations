class Solution {
     public static int longestPalindromeSubseq(String s) {
        int len = s.length();
        int mat[][] = new int[len][len];

        char c[] = s.toCharArray();
        for(int i=0;i<len;i++){
            mat[i][i] = 1;
        }

        int count = 1;
        while(count <= len ){

            for(int i=0;i+count<len;i++){
                int j = i+count;

                if(c[i] == c[j]){
                    mat[i][j] = 2 + mat[i+1][j-1];
                } else {
                    mat[i][j] = Math.max(mat[i+1][j], mat[i][j-1]);
                }
            }
            count++;
        }
        return mat[0][len-1];
    }
}
