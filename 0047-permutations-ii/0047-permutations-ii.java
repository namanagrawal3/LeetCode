class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        boolean[] visited = new boolean[n];

        Arrays.sort(nums);
        permutation(nums, l, ans, visited, n);
        return ans;
    }
    public void permutation(int[] arr, List<Integer> l, List<List<Integer>> ans, boolean[] visited, int n) {
        if (n == 0) {
            ans.add(new ArrayList<>(l));
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (visited[i] || checkOccurLater(arr, visited, i))
                continue;

            visited[i] = true;
            l.add(arr[i]);
            permutation(arr, l, ans, visited, n-1);
            visited[i] = false;
            l.remove(l.size()-1);
        }
    }
    public boolean checkOccurLater(int[] arr, boolean[] visited, int idx) {
        for (int i = idx+1; i < arr.length; i++) {
            if (arr[i] == arr[idx] && visited[i] == false)
                return true;
        }
        return false;
    }
}