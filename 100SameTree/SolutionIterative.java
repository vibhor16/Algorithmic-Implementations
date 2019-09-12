// Iterative soln: 2 queues, add nodes, if both queues not empty, pop and check equal, add children only if both equal, else break   0ms,100%
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        ArrayDeque<TreeNode> q1 =new ArrayDeque<>();
        ArrayDeque<TreeNode> q2 =new ArrayDeque<>();
        
        if(p==null && q==null) return true;
        if(p==null || q==null) return false;
        
        q1.addLast(p);
        q2.addLast(q);
        boolean flag = true;
        while(!q1.isEmpty() && !q2.isEmpty()) {
            TreeNode t1 = q1.removeFirst();
            TreeNode t2 = q2.removeFirst();
            
            if(t1.val == t2.val) {
                
                // add left
                if(t1.left != null && t2.left != null) {
                    
                    if(t1.left.val != t2.left.val) {
                        flag = false;
                        break;
                    }
                    
                    q1.addLast(t1.left);
                    q2.addLast(t2.left);
                } else if(t1.left == null && t2.left == null){
                   
                } else {
                     flag = false;
                    break;
                }
               
                // add right
                if(t1.right != null && t2.right != null) {
                    if(t1.right.val != t2.right.val) {
                        flag = false;
                        break;
                    }
                
                    q1.addLast(t1.right);
                    q2.addLast(t2.right);
                } else if(t1.right == null && t2.right == null) {
                   
                } else {
                     flag = false;
                    break;
                }
                
            } else {
                flag = false;
                break;
            }
        }
        
        return flag;
    }
}
