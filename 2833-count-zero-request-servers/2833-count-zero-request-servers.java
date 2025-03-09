class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        List<int[]> query = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            query.add(new int[]{i, queries[i]});
        }

        // Sorting the logs and query on the basis of time
        Arrays.sort(logs, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[1] - b[1];
            }
        });

        Collections.sort(query, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[1] - b[1];
            }
        });

        int[] req = new int[n+1];
        int[] ans = new int[queries.length];        
        int si = 0, ei = 0;
        int uniqueServer = 0;
        
        for (int[] q : query) {
            int time = q[1];
            int idx = q[0];
            
            // growing the window
            while (ei < logs.length && logs[ei][1] <= time) {
                if (req[logs[ei][0]] == 0)
                    uniqueServer++;
                req[logs[ei][0]]++;
                ei++;
            }
            
            // shrinking the window
            while (si < logs.length && logs[si][1] < time-x) {
                req[logs[si][0]]--;
                if (req[logs[si][0]] == 0)
                    uniqueServer--;
                si++;
            }
            
            ans[idx] = n - uniqueServer;
        }
        
        return ans;
    }
}