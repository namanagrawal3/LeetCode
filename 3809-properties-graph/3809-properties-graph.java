class Solution {
    public int numberOfComponents(int[][] properties, int k) {
        int n = properties.length;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {           // finding the intersection of arrays
            HashSet<Integer> set1 = new HashSet<>();
            for (int ele: properties[i]) {
                set1.add(ele);
            }

            for (int j = i+1; j < n; j++) {
                int intersect = 0;
                HashSet<Integer> set2 = new HashSet<>();
                for (int ele: properties[j]) {
                    set2.add(ele);
                }

                for (int tar: set2) {
                    if (set1.contains(tar))
                        intersect++;
                }

                if (intersect >= k) {           // adding the edge 
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }

        int components = 0;
        boolean[] visited = new boolean[n];

        for (int src = 0; src < n; src++) {    // applying the BFT 
            if (visited[src])
                continue;

            Queue<Integer> q = new ArrayDeque<>();
            q.add(src);
            components++;

            while (!q.isEmpty()) {
                int rv = q.poll();
                if (visited[rv])
                    continue;

                visited[rv] = true;
                for (int nbr : adj.get(rv)) {
                    if (!visited[nbr])
                        q.add(nbr);
                }
            }
        }

        return components;
    }
}