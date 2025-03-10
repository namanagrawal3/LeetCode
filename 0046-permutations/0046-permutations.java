class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> l = new ArrayList<>();

        boolean[] visited = new boolean[nums.length];
        permutation(nums, l, ans, visited);
        return ans;
    }
    public void permutation(int[] arr, List<Integer> l, List<List<Integer>> ans, boolean[] visited) {
        if (allVisited(visited)) {
            ans.add(new ArrayList<>(l));
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (visited[i])
                continue;
            
            visited[i] = true;
            l.add(arr[i]);
            permutation(arr, l, ans, visited);
            visited[i] = false;
            l.remove(l.size()-1);
        }
    }
    public boolean allVisited(boolean[] visited) {
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i])
                return false;
        }
        return true;
    }
}