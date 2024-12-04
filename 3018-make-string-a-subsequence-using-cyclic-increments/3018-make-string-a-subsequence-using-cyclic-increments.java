class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        int a = str1.length();
        int b = str2.length();
        if (b > a)
            return false;

        int i = 0, j = 0;
        while (i < a && j < b) {
            char ch1 = str1.charAt(i);
            char ch2 = str2.charAt(j); 
            if (ch1 == ch2 || cycleFun(ch1, ch2)) 
                j++;
            i++;            
        }

        return j == b;
    }
    public boolean cycleFun(char ch1, char ch2) {
        ch1++;
        if (ch1 == 123)
            ch1 = 'a';

        return ch1 == ch2;
    }
}