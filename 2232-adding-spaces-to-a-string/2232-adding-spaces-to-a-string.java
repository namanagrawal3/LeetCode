class Solution {
    public String addSpaces(String s, int[] spaces) {
        int n = s.length();
        HashSet<Integer> set = new HashSet<>();
        for (int spc : spaces) {
            set.add(spc);
        }

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (set.contains(i))
                ans.append(' ');
            ans.append(s.charAt(i));
        }

        return ans.toString();
    }
}