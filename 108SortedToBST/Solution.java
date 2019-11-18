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
    
    public TreeNode createTree(int l,int r, int nums[]){
        if(l>r)
            return null;
        
        int mid = (l+r)/2;
        
        TreeNode root = new TreeNode(nums[mid]);
        root.left = createTree(l,mid-1,nums);
        root.right = createTree(mid+1,r,nums);
        return root;
        
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        return createTree(0,nums.length - 1, nums);
    }
}
