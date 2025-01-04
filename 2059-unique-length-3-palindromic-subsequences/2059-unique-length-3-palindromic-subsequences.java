class Solution {
    class Pair {
        int left = -1;
        int right = -1;
        public Pair() {}
    }
    public int countPalindromicSubsequence(String s) {
        int n = s.length();
        List<Pair> l = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            l.add(new Pair());
        }

        for (int i = 0; i < n; i++) {         // pre-computing the left & right indices
            int idx = s.charAt(i) - 'a';
            int left_idx = l.get(idx).left;

            if (left_idx == -1)
                l.get(idx).left = i;
            l.get(idx).right = i;
        }

        int cnt = 0;
        for (int i = 0; i < 26; i++) {
            int left_idx = l.get(i).left;
            int right_idx = l.get(i).right;

            if (left_idx == -1)
                continue;

            HashSet<Character> set = new HashSet<>();
            for (int j = left_idx+1; j <= right_idx-1; j++) {
                set.add(s.charAt(j));
            }

            cnt += set.size();
        }

        return cnt;
    }
}