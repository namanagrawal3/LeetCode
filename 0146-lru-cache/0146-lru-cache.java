class LRUCache {
// We will maintain a 'doubly linkedlist' and keep the latest operation performed element at the last
// Thus, least recently used element will be present at the front
// Store the (address and value) pair for each key in a HashMap

    class Node {
        int data;
        Node prev;
        Node next;
        public Node(int val) {
            data = val;
        }
    }

    class Pair {
        int val;
        Node node;
        public Pair(int v, Node nn) {
            val = v;
            node = nn;
        }
    }

    private Node head;
    private Node tail;
    private int size;
    
    private HashMap<Integer, Pair> map;
    private int cap;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        cap = capacity;
    }
    
    public int get(int key) {
        if (!map.containsKey(key))
            return -1;

        Pair p = map.get(key);
        int rv = p.val;
        Node nn = p.node;

        // removing the node 'nn' and then adding it to the end
        Node prv = nn.prev;
        Node nxt = nn.next;
        if (prv == null && nxt == null) {
            return rv;
        }
        else if (prv == null) {
            nxt.prev = null;
            head.next = null;
            head = nxt;
            size--;
            addLast(nn);
        } 
        else if (nxt == null)
            return rv;
        else {
            prv.next = nxt;
            nxt.prev = prv;
            nn.next = null;
            nn.prev = null;
            size--;
            addLast(nn);
        }

        return rv;
    }
    
    public void put(int key, int value) {
        if (!map.containsKey(key)) {
            if (size == cap) {
                Node rv = removeFirst();
                map.remove(rv.data);
            }
            Node nn = new Node(key);
            map.put(key, new Pair(value, nn));
            addLast(nn);
        }
        else {
            Pair p = map.get(key);
            p.val = value;
            Node nn = p.node;

            // removing the node 'nn' and then adding it to the end
            Node prv = nn.prev;
            Node nxt = nn.next;
            if (prv == null && nxt == null) {
                return;
            }
            else if (prv == null) {
                nxt.prev = null;
                head.next = null;
                head = nxt;
                size--;
                addLast(nn);
            } 
            else if (nxt == null)
                return;
            else {
                prv.next = nxt;
                nxt.prev = prv;
                nn.next = null;
                nn.prev = null;
                size--;
                addLast(nn);
            }
        }
    }

    private void addLast(Node nn) {
        if (size == 0) {
            head = nn;
            tail = nn;
        }
        else {
            tail.next = nn;
            nn.prev = tail;
            tail = nn;
        }
        size++;
    }

    public Node removeFirst() {
        if (size == 0)
            return null;

        Node rv = head;
        if (size == 1) { 
            head = null;
            tail = null;
        }
        else {
            Node nxt = head.next;
            nxt.prev = null;
            head.next = null;
            head = nxt;
        }
        size--;
        return rv;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */