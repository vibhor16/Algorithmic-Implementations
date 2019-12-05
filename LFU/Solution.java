// 19 out of 23 test cases are running
class LFUCache {

    
    class Node{
        int key;
        int value;
        int freq;
        Node(int key, int value, int freq){
            this.key = key;
            this.value = value;
            this.freq = freq;
        }
    }
    
    // Key and its node
    HashMap<Integer, Node> map;
    
    // At this freq, which all nodes are present
    LinkedHashMap<Integer, ArrayList<Node>>  freq;
    
    // List of nodes with their recency
    ArrayList<Node> recency;
    
    int size;
    
    public LFUCache(int capacity) {
        
        freq = new LinkedHashMap<>();
        recency = new ArrayList<>();
        map = new HashMap<>();
        size = capacity;
    }
    
    public int get(int key) {
       
        if(map.containsKey(key)){
            Node temp = map.get(key);
            updateFrequency(temp, temp.freq, temp.freq + 1);
            return temp.value;
        }
        
        return -1;
    }
    
    
    
    public void put(int key, int value) {
        
        
        // Must note this 
        if(size == 0){
            return;
        }
        
        
        Node temp = new Node(key,value,1);
        int pastFreq = temp.freq;
        int newFreq = pastFreq + 1;
        
        if(map.containsKey(key)){
            temp = map.get(key);
            temp.value = value;
            
            pastFreq = temp.freq;
            newFreq = pastFreq + 1;
            
        } else {
            // Must take note
            if(map.size()>=size){
                removeLeast();
            } 
        }
        map.put(key, temp);
        updateFrequency(temp, pastFreq, newFreq);
    }
    
    // updates frequency and recency 
    public void updateFrequency(Node temp, int currFreq, int newFreq){
        
        
        ArrayList<Node> atIndex = freq.getOrDefault(currFreq, new ArrayList<Node>());
        
        // delete from here
        if(atIndex.contains(temp))
           atIndex.remove(temp);
        
        freq.put(currFreq, atIndex);
        
        // Update frequency
        temp.freq = newFreq;
        atIndex = freq.getOrDefault(newFreq, new ArrayList<Node>());
        atIndex.add(temp);
        freq.put(newFreq, atIndex);
        
        // Update recency
        recency.add(temp);
    }
    
    public int getMinIndex(){
        
        // Must Note
        for(int index:freq.keySet()){
            if(freq.get(index)!=null && freq.get(index).size()>0){
                return index;
            }
        }
        
        return 0;
    }
    
    public void removeLeast(){
        int minIndex = getMinIndex();
        ArrayList<Node> atIndex = freq.getOrDefault(minIndex, new ArrayList<Node>());
        
        System.out.println("AtIndex: "+ minIndex+ "  "+atIndex);
        // check here
        if(atIndex.size()>=1){
            int minInd = Integer.MAX_VALUE;
            Node minNode = null;
            
            for(Node n: atIndex){
                
                // Must take note
                int ind = recency.lastIndexOf(n);
                if(ind<minInd){
                    minInd = ind;
                    minNode = n;
                }
            }
            
            System.out.println("Key: "+minNode.key+" value: "+minNode.value+"  freq: "+minNode.freq);
            map.remove(minNode.key);
            recency.remove(minNode);
            
            // remove from freq
            if(atIndex.size() == 1){
                freq.remove(minIndex);
            } else {
                atIndex.remove(minNode);
                freq.put(minIndex, atIndex);
            }
            
        }
        
        System.out.println("minINdex: "+ minIndex);
        System.out.println("Map : " + map);
        System.out.println("Freq: " + freq);
        System.out.println("Recency: "+recency);
        
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
