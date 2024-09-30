class CustomStack {
    private int[] st;
    private int size = 0;
    private int top = 0;

    public CustomStack(int maxSize) {
        st = new int[maxSize];
    }
    
    public void push(int x) {
        if (size != st.length) {
            st[top] = x;
            top++;
            size++;
        }
    }
    
    public int pop() {
        if (size == 0)
            return -1;
        
        int rv = st[top-1];
        top--;
        size--;
        return rv;
    }
    
    public void increment(int k, int val) {
        for (int i = 0; i < Math.min(k, st.length); i++) {
            st[i] += val;
        }
    }
}


/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */