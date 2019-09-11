// 0ms, 100% Logic: Left subtree == right subtree vice versa

class Solution {
    public boolean isSymmetric(TreeNode root) {
        return doJob(root,root);
    }
    public boolean doJob(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null)
            return true;
        if(t1 == null || t2 == null)
            return false;
        
        return t1.val == t2.val && doJob(t1.left,t2.right) && doJob(t1.right,t2.left);
        
    }
}
