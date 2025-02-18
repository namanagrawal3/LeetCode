class Solution {
    public String smallestNumber(String pattern) {
        int n = pattern.length();
        int[] ans = new int[n+1];
        Stack<Integer> st = new Stack<>();
        int count = 1;
        for (int i = 0; i <= n; i++) {
            if (i == n || pattern.charAt(i) == 'I') {
                ans[i] = count;
                count++;
                while (!st.isEmpty()) {
                    ans[st.pop()] = count;
                    count++;
                } 
            }
            else
                st.push(i);
        }
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < ans.length; i++) {
            s.append(ans[i]);
        }
        return s.toString();
    }
}