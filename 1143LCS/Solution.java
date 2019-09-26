// NAIVE: Go with recursion first 
// Time complexity of the above naive recursive approach is O(2^n) in worst case and worst case happens when all characters of X and Y mismatch i.e., length of LCS is 0.
// DYNAMIC : O(mn)
class LCS {

    static int mat[][];
    public static int longestCommonSubsequence(String text1, String text2) {

        int l1 = text1.length(), l2 = text2.length();
        mat = new int[l1+1][l2+1];

        for(int i = 1;i<=l1;i++) {
            for(int j =1;j<=l2;j++){
                if(text1.charAt(i-1) != text2.charAt(j-1)) {
                    mat[i][j] = Math.max(mat[i-1][j],mat[i][j-1]);

                }
                else {
                    mat[i][j] = mat[i-1][j-1] + 1;
                }
            }
        }
        return mat[l1][l2];

    }

    public static void printLCS(String a, String b){
        String s = "";
        int i = a.length();
        int j = b.length();

        while(i>=1 && j>=1){
		
		// If top and left are both smaller than current, this means go diagonal and pick the character from a or b, here b is taken 
                if(mat[i][j] > Math.max(mat[i-1][j], mat[i][j-1])) {
                    s = b.charAt(j-1) + s;
                    i--;
                    j--;
                } else if(mat[i][j] == mat[i-1][j] && mat[i][j] > mat[i][j-1]){
		
		// If left = current, go left
                    i--;
                } else{
		
		// If top = current or both left and top are equal to current, then go top 
                    j--;
                }
            }
        System.out.println(s);
    }

    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("ABCDGH", "AEDFHR"));
        printLCS("ABCDGH", "AEDFHR");
    }
}
