class Solution {
    public int maxDepth(String s) {
    // Simply, count the max Opening parenthesis

        int n = s.length();
        int maxOpen = 0;
        int currOpen = 0;

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                currOpen++;
                maxOpen = Math.max(maxOpen, currOpen);
            }
            else if (ch == ')')
                currOpen--;
        }

        return maxOpen;
    }
}