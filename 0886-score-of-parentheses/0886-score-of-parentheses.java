class Solution {
    public int scoreOfParentheses(String s) {
        int n = s.length();
        Stack<String> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == '(')
                st.push("(");
            else {
                int temp = 0;
                while (!st.peek().equals("(")) {
                    temp += Integer.parseInt(st.pop());
                }
                st.pop();
                temp = (temp == 0) ? 1 : 2*temp;
                st.push(String.valueOf(temp));
            }
        }

        int score = 0;
        while (!st.isEmpty()) {
            score += Integer.parseInt(st.pop());
        }

        return score;
    }
}