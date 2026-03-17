class Solution {
    public boolean isPalindrome(String s) {
        int n = s.length();
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch >= 65 && ch <= 90)
                str.append((char)(ch+32));
            else if ((ch >= 48 && ch <= 57) || (ch >= 97 && ch <= 122))
                str.append(ch);
        }

        int left = 0, right = str.length()-1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right))
                return false;
            left++;
            right--;
        }

        return true;
    }
}