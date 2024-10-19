class LRUCache {
    Map<Integer, Node> map;
    Node head;
    Node tail;
    int total;
    public LRUCache(int capacity) {
        total = capacity;
        map = new HashMap<>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        
        Node current = map.get(key);
        remove(current);
        insert(current);
        return current.val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            remove(map.get(key));
        }
        
        if(map.size() == total){
            remove(tail.prev);
        }
        
        insert(new Node(key, value));
    }
    
    public void remove(Node current){
        map.remove(current.key);
        current.prev.next = current.next;
        current.next.prev = current.prev;
    }
    
    public void insert(Node current){
        map.put(current.key, current);
        head.next.prev = current;
        current.prev = head;
        current.next = head.next;
        head.next = current;
    }
}
class Node{
    int key;
    int val;
    Node prev;
    Node next;
    Node(int _key, int _val){
        key = _key;
        val = _val;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */