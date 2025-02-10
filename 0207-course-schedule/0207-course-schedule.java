class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        int[] inDeg = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] pre : prerequisites) {
            int u = pre[1];
            int v = pre[0];
            adj.get(u).add(v);
            inDeg[v]++;
        }

        Queue<Integer> q = new ArrayDeque<>();
        int cnt = 0;
        for (int i = 0; i < numCourses; i++) {
            if (inDeg[i] == 0)
                q.add(i);
        }

        while (!q.isEmpty()) {
            int rv = q.poll();
            cnt++;

            for (int nbr : adj.get(rv)) {
                inDeg[nbr]--;
                if (inDeg[nbr] == 0)
                    q.add(nbr);
            }
        }

        return cnt == numCourses;
    }
}