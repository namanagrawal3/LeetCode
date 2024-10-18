class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        // To count the components in this que, we can use DSU
        // since, here answer is unique so, DSU will not work

        List<Integer> ans = new ArrayList<>();
        int[] inDegree = new int[n];

        for (List<Integer> e: edges) {
            int u = e.get(0);
            int v = e.get(1);
            inDegree[v]++;
        } 

        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0)
                ans.add(i);
        }

        return ans;
    }
}