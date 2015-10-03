public class LRUCache {
    
    int size;
    int capacity;
    HashMap<Integer,Node> map;
    Node first;
    Node last;
    
    
    public LRUCache(int capacity) {
        
       this.capacity = capacity;
       size = 0;
       map = new HashMap<Integer,Node>();
    }
    
    public int get(int key) {
        
       Node node = map.get(key);
       if(node == null) return -1;
       else{
           moveTohead(node);
           return node.val;
       } 
    }
    
    public void set(int key, int value) {
        
        Node node = map.get(key);
        
        if(node == null){
            
            if(size == capacity){
                map.remove(last.key);
                removelast();
            }
            else size++;
            
            node = new Node(key,value);
        }
        
        if(size == 1)  first = last = node;
        
        node.val = value;
        moveTohead(node);
        map.put(key,node);
    }
    
    public void moveTohead(Node node){
        
        if(node == first) return;
        
        if(node.pre != null)node.pre.next = node.next;
        if(node.next != null)node.next.pre = node.pre;
        
        if(node == last) last = node.pre;
        
        if(first != null)   first.pre = node;
        node.pre = null;
        node.next = first;
        first = node;
    }
    
    public void removelast(){
        
       if(last != null){
           
           if(last.pre != null) last.pre.next = last.next;
           else first = null;
           
           last = last.pre;
       }
    }
    
}

class Node{
    
    public int key;
    public int val;
    public Node pre;
    public Node next;
    
    public Node(int key, int val){
        
        this.key = key;
        this.val = val;
    }
    
}
