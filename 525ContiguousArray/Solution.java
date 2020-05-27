class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int sum = 0;
        map.put(0, -1);
        
        int max = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == 0){
                sum--;
            } else {
                sum++;
            }
            
            if(map.get(sum) != null){
                int first = map.get(sum);
                int diff = i - first;
                max = Math.max(max, diff);
                
            } else {
                map.put(sum, i);
            }
        }
        
        return max;
    }
}
