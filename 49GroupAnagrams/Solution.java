class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        List<List<String>> res = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        
        if(strs.length == 0){
            return res;
        }        
        
        
        
        HashMap<String,ArrayList<String>> map = new HashMap<>();
        String newS = "";
        for(int i=0;i<strs.length;i++){
            char[] tc = strs[i].toCharArray();
            Arrays.sort(tc);
            newS = new String(tc);
            if(map.containsKey(newS)){
                ArrayList<String> t = map.get(newS);
                t.add(strs[i]);
                map.put(newS, t);
            } else {
                ArrayList<String> t = new ArrayList<>();
                t.add(strs[i]);
                map.put(newS, t);
            }
        }
        
        for(String key:map.keySet()){
            res.add(map.get(key));
            
        }
        
        
        return res;
        
    }
}
