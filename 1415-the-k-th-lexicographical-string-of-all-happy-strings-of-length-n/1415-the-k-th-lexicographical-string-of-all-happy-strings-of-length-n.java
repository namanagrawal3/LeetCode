class Solution {
    public String getHappyString(int n, int k) {
        // Recursively generate all the strings and sort them

        int total = 3 * (1 << n-1);
        if (k > total)
            return "";

        List<String> l = new ArrayList<>();
        genFun(n, "", l);
        Collections.sort(l);

        return l.get(k-1);
    }
    public void genFun(int n, String s, List<String> l) {
        if (n == 0) {
            l.add(s);
            return;
        }

        int len = s.length();
        if (len == 0) {
            genFun(n-1, s+'a', l);
            genFun(n-1, s+'b', l);
            genFun(n-1, s+'c', l);
        }
        else if (s.charAt(len-1) == 'a') {
            genFun(n-1, s+'b', l);
            genFun(n-1, s+'c', l);
        }
        else if (s.charAt(len-1) == 'b') {
            genFun(n-1, s+'a', l);
            genFun(n-1, s+'c', l);
        }
        else {
            genFun(n-1, s+'a', l);
            genFun(n-1, s+'b', l);
        }
    }
}