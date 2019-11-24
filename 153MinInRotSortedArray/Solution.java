class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        
        if(nums.length == 1){
            return nums[0];
        }
        
        if(nums[left] < nums[right]){
            return nums[left];
        }
        
        int result = -1;
        while(left<=right){
            int mid = left + (right - left) / 2;
            
            if(nums[mid] > nums[mid+1]){
                result = nums[mid+1];
                break;
            } else if (nums[mid-1] > nums[mid]){
                result = nums[mid];
                break;
            }
            
            if(nums[mid] > nums[left]){
                left = mid+1;
            } else {
                right = mid-1;               
            }
            
        }
        
        return result;
    }
}
