class LRUCache {
    Node head = new Node(0,0);
    Node tail = new Node(0,0);
    Map<Integer, Node> map = new HashMap<>();
    int capacity;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        else
        {
            Node current = map.get(key);
            remove(current);
            insert(current);
            return current.val;
        }
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key))
        {
            remove(map.get(key));
        }
        if(capacity == map.size())
        {
            //LRU
            remove(tail.prev);
        }
        insert(new Node(key, value));
    }
    public void insert(Node current)
    {
        map.put(current.key, current);
        
        current.next = head.next;
        current.next.prev = current;
        head.next = current;
        current.prev = head;
    }
    public void remove(Node current)
    {
        map.remove(current.key);
        
        current.prev.next = current.next;
        current.next.prev = current.prev;
    }
}
class Node{
    Node prev, next;
    int key, val;
    Node(int k, int v)
    {
        key = k;
        val = v;
    }
}
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */