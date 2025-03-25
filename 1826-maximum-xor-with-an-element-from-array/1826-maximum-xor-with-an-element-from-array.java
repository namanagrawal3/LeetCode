class Solution {
    class Node {
        int bit;
        Node zeroChild;
        Node oneChild;
    }

    private Node root;

    public Solution() {
        root = new Node();
        root.bit = 2;
    }

    public void insert(int num) {
        Node curr = root;
        for (int i = 31; i >= 0; i--) {
            int currBit = (num & (1 << i)) != 0 ? 1 : 0;

            if (currBit == 1) {
                if (curr.oneChild != null)
                    curr = curr.oneChild;
                else {
                    Node nn = new Node();
                    nn.bit = 1;
                    curr.oneChild = nn;
                    curr = nn;
                }
            }
            else {
                if (curr.zeroChild != null)
                    curr = curr.zeroChild;
                else {
                    Node nn = new Node();
                    nn.bit = 0;
                    curr.zeroChild = nn;
                    curr = nn;
                }
            }
        }
    }

    public int getMaxXOR(int num) {
        Node curr = root;
        int ans = 0;
        for (int i = 31; i >= 0; i--) {
            int currBit = (num & (1 << i)) != 0 ? 1 : 0;

            if (currBit == 1) {
                if (curr.zeroChild != null) {
                    ans += (1 << i);
                    curr = curr.zeroChild;
                }
                else
                    curr = curr.oneChild;
            }
            else {
                if (curr.oneChild != null) {
                    ans += (1 << i);
                    curr = curr.oneChild;
                }
                else
                    curr = curr.zeroChild;
            }
        }

        return ans;
    }

    public int[] maximizeXor(int[] nums, int[][] queries) {
        int n = queries.length;
        int[][] query = new int[n][3];

        for (int i = 0; i < n; i++) {
            query[i][0] = queries[i][0];        // xi
            query[i][1] = queries[i][1];        // mi
            query[i][2] = i;                    // idx
        }

        Arrays.sort(nums);
        Arrays.sort(query, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[1] - b[1];
            }
        });

        Solution tt = new Solution();           // Binary-Trie
        int[] ans = new int[n];
        int i = 0;

        for (int[] q: query) {
            int xi = q[0];
            int mi = q[1];
            int idx = q[2];

            while (i < nums.length && nums[i] <= mi) {
                tt.insert(nums[i]);
                i++;
            }

            if (i > 0)
                ans[idx] = tt.getMaxXOR(xi);
            else
                ans[idx] = -1;
        }

        return ans;
    }
}