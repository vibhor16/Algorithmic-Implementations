class Solution {
    boolean res = true;
    
    public boolean isBalanced(TreeNode root) {
        checkB(root);
        return res;
    }
    
    public int checkB(TreeNode root){
        if(root == null)
            return 0;
        
        int left = 1 + checkB(root.left);
        int right = 1 + checkB(root.right);
        
        if(Math.abs(left-right)>1 )
            res = false;
        
        return Math.max(left,right);
    }
}
