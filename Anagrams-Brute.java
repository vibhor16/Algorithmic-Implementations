import java.util.concurrent.ConcurrentHashMap;
class Solution {
    public boolean isAnagram(String s, String t) {
        ConcurrentHashMap<Character, Integer> m1 = new ConcurrentHashMap<>();
        ConcurrentHashMap<Character, Integer> m2 = new ConcurrentHashMap<>();
        
        if(s.length() != t.length())
            return false;
        
        if(s.length() == 0 && t.length() == 0) 
            return true;
            
        
        for(int i=0;i<s.length();i++){
            char c1 = s.charAt(i);
            if(m1.containsKey(c1)) {
                m1.put(c1, m1.get(c1) + 1);
            } else {
                m1.put(c1,1);
            }
            
            char c2 = t.charAt(i);
            if(m2.containsKey(c2)) {
                m2.put(c2, m2.get(c2) + 1);
            } else {
                m2.put(c2,1);
            }
        }
        
        if(m1.keySet().size() != m2.keySet().size()) 
            return false;
        
        
        boolean flag = true;
        for(char c: m2.keySet()){
            if(m1.containsKey(c)) {
            if(!m1.get(c).equals(m2.get(c))){
                flag = false;
                break;
            } 
            } else {
                flag = false;
                break;
            }
        }
        
      
        return flag;
    }
}
