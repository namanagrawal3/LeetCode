class LFUCache {
    private class Node {
        int key, value;
        int freq;
        Node next, prev;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.freq = 1;
        }
    }

    
    private class DLL {
        private Node head, tail;
        private int size = 0;

        DLL() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
        }

        boolean isEmpty() {
            return size == 0;
        }

        void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }

        Node removeLast() {
            if (size == 0)
                return null;
            Node lru = tail.prev;
            remove(lru);
            return lru;
        }

        void insertAtFront(Node node) {
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
            node.prev = head;
            size++;
        }
    }


    private final int capacity;
    private final Map<Integer, Node> keyMap = new HashMap<>();
    private final Map<Integer, DLL> freqMap = new HashMap<>();
    private int minFreq;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        minFreq = 0;
    }
    
    public int get(int key) {
        if (!keyMap.containsKey(key))
            return -1;
        Node node = keyMap.get(key);
        updateFrequency(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if (keyMap.containsKey(key)) {
            Node node = keyMap.get(key);
            node.value = value;
            updateFrequency(node);
            return;
        }

        if (keyMap.size() == capacity) {
            DLL minFreqList = freqMap.get(minFreq);
            Node lru = minFreqList.removeLast();
            keyMap.remove(lru.key);
        }

        Node node = new Node(key, value);       // freq starts at 1
        keyMap.put(key, node);
        freqMap.computeIfAbsent(1, f -> new DLL()).insertAtFront(node);
        minFreq = 1;
    }

    private void updateFrequency(Node node) {
        int oldFreq = node.freq;
        DLL oldList = freqMap.get(oldFreq);
        oldList.remove(node);

        if (oldList.isEmpty() && oldFreq == minFreq)
            minFreq++;

        node.freq++;
        freqMap.computeIfAbsent(node.freq, f -> new DLL()).insertAtFront(node);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */