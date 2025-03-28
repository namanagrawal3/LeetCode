class Solution {
    public List<Integer> beautifulIndices(String s, String a, String b, int k) {
    // Using 'KMP' String-matching Algorithm for finding the idx
    // and using the 'Binary-search' for checking the valid idx
    
        List<Integer> a_idx = kmpFun(s, a);
        List<Integer> b_idx = kmpFun(s, b);

        List<Integer> ans = new ArrayList<>();
        for (int idx: a_idx) {
            if (checkFun(idx, b_idx, k))
                ans.add(idx);
        }

        return ans;
    }
    public List<Integer> kmpFun(String text, String pattern) {
        String s = pattern + "#" + text;
        int n = s.length();
        int[] dp = new int[n];
        List<Integer> l = new ArrayList<>();

        int len = 0;
        dp[0] = 0;
        int i = 1;

        while (i < n) {
            if (s.charAt(i) == s.charAt(len)) {
                len++;
                dp[i] = len;
                i++;
            }
            else {
                if (len > 0)
                    len = dp[len-1];
                else {
                    dp[i] = 0;
                    i++;
                }
            }
        }

        for (int j = pattern.length(); j < n; j++) {
            if (dp[j] == pattern.length())
                l.add(j - 2*pattern.length());
        }

        return l;
    }
    public boolean checkFun(int i, List<Integer> l, int k) {
        int lower_j = i - k;             // |i-j| <= k  ---> +(i-j) <= k  &  -(i-j) <= k
        int upper_j = i + k;

        int si = 0;
        int ei = l.size()-1;
        while (si <= ei) {
            int mid = si + (ei-si)/2;
            if (l.get(mid) >= lower_j)
                ei = mid - 1;
            else
                si = mid + 1;
        }

        if (si == l.size())
            return false;
        return l.get(si) <= upper_j;    
    }
}