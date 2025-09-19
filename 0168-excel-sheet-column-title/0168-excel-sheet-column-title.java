class Solution {
    public String convertToTitle(int n) {
    // Simply convert the 'n' to 'Base 26' number

        StringBuilder ans = new StringBuilder();
        while (n > 0) {
            n--;
            int rem = n % 26;
            n = n / 26;
            ans.append((char)('A'+ rem));
        }

        return ans.reverse().toString();
    }
}