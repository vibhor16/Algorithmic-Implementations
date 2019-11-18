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
    
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null)
            return res; 
        
        BFS(root);
        return res;
    }
    
    public void BFS(TreeNode root){
        List<Integer> temp = new ArrayList<>();
        
        List<TreeNode> q = new ArrayList<>();
        List<TreeNode> q1 = new ArrayList<>();
        
        q.add(root);
        
        while(q.size()>0){
            temp = new ArrayList<>();
            q1 = new ArrayList<>();
            
            for(int i=0;i<q.size();i++){
                 TreeNode n = q.get(i);
                 temp.add(n.val);
                if(n.left!=null)
                 q1.add(n.left);
                
                if(n.right!=null)
                 q1.add(n.right);
            }
            res.add(temp);
            q = new ArrayList<>();
            
            for(int i=0;i<q1.size();i++){
                q.add(q1.get(i));
            }    
        }
    }
}
