class Allocator {
// Simply, do the iteration on an array and fill/empty the blocks

    private final int[] mem;
    private final int n;

    public Allocator(int n) {
        mem = new int[n];
        this.n = n;
    }
    
    public int allocate(int size, int mID) {
        int si = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (mem[i] != 0) {
                si = i+1;
                count = 0;
            }
            else 
                count++;
            
            if (count == size) {
                fillMemory(mem, si, i, mID);
                return si;
            }
        }
        return -1;
    }
    
    public int freeMemory(int mID) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (mem[i] == mID) {
                mem[i] = 0;
                count++;
            }
        }
        return count;
    }

    private void fillMemory(int[] mem, int si, int ei, int mID) {
        for (int i = si; i <= ei; i++) {
            mem[i] = mID;
        }
    }
}

/**
 * Your Allocator object will be instantiated and called as such:
 * Allocator obj = new Allocator(n);
 * int param_1 = obj.allocate(size,mID);
 * int param_2 = obj.freeMemory(mID);
 */