class Solution {
    public int minSwaps(String s) {
        int n = s.length();
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == '[')
                st.push(ch);
            else if (!st.isEmpty() && st.peek() == '[')
                st.pop();
        }

        int open = st.size();
        return (open + 1)/2;
    }
}