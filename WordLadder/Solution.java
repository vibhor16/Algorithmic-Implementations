// Key * , BFS

class Solution {
    
  
    class pair{
        String word;
        int level;
        pair(String word, int level){
            this.word = word;
            this.level = level;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        HashMap<String,ArrayList<String>> map = new HashMap<>();
        
        for(String s : wordList){
            for(int i=0;i<s.length();i++){
                String key = s.substring(0,i) +"*"+s.substring(i+1);
                ArrayList<String> children = map.getOrDefault(key, new ArrayList<String>());
                children.add(s);
                map.put(key, children);
            }
        }
        
        Queue<pair> q = new LinkedList<>();
        ArrayList<String> visited = new ArrayList<>();
        
        q.add(new pair(beginWord, 1));
        visited.add(beginWord);
        
        while(!q.isEmpty()){
            pair node = q.remove();
            int parentLevel = node.level;
            String word = node.word;
            
            for(int i=0;i<word.length();i++){
                String key = word.substring(0,i) +"*"+word.substring(i+1);
                ArrayList<String> children = map.get(key);
                if(children == null)
                    continue;
                for(String child: children){
                    if(child.equals(endWord)){
                        return parentLevel + 1;
                    } else {
                        if(!visited.contains(child)){
                            visited.add(child);
                            q.add(new pair(child, parentLevel+1));
                        }
                    }
                }
            }
            
        }
        
        return 0;
    }
}
