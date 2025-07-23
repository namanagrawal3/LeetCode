class NumArray {
    private int[] segTree;
    private int n;

    public NumArray(int[] nums) {
        n = nums.length;
        segTree = new int[4*n];
        buildSegmentTree(nums, 0, 0, n-1, segTree);
    }

    private void buildSegmentTree(int[] nums, int i, int l, int r, int[] segTree) {
        if (l == r) {
            segTree[i] = nums[l];
            return;
        }

        int mid = (l + r)/2;
        buildSegmentTree(nums, 2*i + 1, l, mid, segTree);
        buildSegmentTree(nums, 2*i + 2, mid+1, r, segTree);

        segTree[i] = segTree[2*i + 1] + segTree[2*i + 2];
    }
    
    public void update(int index, int val) {
        updateSegmentTree(index, val, 0, 0, n-1, segTree);
    }

    private void updateSegmentTree(int idx, int val, int i, int l, int r, int[] segTree) {
        if (l == r) {
            segTree[i] = val;
            return;
        }
        
        int mid = (l + r)/2;
        if (idx <= mid)
            updateSegmentTree(idx, val, 2*i + 1, l, mid, segTree);
        else 
            updateSegmentTree(idx, val, 2*i + 2, mid+1, r, segTree);

        segTree[i] = segTree[2*i + 1] + segTree[2*i + 2];
    }
    
    public int sumRange(int left, int right) {
        return sumSegmentTree(left, right, 0, 0, n-1, segTree);
    }

    private int sumSegmentTree(int start, int end, int i, int l, int r, int[] segTree) {
        if (end < l || r < start)
            return 0;
        if (l >= start && r <= end)
            return segTree[i];
        
        int mid = (l + r)/2;
        int left = sumSegmentTree(start, end, 2*i + 1, l, mid, segTree);
        int right = sumSegmentTree(start, end, 2*i + 2, mid+1, r, segTree);
        return left + right;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */