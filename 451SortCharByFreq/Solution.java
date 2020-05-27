class Solution {
    
    
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        HashMap<Integer, ArrayList<Character>> buckets = new HashMap<>();
        
        for(char c: s.toCharArray()){
            if(map.get(c) == null){
                map.put(c, 1);
            } else {
                map.put(c, map.get(c)+1);
            }
        }
        ArrayList<Character> temp;
        for(char c: map.keySet()){
            int count = map.get(c);
            if(buckets.get(count) == null){
                temp = new ArrayList<>();
            } else {
                temp = buckets.get(count);
            }
            temp.add(c);
            buckets.put(count, temp);
        }
        
        String res="";
        for(int i=s.length(); i>=1;i--){
            if(buckets.get(i) != null){
                temp = buckets.get(i);
                Collections.sort(temp, Collections.reverseOrder());
                
                for(char c: temp){
                    for(int j=1;j<=i;j++){
                        res+=c;
                    }
                }
            }
        }
        return res;
        
    }
    
    
    
}
