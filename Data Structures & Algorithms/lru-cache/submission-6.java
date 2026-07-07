class LRUCache {
    int cap;
    int size;
    Node head;
    Node tail;
    HashMap<Integer, Node> map;

    public LRUCache(int capacity) {
        cap = capacity;
        size = 0;
        head= null;
        tail = null;
        map = new HashMap<>();
    }
    
    public int get(int key) {
        System.out.println("get" + key);
        if(map.get(key) == null){
            return -1;
        } else {
            Node node = map.get(key);  
            node = removeNode(node);
            node = addNode(node);
            return node.val;
        }    
    }
    
    public void put(int key, int value) {
        System.out.println(" add key value " + key + " " + value);
        // if key exists - update value and move to tail
        if(map.containsKey(key)){
            System.out.println("updating value");
            Node node = map.get(key);
            node.val = value;
            node = removeNode(node);
            node = addNode(node);
            map.entrySet().forEach(entry -> System.out.print(entry.getKey() + "---"+entry.getValue().val +";"));
            return;
        }

        // if key doest not exist and size < cap - add to tail
        if(size < cap) {
            Node node = new Node(key, value);
            node = addNode(node);
            map.put(key,node);
            size++;
            System.out.println("size update to" + size);
            map.entrySet().forEach(entry -> System.out.print(entry.getKey() + "---"+entry.getValue().val +";"));
            return;
        }
        //if key does not exist - 1. remove from map, 2. move head forward, 3. add new to tail
        map.remove(head.key);
        System.out.println("removing old head " + head.val);
        System.out.println("new map");
        map.entrySet().forEach(entry -> System.out.print(entry.getKey() + "---"+entry.getValue().val +";"));
        Node temp = head.next;
        removeNode(head);
        head = temp;
        //System.out.println("new head " + head.val);
        Node node = new Node(key, value);
        node = addNode(node);
        map.put(key,node);   
        map.entrySet().forEach(entry -> System.out.print(entry.getKey() + "---"+entry.getValue().val +";"));     
    }

    private Node addNode(Node node) {
        if(head == null) {
            head = node;
            tail = node;
            node.next = null;
            node.prev = null;
        } else {
            node.prev = tail;
            tail.next = node;
            tail = node;
        }
        return node;    
    }

    private Node removeNode(Node node) {
        if(node.next == null && node.prev == null){
            tail = null;
            head = null;
        }else if(node.next == null) {
            node.prev.next = null;
            tail = tail.prev;
            node.prev = null;
        } else if(node.prev == null) {
            node.next.prev = null;
            head = head.next;
            node.next = null;
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.prev = null;
            node.next = null;
        }
        return node;
    }

    class Node {
        int key;
        int val;
        Node next;
        Node prev;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}
