https://leetcode.com/problems/search-insert-position/
// Logic: apply binary search, to give index of where val should be, return left

class Solution {
    public int searchInsert(int[] nums, int target) {
        
        int left = 0, right = nums.length - 1, mid = -1;
        while(left <= right){
            mid = left +(right-left) /2;
            
            if(nums[mid] == target) {
                break;
            }
            
            if(nums[mid] > target){
                right = mid - 1;
            } else if(nums[mid] < target) {
                left = mid + 1;
            }
            mid = -1;
        }
        
        if(mid == -1)
            mid = left;
        
        return mid;
    }
}
