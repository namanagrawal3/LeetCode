class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);

        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < n-1; i++) {
            minDiff = Math.min(minDiff, arr[i+1] - arr[i]);
        }

        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n-1; i++) {
            if (arr[i+1] - arr[i] == minDiff) {
                List<Integer> l = new ArrayList<>();
                l.add(arr[i]);
                l.add(arr[i+1]);
                ans.add(l);
            }
        }

        return ans;
    }
}