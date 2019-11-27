class Solution {
    public int findKthLargest(int[] nums, int k) {
        
//         int[] tt = nums;
//         Arrays.sort(tt);
//         for(int i=0;i)
//         System.out.println(ar);
        
        int pivot = -2;
        int left = 0, right = nums.length-1;
        pivot = getPivot(left,right,nums);
        
        int pivotIn = nums.length - k;
        
        // System.out.println("in = "+pivotIn);
        while(pivot != pivotIn){
            if(pivot > pivotIn){
                right = pivot-1;
            } else if(pivot < pivotIn){
                left = pivot+1;
            }
                pivot = getPivot(left, right, nums);
            
        }
        
        return nums[pivot];
    }
    
    private int getPivot(int left, int right, int nums[]){
        int low = left-1;
        int pivot = nums[right];
        for(;left<=right;left++){
            if(nums[left]<pivot){
                low++;
                int k = nums[low];
                nums[low] = nums[left];
                nums[left] = k;
            }
        }
        ++low;
        if(low<nums.length){
            int k = nums[low];
            nums[low] = nums[right];
            nums[right] = k;
        }
        // System.out.println(low);
        return low;
        
    }
}
