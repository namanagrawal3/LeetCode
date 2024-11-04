class Solution {
    public int minJumps(int[] arr) {
        // clearly 'BFS' because we have to find the shortest path from src to des
        int n = arr.length;
        if (n == 1)
            return 0;

        boolean[] visited = new boolean[n];
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (!map.containsKey(arr[i]))
                map.put(arr[i], new ArrayList<>());
            map.get(arr[i]).add(i);
        }

        Queue<Integer> q = new ArrayDeque<>();
        q.add(0);
        visited[0] = true;
        int level = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int rv = q.poll();
                if (rv == n-1)
                    return level;

                if (rv-1 >= 0 && visited[rv-1] == false) {       // left
                    q.add(rv-1);
                    visited[rv-1] = true;
                }

                if (rv+1 < n && visited[rv+1] == false) {        // right
                    q.add(rv+1);
                    visited[rv+1] = true;
                }

                if (map.containsKey(arr[rv])) {
                    for (int adj : map.get(arr[rv])) {
                        if (visited[adj] == false) 
                            q.add(adj);
                    }
                    map.remove(arr[rv]);
                }
            }
            level++;
        }

        return -1;
    }
}