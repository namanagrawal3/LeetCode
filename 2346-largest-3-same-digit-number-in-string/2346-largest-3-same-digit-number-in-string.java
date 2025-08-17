class Solution {
    public String largestGoodInteger(String num) {
        int n = num.length();
        char maxDigit = ' ';

        for (int i = 0; i <= n-3; i++) {
            if (num.charAt(i) == num.charAt(i+1) && num.charAt(i) == num.charAt(i+2)) 
                maxDigit = (char) Math.max(maxDigit, num.charAt(i));
        }

        if (maxDigit == ' ')
            return "";
        return maxDigit +""+ maxDigit +""+ maxDigit;
    }
}