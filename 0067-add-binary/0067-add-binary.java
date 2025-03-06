class Solution {
    public String addBinary(String a, String b) {
        StringBuilder ans = new StringBuilder();
        int i = a.length()-1;
        int j = b.length()-1;
        int carry = 0;

        while (i >= 0 && j >= 0) {
            char ch1 = a.charAt(i);
            char ch2 = b.charAt(j);
            if ((ch1 == '0' && ch2 == '1') || (ch1 == '1' && ch2 == '0')) {
                if (carry == 1)
                    ans.append(0);
                else
                    ans.append(1);
            }
            else if ((ch1 == '0' && ch2 == '0')) {
                if (carry == 1) {
                    ans.append(1);
                    carry = 0;
                }
                else
                    ans.append(0);
            }
            else {
                if (carry == 1)
                    ans.append(1);
                else {
                    ans.append(0);
                    carry = 1;
                }
            }

            i--;
            j--;
        }

        while (j >= 0) {
            char ch = b.charAt(j);
            if (ch == '0') {
                if (carry == 1) {
                    ans.append(1);
                    carry = 0;
                }
                else
                    ans.append(0);
            }
            else {
                if (carry == 1)
                    ans.append(0);
                else
                    ans.append(1);
            }
            j--;
        }

        while (i >= 0) {
            char ch = a.charAt(i);
            if (ch == '0') {
                if (carry == 1) {
                    ans.append(1);
                    carry = 0;
                }
                else
                    ans.append(0);
            }
            else {
                if (carry == 1)
                    ans.append(0);
                else
                    ans.append(1);
            }
            i--;
        }

        if (carry == 1)
            ans.append(1);

        return ans.reverse().toString();   
    }
}