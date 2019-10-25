// 68% accuracy
class Solution {
    public String minWindow(String s, String t) {
        
        if(s.length() == 0 || t.length() == 0)
            return "";
      
        // All letters character count for t
        int[] t_map = new int[128];
        for(int i=0;i<t.length();i++){
            t_map[t.charAt(i)]++;
        }
        
        char[] schar = new char[s.length()];
        int[] ind = new int[s.length()];
        
        int j = 0;
        
        // Condensing s to only characters present in t
        for(int i=0 ;i<s.length();i++){
            char c = s.charAt(i);
            if(t_map[c]>0){
                schar[j] = c;
                // Saving the respective indices
                ind[j++] = i;       
            }
        }
        
        // If len is less than pattern len
        if(schar.length < t.length())
            return "";
        
        // right should be atleast length of pattern
        int newLen = j, left = 0, right = t.length()-1, minTemp,min=Integer.MAX_VALUE,l=-1,r=-1;
        
        // Character count in s
        int[] s_map = new int[128];
        for(int i=left;i<=right;i++){
                s_map[schar[i]]++;
        }
        
        
        // 2nd condition very important
        while(right<newLen && left<=right){
             
            minTemp = ind[right] - ind[left] + 1;
            
            
            if(valid(s_map,t_map)){
                if(minTemp < min){
                    min = minTemp;
                    l = ind[left];
                    r = ind[right];
                }
                
                // Remove last left character
                s_map[schar[left]]--;
                left++;
                
            } else {
                right++;
                // Add new right character
                if(right<newLen)
                    s_map[schar[right]]++;
            }
        }
        
        if(l == -1 && r == -1)
            return "";
        
        return s.substring(l,r+1);
       
    }
    public boolean valid(int[] s_map, int[] t_map){
        
        // characters must be same, count of t char <= s char - very important
        for(int i=65;i<123;i++){
            if(t_map[i] == 0 && s_map[i]>0)
                return false;
            
            if(t_map[i]>s_map[i])
                return false;
            
        }
        
        return true;
    }
}
