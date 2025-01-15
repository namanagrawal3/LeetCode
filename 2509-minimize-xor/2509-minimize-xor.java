class Solution {
    public int minimizeXor(int num1, int num2) {
        String n1 = Integer.toBinaryString(num1);
        String n2 = Integer.toBinaryString(num2);
        int c1 = countSet(n1);
        int c2 = countSet(n2);

        if (c1 == c2)
            return num1;
        else if (c1 > c2) {
            StringBuilder ans = new StringBuilder();
            int i = 0;
            while (c2 > 0) {
                char ch = n1.charAt(i);
                if (ch == '1')
                    c2--;
                ans.append(ch);
                i++;
            }
            
            while (i < n1.length()) {
                ans.append(0);
                i++;
            }  
                      
            return numFun(ans.toString());
        }
        else {
            int extra = c2 - c1;
            StringBuilder ans = new StringBuilder();
            int i = n1.length()-1;
            while (i >= 0 && extra > 0) {
                char ch = n1.charAt(i);
                if (ch == '0') {
                    extra--;
                    ans.append('1');
                }
                else 
                    ans.append(ch);
                i--;
            }
            while (i >= 0) {
                ans.append(n1.charAt(i));
                i--;
            }
            while (extra > 0) {
                ans.append('1');
                extra--;
            }
            
            return numFun(ans.reverse().toString());
        }
    }
    public static int countSet(String s) {
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1')
                cnt++;
        }
        return cnt;
    }
    public static int numFun(String s) {
        int n = s.length();
        int ans = 0;
        for (int i = n-1; i >= 0; i--) {
            if (s.charAt(i) == '1')
                ans += 1 << (n-1 - i);
        }
        return ans;
    }
}