// 7ms, 87.66%  Logic: Maintain a hashset of window k+1, if you are not able to
// add a number, that means for the window of size k, this is a duplicate number
// Hence, we found a number in this window.
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
       HashSet<Integer> set = new HashSet<>();
       
        int j = 0;
        for(int i = 0;i<nums.length;i++){
            if(!set.add(nums[i]))
                return true;
            
            if(set.size() >= (k + 1)){
                set.remove(nums[j++]);
            }
        }
        return false;
        
    }
}
