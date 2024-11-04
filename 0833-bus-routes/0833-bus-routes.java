class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        // clearly 'BFS' because we have to find the least no. of buses from src to des
        if (source == target)
            return 0;

        int n = routes.length;
        HashMap<Integer, List<Integer>> map = new HashMap<>(); // stop -> bus route       
        for (int i = 0; i < n; i++) {
            for (int stop : routes[i]) {
                if (!map.containsKey(stop))
                    map.put(stop, new ArrayList<>());
                map.get(stop).add(i);
            }
        }

        boolean[] visited = new boolean[n];
        Queue<Integer> q = new ArrayDeque<>();
        int level = 0;

        if (!map.containsKey(source))
            return -1;

        for (int bus : map.get(source)) {
            visited[bus] = true;
            q.add(bus);           
        }

        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int rvBus = q.poll();

                for (int stop : routes[rvBus]) {
                    if (stop == target)
                        return level+1;

                    for (int bus : map.get(stop)) {
                        if (!visited[bus]) {
                            visited[bus] = true;
                            q.add(bus);
                        }
                    }
                }
            }
            level++;
        }

        return -1;
    }
}