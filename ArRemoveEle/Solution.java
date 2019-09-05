//https://leetcode.com/problems/remove-element/
// Logic: swap val with end elements

class Solution {
    public int removeElement(int[] nums, int val) {
            int last = nums.length - 1;
       
            if(nums.length == 0)
                return 0;
        
            while(nums[last] == val) {      
                    last--;
                    if(last < 0)
                      return 0;
                }  
        
        
            int start  = 0, temp;
            while(last >= 0 && start < last){
       
                if(nums[start] == val){
                    temp = nums[start];
                    nums[start] = nums[last];
                    nums[last] = temp;
                }
                
                start++;
                while(nums[last] == val) {      
                    last--;
                    if(last < 0)
                      return 0;
                }  
            
            }
        
        return last+1;
        
    }
}
