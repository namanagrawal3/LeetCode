class Solution {
    public boolean lemonadeChange(int[] bills) {
        int n = bills.length;
        int c5 = 0, c10 = 0;

        for (int i = 0; i < n; i++) {
            if (bills[i] == 5)
                c5++;
            else if (bills[i] == 10) {
                c10++;
                if (c5 < 1)
                    return false;
                c5--;
            }
            else {
                boolean opt1 = (c5 >= 3) ? true : false;
                boolean opt2 = (c5 >= 1 && c10 >= 1) ? true : false;
                
                if (opt2) {
                    c5--;
                    c10--;
                }
                else if (opt1)
                    c5 -= 3;
                else
                    return false;  
            }
        }

        return true;
    }
}