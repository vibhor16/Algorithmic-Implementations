// Hash function issue = Integer.hashCode(key) % CAPACITY
class MyHashMap {
    
    int CAP = 1000000;
    class Node{
        int key;
        int val;
        Node next;
        Node(int key,int val, Node next){
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }

    Node ar[];
    /** Initialize your data structure here. */
    public MyHashMap() {
        ar = new Node[CAP + 1];
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int hashcode = getHash(key);
        
        Node temp = new Node(key,value,null);
        if(ar[hashcode] == null) {
            ar[hashcode] = temp;
        } else{
            
            Node cur = ar[hashcode], prev = null;
            
            boolean isPresent = false;
            while(cur!=null){
                prev = cur;
                if(cur.key == key){
                  isPresent = true;
                  break;  
                } 
                cur = cur.next;
            }
            
            if(isPresent){
                cur.val = value;
            } else {
                prev.next = temp;
            }
            
        }
        
    }
    
    public int getHash(int n){
        return Integer.hashCode(n) % (CAP+1);
       
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        Node node = getNode(key);
        
        if(node!=null){
            return node.val;
        }
        
        return -1;
        
    }
    
    private Node getNode(int key){
        Node node = null;
        
        int hashcode = getHash(key);
        
        if(ar[hashcode] != null) {
            
            Node cur = ar[hashcode];
            
            boolean isPresent = false;
            while(cur!=null){
                if(cur.key == key){
                  isPresent = true;
                  node = cur;
                  break;  
                } 
                cur = cur.next;
            }
        }
        return node;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int hashcode = getHash(key);
        
        if(ar[hashcode] != null){
            if(ar[hashcode].key == key) {
                ar[hashcode] = null;
            } else{

                Node cur = ar[hashcode], prev = null;
                boolean isPresent = false;
                while(cur!=null){
                    prev = cur;
                    if(cur.key == key){
                      isPresent = true;
                      break;  
                    } 
                    cur = cur.next;
                }

                if(isPresent){
                    prev.next = null;
                } 
            }
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
