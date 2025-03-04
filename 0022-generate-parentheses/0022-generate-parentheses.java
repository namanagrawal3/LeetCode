class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> l = new ArrayList<>();
        fun(n, 0, 0, "", l);
        return l;
    }
    public void fun(int n, int open, int close, String ans, List<String> l) {
        if (open == n && close == n) {
            l.add(ans);
            return;
        }

        if (open < n)
            fun(n, open+1, close, ans +'(', l);
        if (open > close)
            fun(n, open, close+1, ans +')', l);
    }
}