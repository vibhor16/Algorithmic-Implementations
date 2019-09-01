class Solution {
    public boolean isAnagram(String s, String t) {
        int ar[] =new int[26];
        
        
        if(s.length() != t.length())
            return false;
        
        if(s.length() == 0 && t.length() == 0) 
            return true;
            
        
        for(int i=0;i<s.length();i++){
            ar[s.charAt(i) - 'a']++;
        }
        
        for(int j=0;j<t.length();j++){
            ar[t.charAt(j) - 'a']--;
            if(ar[t.charAt(j) - 'a'] < 0 ){
                return false;
            }
        }
      
        return true;
    }
}
