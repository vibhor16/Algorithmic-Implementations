class Solution {
    public int lengthOfLIS(int[] nums) {
        int start=0,end=1;

	// Very important, you did a mistake of initialising max as nums[start]
        int l = nums.length,max = 1;
 
	// Very important, you forgot this       
        if(l <= 1)
            return l;
        
        
        int count[] = new int[l];
        
        for(int i=0;i<l;i++)
            count[i] = 1;
        
        while(true){
            if(start == end){
                start = 0;
                end++;
            }
            
            if(end == l)
                break;
            
            if(nums[end] > nums[start]){
                count[end] = Math.max(count[start] + 1, count[end]);
                max = Math.max(max,count[end]);
            }
            start++;
        }
        
        return max;
    }
}
