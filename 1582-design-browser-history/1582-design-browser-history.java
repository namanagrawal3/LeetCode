class BrowserHistory {
    class Node {
        String url;
        Node prev;
        Node next;
        public Node(String s) {
            url = s;
        }
    }

    private Node curr;
    private Node head;

    public BrowserHistory(String homepage) {
        Node nn = new Node(homepage);
        curr = nn;
        head = nn;
    }
    
    public void visit(String url) {
        Node nn = new Node(url);
        curr.next = nn;
        nn.prev = curr;
        curr = nn;
    }
    
    public String back(int steps) {
        while (steps-- > 0 && curr != head) {
            curr = curr.prev;
        }
        return curr.url;
    }
    
    public String forward(int steps) {
        while (steps-- > 0 && curr.next != null) {
            curr = curr.next;
        }
        return curr.url;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */