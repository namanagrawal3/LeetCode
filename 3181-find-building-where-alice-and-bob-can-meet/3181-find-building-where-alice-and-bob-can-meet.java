class Solution {
    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
    // Variation of Min/Max Idx Range using Binary Search (Segment Tree)
        int n = heights.length;
        int q = queries.length;
        int[] ans = new int[q];
        
        int[] segTree = new int[4*n];
        buildSegmentTree(heights, 0, 0, n-1, segTree);

        for (int i = 0; i < q; i++) {
            int alicePos = queries[i][0];
            int bobPos = queries[i][1];
            int minIdx = Math.min(alicePos, bobPos);
            int maxIdx = Math.max(alicePos, bobPos);

            if (minIdx == maxIdx)
                ans[i] = minIdx;
            else if (heights[minIdx] < heights[maxIdx])
                ans[i] = maxIdx;
            else {
                int l = maxIdx+1;
                int r = n-1;
                int res = n;

                while (l <= r) {
                    int mid = l + (r-l)/2;
                    int idx = rangeMax(l, mid, 0, 0, n-1, heights, segTree);
                    if (heights[idx] > heights[minIdx] && heights[idx] > heights[maxIdx]) {
                        res = Math.min(res, idx);
                        r = mid - 1;
                    }
                    else
                        l = mid + 1;
                }

                ans[i] = (res == n) ? -1 : res;
            }
        }

        return ans;
    }
    public void buildSegmentTree(int[] heights, int i, int l, int r, int[] segTree) {
        if (l == r) {
            segTree[i] = l;
            return;
        }

        int mid = (l + r)/2;
        buildSegmentTree(heights, 2*i + 1, l, mid, segTree);
        buildSegmentTree(heights, 2*i + 2, mid+1, r, segTree);

        if (heights[segTree[2*i + 1]] > heights[segTree[2*i + 2]])
            segTree[i] = segTree[2*i + 1];
        else
            segTree[i] = segTree[2*i + 2];
    }
    public int rangeMax(int start, int end, int i, int l, int r, int[] heights, int[] segTree) {
        if (end < l || start > r)
            return -1;
        if (l >= start && r <= end)
            return segTree[i];

        int mid = (l + r)/2;
        int leftIdx = rangeMax(start, end, 2*i + 1, l, mid, heights, segTree);
        int rightIdx = rangeMax(start, end, 2*i + 2, mid+1, r, heights, segTree);

        if (leftIdx == -1)
            return rightIdx;
        if (rightIdx == -1)
            return leftIdx;

        return (heights[leftIdx] > heights[rightIdx]) ? leftIdx : rightIdx;
    }
}