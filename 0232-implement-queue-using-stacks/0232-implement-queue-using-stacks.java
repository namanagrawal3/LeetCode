class MyQueue {
    private Stack<Integer> st;

    public MyQueue() {
        st = new Stack<>();
    }
    
    public void push(int x) {
        pushAtBottom(st, x);
    }

    public void pushAtBottom(Stack<Integer> st, int x) {
        if (st.size() == 0) {
            st.push(x);
            return;
        }

        int top = st.pop();
        pushAtBottom(st, x);
        st.push(top);
    }

    public int pop() {
        return st.pop();
    }
    
    public int peek() {
        return st.peek();
    }
    
    public boolean empty() {
        return st.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */