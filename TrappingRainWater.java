// Single iteration, if height of left < height of right, update maxL, ans = maxL - height at left , left++  vice versa

class TrappingRainWater {
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int maxL = 0, maxR = 0;
        int ans = 0;
        while(left < right){
            
            if(height[left] < height[right]){
                maxL = Math.max(maxL, height[left]);
                ans += maxL - height[left]; 
                left++;
                
            } else {
                maxR = Math.max(maxR, height[right]);
                ans += maxR - height[right];
                right--;
            }
        }
        
        return ans;
        
    }
}
