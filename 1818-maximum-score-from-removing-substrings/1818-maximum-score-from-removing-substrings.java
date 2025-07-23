class Solution {
    public int maximumGain(String s, int x, int y) {
        int n = s.length();
        Stack<Character> st = new Stack<>();
        int score = 0;

        char ch1 = 'a', ch2 = 'b';
        boolean X = true;
        if (y > x) {
            ch1 = 'b';
            ch2 = 'a';
            X = false;
        }

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if (!st.isEmpty() && ch == ch2 && st.peek() == ch1)
                st.pop();
            else
                st.push(ch);
        }

        score = (n - st.size())/2 * (X ? x : y);

        StringBuilder temp = new StringBuilder();
        for (char ch : st) {
            temp.append(ch);
        }

        if (X) {
            ch1 = 'b';
            ch2 = 'a';
        }
        else {
            ch1 = 'a';
            ch2 = 'b';
        }

        st.clear();
        n = temp.length();

        for (int i = 0; i < n; i++) {
            char ch = temp.charAt(i);

            if (!st.isEmpty() && ch == ch2 && st.peek() == ch1)
                st.pop();
            else
                st.push(ch);
        }

        score += (n - st.size())/2 * (X ? y : x);

        return score;
    }
}