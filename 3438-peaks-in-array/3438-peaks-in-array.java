class Solution {
    public List<Integer> countOfPeaks(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] peak = new int[n];
        for (int i = 1; i < n-1; i++) {
            peak[i] = (nums[i] > nums[i-1] && nums[i] > nums[i+1]) ? 1 : 0;
        }

        int[] segTree = new int[4*n];
        buildSegmentTree(peak, 0, 0, n-1, segTree);

        List<Integer> ll = new ArrayList<>();
        for (int[] q: queries) {
            if (q[0] == 2) {
                int idx = q[1];
                int val = q[2];
                nums[idx] = val;

                // check and update peak[i], peak[i-1] & peak[i+1]
                if (idx > 0 && idx < n-1) {
                    int peaki = (nums[idx] > nums[idx-1] && nums[idx] > nums[idx+1]) ? 1 : 0;
                    if (peaki != peak[idx]) {
                        peak[idx] = peaki;
                        updateValue(idx, peaki, 0, 0, n-1, segTree);
                    }
                }

                if (idx-1 > 0) {
                    int peakiprev = (nums[idx-1] > nums[idx-2] && nums[idx-1] > nums[idx]) ? 1 : 0;
                    if (peakiprev != peak[idx-1]) {
                        peak[idx-1] = peakiprev;
                        updateValue(idx-1, peakiprev, 0, 0, n-1, segTree);
                    }
                }

                if (idx+1 < n-1) {
                    int peakinext = (nums[idx+1] > nums[idx] && nums[idx+1] > nums[idx+2]) ? 1 : 0;
                    if (peakinext != peak[idx+1]) {
                        peak[idx+1] = peakinext;
                        updateValue(idx+1, peakinext, 0, 0, n-1, segTree);
                    }
                }
            }
            else {
                int start = q[1];
                int end = q[2];
                if (start == end) {
                    ll.add(0);
                    continue;
                }
                
                int extremes = peak[start] + peak[end];
                ll.add(countRange(start, end, 0, 0, n - 1, segTree) - extremes);
            }
        }

        return ll;
    }
    public void buildSegmentTree(int[] prr, int i, int l, int r, int[] segTree) {
        if (l == r) {
            segTree[i] = prr[l];
            return;
        }

        int mid = (l + r)/2;
        buildSegmentTree(prr, 2*i + 1, l, mid, segTree);
        buildSegmentTree(prr, 2*i + 2, mid+1, r, segTree);

        segTree[i] = segTree[2*i + 1] + segTree[2*i + 2];
    }
    public void updateValue(int idx, int val, int i, int l, int r, int[] segTree) {
        if (l == r) {
            segTree[i] = val;
            return;
        }

        int mid = (l + r)/2;
        if (idx <= mid)
            updateValue(idx, val, 2*i + 1, l, mid, segTree);
        else
            updateValue(idx, val, 2*i + 2, mid+1, r, segTree);

        segTree[i] = segTree[2*i + 1] + segTree[2*i + 2];
    }
    public int countRange(int start, int end, int i, int l, int r, int[] segTree) {
        if (end < l || start > r)
            return 0;
        if (l >= start && r <= end)
            return segTree[i];

        int mid = (l + r)/2;
        int left = countRange(start, end, 2*i + 1, l, mid, segTree);
        int right = countRange(start, end, 2*i + 2, mid+1, r, segTree);
        return left + right;
    }
}