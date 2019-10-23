// Very Important is the solve function that has the recursive backtracking 

class Solution {
    
    
    static HashMap<Integer, ArrayList<Integer>> boxes = null;
    public void solveSudoku(char[][] board) {
        
        initBoxes();
        if(solve(board)){
            
        }  
    }
    
    public boolean solve(char[][] board){
     
        int[] emptyCell = FindUnassigned(board);
        
        if(emptyCell == null) 
            return true;
        
        int row = emptyCell[0];
        int col = emptyCell[1]; 
        
        for(int num=1;num<=9;num++){
          
           if(isSafe(row,col,board,num)){
               board[row][col] = (char)(num+48);
               if(solve(board)){
                   return true;
               }
               board[row][col] = '.';
           }
          
        }
        return false;
    }
    
    public void initBoxes(){
        boxes = new HashMap<>();
        ArrayList<Integer> range = new ArrayList<>();
        
        range.add(0);range.add(2);range.add(0);range.add(2);
        boxes.put(1,range);
        
        range = new ArrayList<>();
        range.add(0);range.add(2);range.add(3);range.add(5);
        boxes.put(2,range);
        
        range = new ArrayList<>();
        range.add(0);range.add(2);range.add(6);range.add(8);
        boxes.put(3,range);
        
        range = new ArrayList<>();
        range.add(3);range.add(5);range.add(0);range.add(2);
        boxes.put(4,range);
        
        range = new ArrayList<>();
        range.add(3);range.add(5);range.add(3);range.add(5);
        boxes.put(5,range);
        
        range = new ArrayList<>();
        range.add(3);range.add(5);range.add(6);range.add(8);
        boxes.put(6,range);
        
        range = new ArrayList<>();
        range.add(6);range.add(8);range.add(0);range.add(2);
        boxes.put(7,range);
        
        range = new ArrayList<>();
        range.add(6);range.add(8);range.add(3);range.add(5);
        boxes.put(8,range);
        
        range = new ArrayList<>();
        range.add(6);range.add(8);range.add(6);range.add(8);
        boxes.put(9,range);
        
    }
    
    public int[] FindUnassigned(char[][] board){
        int empty[] = new int[2];
        boolean isFull = true;
        for(int i = 0;i<9;i++){
            for(int j =0;j<9;j++){
                if(board[i][j] == '.'){
                    empty[0] = i;
                    empty[1] = j;
                    isFull = false;
                    break;
                }
            }
        }
        if(!isFull)
        return empty;
        return null;
    }
    
    public boolean isSafe(int row,int col, char[][] board, int num){
        ArrayList<Integer> rowData= new ArrayList<>();
        ArrayList<Integer> colData= new ArrayList<>();
        ArrayList<Integer> box= getBoxContent(row,col,board);
        
        for(int i=0;i<9;i++){
            if(board[row][i] != '.'){
                colData.add((int)board[row][i]-48);
            }
        }
        
        for(int i=0;i<9;i++){
            if(board[i][col] != '.'){
                rowData.add((int)board[i][col]-48);
            }
        }
        if(!rowData.contains(num) && !colData.contains(num) && !box.contains(num)){
            return true;
        }
        return false;
    }
    
    public ArrayList<Integer> getBoxContent(int r,int c, char[][] board)     {
        int r1=-1,r2=-1,c1=-1,c2=-1;
        ArrayList<Integer> boxNums = new ArrayList<>();
        for(int i=1;i<=9;i++){
            ArrayList<Integer> temp = boxes.get(i);
            r1 = temp.get(0); 
            r2 = temp.get(1);
            c1 = temp.get(2);
            c2 = temp.get(3);
            
            if(r>=r1 && r<=r2 && c>=c1 && c<=c2){
                break;
            }
        }
        
        for(int row=r1;row<=r2;row++){
            for(int col=c1;col<=c2;col++){
                if(board[row][col] != '.')
                    boxNums.add((int)board[row][col] - 48);
            }
        }
        return boxNums;
    }
    
}
