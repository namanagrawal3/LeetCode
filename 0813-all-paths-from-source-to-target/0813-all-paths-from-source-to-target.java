class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        l.add(0);

        pathFun(graph, 0, n, l, ans);
        return ans;
    }
    public static void pathFun(int[][] graph, int curr, int n, List<Integer> l, List<List<Integer>> ans) {
        if (curr == n-1) {
            ans.add(new ArrayList<>(l));
            return;
        }

        for (int nbr : graph[curr]) {
            l.add(nbr);
            pathFun(graph, nbr, n, l, ans);
            l.remove(l.size()-1);
        }
    }
}