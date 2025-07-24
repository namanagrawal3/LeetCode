class Solution {
    int[] inTime;
    int[] outTime;
    int time;

    public int minimumScore(int[] nums, int[][] edges) {
        // let us assume '0' as the root of the tree  

        int n = nums.length;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // inTime & outTime helps to check whether a node is descandant or ancestor
        inTime = new int[n];
        outTime = new int[n];
        int[] xrr = new int[n];
        time = 0;
        
        for (int[] e: edges) {
            int u = e[0];
            int v = e[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        dfsFun(adj, nums, xrr, 0, -1);

        int ans = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                int xor1 = 0, xor2 = 0, xor3 = 0;

                if (isDescendant(i, j)) {
                    xor1 = xrr[i];
                    xor2 = xrr[j] ^ xrr[i];
                    xor3 = xrr[0] ^ xor1 ^ xor2;
                }
                else if (isDescendant(j, i)) {
                    xor1 = xrr[j];
                    xor2 = xrr[i] ^ xrr[j];
                    xor3 = xrr[0] ^ xor1 ^ xor2;
                }
                else {
                    xor1 = xrr[i];
                    xor2 = xrr[j];
                    xor3 = xrr[0] ^ xor1 ^ xor2;
                }

                int max = Math.max(xor1, Math.max(xor2, xor3));
                int min = Math.min(xor1, Math.min(xor2, xor3));
                ans = Math.min(ans, max - min);
            }
        }
        
        return ans;
    }
    public int dfsFun(List<List<Integer>> adj, int[] nums, int[] xrr, int u, int parent) {
        inTime[u] = time;
        int xor = nums[u];

        for (int nbr: adj.get(u)) {
            if (nbr == parent)
                continue;
            time++;
            xor = xor ^ dfsFun(adj, nums, xrr, nbr, u);
        }

        time++;
        outTime[u] = time;
        xrr[u] = xor;
        return xor;
    }
    public boolean isDescendant(int u, int v) {
        return inTime[u] > inTime[v] && outTime[u] < outTime[v];
    }
}