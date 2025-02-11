class Solution {
    public String removeOccurrences(String s, String part) {
        int n = s.length();
        int p = part.length();
        char pLastChar = part.charAt(p-1);
        StringBuilder st = new StringBuilder();        // using 'String' as a Stack

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            st.append(ch);

            if (st.length() >= p && ch == pLastChar) {
                if (st.substring(st.length()-p).equals(part))
                    st.delete(st.length()-p, st.length());
            }
        }

        return st.toString();
    }
}