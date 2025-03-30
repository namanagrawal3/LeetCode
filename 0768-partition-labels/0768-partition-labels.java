class Solution {
    public List<Integer> partitionLabels(String s) {
        int n = s.length();
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            map.put(ch, i);
        }

        List<Integer> ans = new ArrayList<>();
        int prev_j = 0, j = 0;

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            j = Math.max(j, map.get(ch));

            if (i == j) {
                ans.add(j - prev_j + 1);
                prev_j = j+1;
            }
        }

        return ans;
    }
}