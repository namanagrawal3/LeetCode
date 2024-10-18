class Solution {
    class Tuple {
        int u;
        int v;
        int c;
        int i;
        public Tuple(int u, int v, int c, int i) {
            this.u = u;
            this.v = v;
            this.c = c;
            this.i = i;
        }
    }
    int[] parent;
    int[] rank;

    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        int e = edges.length;
        List<Tuple> edge = new ArrayList<>();
        for (int i = 0; i < e; i++) {
            int[] ed = edges[i];
            edge.add(new Tuple(ed[0], ed[1], ed[2], i));
        }

        Collections.sort(edge, new Comparator<Tuple>() { // sort edges on the basis of cost
            @Override
            public int compare(Tuple a, Tuple b) {
                return a.c - b.c;
            }
        });

        int mstWeight = krushkal(edge, -1, -1, n);       // calculate the MST weight

        List<Integer> critical = new ArrayList<>();
        List<Integer> pseudoCritical = new ArrayList<>();

        for (Tuple tp : edge) {
            int skipWeight = krushkal(edge, tp.i, -1, n);
            int IncWeight = krushkal(edge, -1, tp.i, n);

            if (skipWeight > mstWeight)
                critical.add(tp.i);
            else if (IncWeight == mstWeight)
                pseudoCritical.add(tp.i);
        }

        List<List<Integer>> ans = new ArrayList<>();
        ans.add(critical);
        ans.add(pseudoCritical);
        return ans;
    }
    public int krushkal(List<Tuple> edge, int skipIdx, int incIdx, int n) {
        parent = new int[n];
        rank = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        Arrays.fill(rank, 0);

        int mstCost = 0;
        if (incIdx != -1) {
            for (Tuple tp : edge) {
                if (tp.i == incIdx) {
                    union(tp.u, tp.v);
                    mstCost += tp.c;
                    break;
                }
            }
        }

        for (Tuple tp : edge) {
            if (tp.i == skipIdx)
                continue;

            int u = tp.u;
            int v = tp.v;
            int cost = tp.c;

            int p1 = findParent(u);
            int p2 = findParent(v);
            if (p1 != p2) {
                mstCost += cost;
                union(u, v);
            }
        }

        for (int i = 0; i < n; i++) {
            if (findParent(i) != findParent(0))// MST is not formed (more than 2 components)
                return Integer.MAX_VALUE;
        }
        return mstCost;
    }
    public int findParent(int x) {
        if (x == parent[x])
            return x;
        return parent[x] = findParent(parent[x]);
    }
    public void union(int x, int y) {
        int px = findParent(x);
        int py = findParent(y);
        if (px == py)
            return;

        if (rank[px] > rank[py])
            parent[py] = px;
        else if (rank[px] < rank[py])
            parent[px] = py;
        else {
            parent[py] = px;
            rank[px]++;
        }
    }
}