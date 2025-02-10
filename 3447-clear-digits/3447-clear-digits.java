class Solution {
    public String clearDigits(String s) {
        int n = s.length();
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch >= 48 && ch <= 57)
                st.pop();
            else
                st.push(ch);
        }

        StringBuilder ans = new StringBuilder();
        for (char ch : st) {
            ans.append(ch);
        }

        return ans.toString();
    }
}