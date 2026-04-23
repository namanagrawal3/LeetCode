class Solution {
    int[] parent;
    int[] rank;

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
    // Simply use the DSU and for each component, store the letters in a Min-Heap

        int n = s.length();
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        rank = new int[n];
        
        // Performing the Union 
        for (List<Integer> pair: pairs) {
            int a = pair.get(0);
            int b = pair.get(1);
            if (find(a) != find(b))
                union(a, b);
        }

        // Storing the letters for each component in a Min-Heap
        HashMap<Integer, PriorityQueue<Character>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int parent = find(i);
            if (!map.containsKey(parent))
                map.put(parent, new PriorityQueue<>());

            PriorityQueue<Character> pq = map.get(parent);
            pq.add(s.charAt(i));
        }

        // Building the answer by iterating
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int parent = find(i);
            PriorityQueue<Character> pq = map.get(parent);
            ans.append(pq.poll());
        }

        return ans.toString();
    }
    public int find(int u) {
        if (parent[u] == u)
            return u;
        return parent[u] = find(parent[u]);
    }
    public void union(int u, int v) {
        int pu = find(u);
        int pv = find(v);
        if (pu == pv)
            return;

        if (rank[pu] > rank[pv])
            parent[pv] = pu;
        else if (rank[pu] < rank[pv])
            parent[pu] = pv;
        else {
            parent[pu] = pv;
            rank[pv]++;
        }
    }
}