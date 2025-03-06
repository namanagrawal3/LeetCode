class Solution {
    public int minLength(String s, int numOps) {
        int n = s.length();                         // s = "1101", numOps = 1
        int si = 1;
        int ei = n;

        while (si <= ei) {
            int mid = si + (ei-si)/2;
            if (isPossible(s, mid, numOps))
                ei = mid - 1;
            else
                si = mid + 1;
        }

        return si;
    }
    public static boolean isPossible(String s, int len, int opr) {
        int n = s.length();
        if (len == 1)
            return alternateFun(s, opr, '1') || alternateFun(s, opr, '0');
        
        int flips = 0;
        char start = s.charAt(0);
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == start)
                cnt++;
            else {
                flips += cnt/(len+1);
                start = s.charAt(i);
                cnt = 1;               
            }
            
            if (flips > opr)
                return false;
        }

        flips += cnt/(len+1);        
        return flips <= opr;
    }
    public static boolean alternateFun(String s, int opr, char start) {
        int n = s.length();
        char other = (start == '0') ? '1' : '0';

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0 && s.charAt(i) != start)
                opr--;
            else if (i % 2 != 0 && s.charAt(i) != other)
                opr--;

            if (opr < 0)
                return false;
        }
        
        return true;
    }
}