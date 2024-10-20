class Solution {
    public boolean parseBoolExpr(String expression) {
        int n = expression.length();
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            char ch = expression.charAt(i);
            if (ch == ',')
                continue;
            else if (ch != ')')
                st.push(ch);
            else {
                boolean trueOccur = false;
                boolean falseOccur = false;

                while (!st.isEmpty() && st.peek() != '(') {
                    char bool = st.pop();
                    if (bool == 'f')
                        falseOccur = true;
                    else
                        trueOccur = true;
                }
                st.pop();

                char opr = st.pop();
                st.push(Fun(opr, trueOccur, falseOccur));
            }
        }
        
        return (st.peek() == 'f') ? false : true;
    }
    public static char Fun(char opr, boolean trueOccur, boolean falseOccur) {
        if (opr == '!') {
            if (trueOccur)
                return 'f';
            return 't';
        }
        else if (opr == '|') {
            if (trueOccur)
                return 't';
            return 'f';
        }
        else {
            if (falseOccur)
                return 'f';
            return 't';
        }
    }
}