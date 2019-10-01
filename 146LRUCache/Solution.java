// Hashmap with reference to values. Queue is cache that has values.
// When putting and getting move value to front
// When putting/getting existing keys, move values to front

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class LRUCache {
    class Queue{
        Node front,rear;
        class Node{
            int data;
            Node next,prev;
            Node(int data){
                this.data = data;
                this.next = null;
                this.prev = null;
            }
        }

        public Queue(){
           front = null;
           rear = null;
        }

        Node pushFront(int data){
            Node temp = new Node(data);
            if(this.size() == 0){
                this.front = this.rear = temp;
            } else {
                temp.next = this.front;
                this.front.prev = temp;
                this.front = temp;
            }
            return temp;
        }

        Node moveNodeToFront(Node node){
            if(!nodeExists(node)) {
                System.out.println("does not + " + node);
                return null;
            }

            if(this.front == node) {
                return node;

            } else if(this.rear == node){

               Node temp = new Node(node.data);
                   // Rear
               this.rear = this.rear.prev;
               this.rear.next = null;

                    // Front
               temp.next = this.front;
               this.front.prev = temp;
               this.front = temp;
               this.front.prev = null;


            } else {
                Node before = node.prev, after = node.next;
                before.next = after;
                after.prev = before;

                // Front
                node.next = this.front;
                this.front.prev = node;
                this.front = node;
                this.front.prev = null;

            }
            return this.front;
        }

        boolean nodeExists(Node n){
           if(this.size() == 0)
                return false;
            Node temp = this.front;
            while(temp!=null){
                System.out.println("temp data: " + temp.data+" node data: "+n.data);
                if(temp.data == n.data)
                    return true;
                temp = temp.next;
            }
            return false;
        }

        Node popRear(){
            Node poppedNode = null;
            if(this.size() == 0){
                return null;
            }
            if(this.front == this.rear){
                poppedNode = this.front;
                this.front = this.rear = null;
            } else {
                // NOTE 1: Had placed this.front with this.rear
                poppedNode = this.rear;
                this.rear = this.rear.prev;
                this.rear.next = null;
            }
            return poppedNode;
        }

        int size() {
            if(front == null && rear == null)
                return 0;
            int count = 0;
            Node temp = front;
            while(temp != null) {
                temp = temp.next;
                count++;
            }
            return count;
        }

        void display(){
            if(this.front == null) return;
            Node temp = this.front;
            System.out.print("Queue: ");
            while(temp != null){
                System.out.print(temp.data + " -> ");
                temp = temp.next;
            }

            System.out.print("  F: "+this.front +"=" + this.front.data+"   R:"+this.rear+"="+this.rear.data);
            System.out.println("\n");
        }

    }

    HashMap<Integer, Queue.Node> hm;
    Queue Cache;
    int cacheSize;
    LRUCache(int size){
        cacheSize = size;
        hm = new HashMap<>();
        Cache = new Queue();
    }

    public int get(int key){
        System.out.println("GET: "+key);
        if(hm.containsKey(key)){

          // NOTE 2: If key is already in HM, then just change the node value and MOVE it to front
          Queue.Node res = Cache.moveNodeToFront(hm.get(key));
          hm.put(key,res);
            System.out.println("GET: inside containsKey + "+hm+" returnNode: " + res);
            show();
          return res.data;
        }
        System.out.println("GET: -1");
        show();
        return -1;
    }

    public void put(int key, int value){
        System.out.println("PUT: "+key+","+value);

        if(hm.containsKey(key)) {
            // Change the value of the key

            // NOTE 3: If key is already in HM, then just change the node value and MOVE it to front
            System.out.println("Value of key: " + key + " changed from "+hm.get(key).data +" to "+value);
            hm.get(key).data = value;
            Queue.Node res = Cache.moveNodeToFront(hm.get(key));
            hm.put(key,res);
            System.out.println("PUT: inside containsKey + "+hm+" returnNode: " + res);
            show();
            return;
        }

        if(Cache.size() == cacheSize){
            Queue.Node poppedNode = Cache.popRear();
            System.out.println("Removed Node: "+poppedNode+" Data: "+poppedNode.data);
            removeFromHM(poppedNode);
        }
        hm.put(key,Cache.pushFront(value));
        System.out.println("New HM: " +hm);
        show();
    }

    public void removeFromHM(Queue.Node node){
        Iterator it = hm.entrySet().iterator();
        int keyToRemove = -121;
        while(it.hasNext()){
            Map.Entry entry = (Map.Entry) it.next();
            if(entry.getValue().equals(node)){
                keyToRemove = (int)entry.getKey();
                break;
            }
        }
        if(keyToRemove!=-121){
            hm.remove(keyToRemove);
        }
    }

    public void show(){
        Cache.display();
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);

//        ["LRUCache","put","put","put","put","get","get"]
//[[2],[2,1],[1,1],[2,3],[4,1],[1],[2]]
//
//        cache.put(2,1);
//        cache.put(1,1);
//        cache.put(2,3);
//        cache.put(4,1);
//        cache.get(1);
//        cache.get(2);

//        ["LRUCache","get","put","get","put","put","get","get"]
//[[2],[2],[2,6],[1],[1,5],[1,2],[1],[2]]
//        cache.get(2);
//        cache.put(2,6);
//        cache.get(1);
//        cache.put(1,5);
//        cache.put(1,2);
//        cache.get(1);
//        cache.get(2);


//        ["LRUCache","put","put","get","put","get","put","get","get","get"]
//[[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]

//        cache.put(1,1);
//        cache.put(2,2);
//        cache.get(1);
//        cache.put(3,3);
//        cache.get(2);
//        cache.put(4,4);
//        cache.get(1);
//        cache.get(3);
//        cache.get(4);

//       ["LRUCache","put","get","put","get","get"]
//[[1],[2,1],[2],[3,2],[2],[3]]
//       cache.put(2,1);
//       cache.get(2);
//       cache.put(3,2);
//       cache.get(2);
//       cache.get(3);
    }
}

