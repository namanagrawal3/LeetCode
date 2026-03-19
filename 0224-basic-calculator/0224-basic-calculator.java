class Solution {
    public int calculate(String s) {
    // Try to use the Stack (with dry run)

        int n = s.length();
        Stack<Integer> st = new Stack<>();
        
        int num = 0;
        int result = 0;
        int sign = 1;           // 1 -> +ve & -1 -> -ve  (initial +ve sign)

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch >= 48 && ch <= 57) {
                num = num * 10 + (ch -'0');
            }
            else if (ch == '+') {
                result += (num * sign);
                sign = 1;
                num = 0;
            }
            else if (ch == '-') {
                result += (num * sign);
                sign = -1;
                num = 0;
            }
            else if (ch == '(') {
                st.push(result);
                st.push(sign);

                num = 0;            // evaluate as the beginning
                result = 0;
                sign = 1;
            }
            else if (ch == ')') {
                result += (num * sign);
                num = 0;

                int currSign = st.pop();
                int prevResult = st.pop();
                result *= currSign;
                result += prevResult; 
            }
        }

        result += (num * sign);     // consider "1 + 1"
        return result;
    }
}