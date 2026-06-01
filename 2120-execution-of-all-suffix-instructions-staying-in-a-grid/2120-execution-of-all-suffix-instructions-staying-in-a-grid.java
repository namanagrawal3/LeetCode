class Solution {
    public int[] executeInstructions(int n, int[] startPos, String s) {
        int m = s.length();
        int[] ans = new int[m];

        for (int i = 0; i < m; i++) {
            ans[i] = simulateFun(n, startPos[0], startPos[1], s.substring(i));
        }

        return ans;
    }
    public int simulateFun(int n, int cr, int cc, String s) {
        int opr = 0;
        int m = s.length();

        for (int i = 0; i < m; i++) {
            char inst = s.charAt(i);
            if (inst == 'L') {
                if (cc - 1 < 0)
                    return opr;
                cc -= 1;
            }
            else if (inst == 'R') {
                if (cc + 1 == n)
                    return opr;
                cc += 1;
            }
            else if (inst == 'U') {
                if (cr - 1 < 0)
                    return opr;
                cr -= 1;
            }
            else {
                if (cr + 1 == n)
                    return opr;
                cr += 1;
            }
            opr++;
        }

        return opr;
    }
}