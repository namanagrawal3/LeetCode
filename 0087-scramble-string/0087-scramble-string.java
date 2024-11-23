class Solution {
    public boolean isScramble(String s1, String s2) {
        HashMap<String, Boolean> dp = new HashMap<>();
        return checkFun(s1, s2, dp);
    }
    public boolean checkFun(String s, String t, HashMap<String, Boolean> dp) {        
        int n = s.length();
        if (n == 1)
            return s.charAt(0) == t.charAt(0);
        if (s.equals(t))
            return true;

        if (dp.containsKey(s + " " + t))
            return dp.get(s + " " + t); 

        boolean ans = false; 
        for (int k = 1; k < n; k++) {
            boolean swap = checkFun(s.substring(0, k), t.substring(n-k), dp) && checkFun(s.substring(k), t.substring(0, n-k), dp);
            if (swap) {
                ans = true;
                break;
            }
            
            boolean not_swap = checkFun(s.substring(0, k), t.substring(0, k), dp) && checkFun(s.substring(k), t.substring(k), dp);
            if (not_swap) {
                ans = true;
                break;
            }
        }

        dp.put(s + " " + t, ans);
        return ans;
    }
}