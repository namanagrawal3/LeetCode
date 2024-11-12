class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        int n = queries.length;
        int[] ans = new int[n];

// sort the items on the basis of increasing price
        Arrays.sort(items, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0])
                    return a[1] - b[1];
                return a[0] - b[0];
            }
        });

// assign maximum beauty that can be possible within a price
        int maxBeauty = 0;
        for (int i = 0; i < items.length; i++) {
            maxBeauty = Math.max(maxBeauty, items[i][1]);
            items[i][1] = maxBeauty;
        }

// use binary search to find the maximum possible beauty of that price
        for (int i = 0; i < n; i++) {
            int query = queries[i];
            int si = 0;
            int ei = items.length-1;

            while (si <= ei) {
                int mid = si + (ei-si)/2;
                if (items[mid][0] <= query)
                    si = mid + 1;
                else
                    ei = mid - 1;
            }

            if (ei < 0)
                continue;
            ans[i] = items[ei][1];
        }

        return ans;
    }
}