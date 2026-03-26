class Solution {
    public String addStrings(String s1, String s2) {
    // Simply use the 'Number System' 
    
        int n = s1.length();
        int m = s2.length();
        int carry = 0;
        
        StringBuilder s = new StringBuilder();
        int i = n-1, j = m-1;
        while (i >= 0 && j >= 0) {
            int ch1 = s1.charAt(i) - '0';
            int ch2 = s2.charAt(j) - '0';
            int ans = (carry + ch1 + ch2) % 10;
            carry = (carry + ch1 + ch2) / 10;
            s.append(ans);
            i--;
            j--;
        }
        
        while (i >= 0) {
            int ch1 = s1.charAt(i) - '0';
            int ans = (carry + ch1) % 10;
            carry = (carry + ch1) / 10;
            s.append(ans);
            i--;
        }
        
        while (j >= 0) {
            int ch2 = s2.charAt(j) - '0';
            int ans = (carry + ch2) % 10;
            carry = (carry + ch2) / 10;
            s.append(ans);
            j--;
        }
        
        if (carry > 0)
            s.append(carry);
        
        // while (s.length() > 1 && s.charAt(s.length()-1) == '0') {
        //     s.deleteCharAt(s.length()-1);
        // }
        
        return s.reverse().toString(); 
    }
}