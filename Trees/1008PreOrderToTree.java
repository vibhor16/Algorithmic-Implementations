/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

import java.util.stream.Collectors;
class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        ArrayList<Integer> ar = new ArrayList<>();
        for(int i: preorder){
            ar.add(i);
        }
        
        TreeNode root = new TreeNode(ar.get(0));
        root.left = tree(root, getSmall(ar.get(0), ar.subList(1, ar.size())));
        root.right = tree(root, getLarge(ar.get(0), ar.subList(1, ar.size())));
        
        return root;
    }
    
    TreeNode tree(TreeNode root, ArrayList<Integer> array){
        if(array.size() == 0){
            return null;
        }
        
        if(array.size() == 1){
            return new TreeNode(array.get(0), null, null);
        }
        
        TreeNode tmp = new TreeNode(array.get(0));
        tmp.left = tree(tmp, getSmall(array.get(0), array.subList(1, array.size())));
        tmp.right = tree(tmp, getLarge(array.get(0), array.subList(1, array.size())));
        
        return tmp;
    }
    
    ArrayList<Integer> getSmall(int val, List<Integer> ar){
        
        List<Integer> small = ar.stream()
            .filter(x -> x < val)
            .collect(Collectors.toList());
            
        return (ArrayList)small;
    }
    
    ArrayList<Integer> getLarge(int val, List<Integer> ar){
        
        List<Integer> large = ar.stream()
            .filter(x -> x > val)
            .collect(Collectors.toList());
            
        return (ArrayList)large;
    }
    
}
