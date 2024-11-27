class Solution {
    public boolean isMatch(String s, String p) {
        return checkFun(s, p, 0, 0);
    }
    public boolean checkFun(String s, String p, int i, int j) {
        if (j == p.length())
            return i == s.length();

        boolean firstChar = (i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.')) ? true : false;

        if (j < p.length()-1 && p.charAt(j+1) == '*') {
            boolean take = firstChar && checkFun(s, p, i+1, j);
            boolean not_take = checkFun(s, p, i, j+2);
            return take || not_take;
        }
        
        return firstChar && checkFun(s, p, i+1, j+1);
    }
}