// Brute force, check at every point having 1, maximum square that can be found ..... O((mn)^2)
class Solution {
    public int maximalSquare(char[][] matrix) {
        int max = 0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]=='1'){
                    max = Math.max(max,area(matrix,i,j));
                } 
            }
        }
        return max;
    }
    public int area(char[][] matrix, int r,int c){
        int max = 1;
        for(int i=1; (i+r) < matrix.length && (i+c) < matrix[0].length ;i++){
            boolean isOne = true;
            for(int j=0;j<=i;j++){
                if(matrix[i+r][j+c] != '1'){
                    isOne = false;
                    return max;
                }         
                // System.out.println("r="+r+" c="+c+" i="+i+" j="+j+" i+r="+(i+r)+" j+c="+(j+c));
                
            }
            if(isOne){
                 for(int j=0;j<=i;j++){
                    if(matrix[j+r][i+c] != '1'){
                    isOne = false;
                    return max;
                        }                     
                  }
            }
            if(isOne){
                max = (int)Math.max(max, Math.pow(i+1,2));
            }
        }
        return max;
        
    }
}
