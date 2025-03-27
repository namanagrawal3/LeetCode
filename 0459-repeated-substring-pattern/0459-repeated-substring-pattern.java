class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        
        for (int len = n/2; len >= 1; len--) {
            int times = n/len;
            String sub = s.substring(0, len);
            
            StringBuilder temp = new StringBuilder();
            while (times-- > 0) {
                temp.append(sub);
            }
            
            if (temp.toString().equals(s))
                return true;
        }
        
        return false;
    }
}