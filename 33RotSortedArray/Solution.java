// Find rotation Index, split to 2 lists, compare 1st num with target in both lists, proceed in the resulting list apply bin sort.

class Solution {
    public int search(int[] nums, int target) {
        int rot = -1;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i] > nums[i+1]){
                rot = i;
                break;
            }
        }
        if(rot == -1)
            return BinarySearch(0,nums.length-1,nums,target);
        
        int res = -1;
        if(target >= nums[0]){
            res = BinarySearch(0,rot,nums,target);
        } else if(target >= nums[rot+1]){
            res = BinarySearch(rot+1,nums.length - 1, nums, target);
        }
        return res;
    }
    public int BinarySearch(int left,int right, int[] nums,int target){
        
        while(left<=right){
            int mid = (left+right)/2;
        
            if(nums[mid] == target){
                return mid;
            } else if(target>nums[mid]){
                left = mid+1;
            } else if(target<nums[mid]){
                right = mid - 1;
            }
        }
        return -1;
        
    }
}
