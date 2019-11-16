class Solution {
    public int search(int[] nums, int target) {
       int left = 0, right = nums.length-1;
       int res = -1, mid=-1;
    
        while(left<=right){
            
            mid = (left+right)/2;
            if(nums[mid] == target){
                return mid;
            }
            
            //if left is sorted
            if(nums[left] <= nums[mid]){
                if(target >= nums[left] && target < nums[mid]){
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if(nums[mid] < nums[right]){
                // if right is sorted
                if( target > nums[mid] && target<=nums[right]){
                    left = mid + 1;
                } else {
                    right = mid-1;
                }
            }
          
            
            
        }
        
        return res;
        
    }
}
