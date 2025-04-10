class Solution {
    public long numberOfPowerfulInt(long start, long finish, int limit, String s) {
        String ss = String.valueOf(start-1);
        String fs = String.valueOf(finish);
        
        return countFun(fs, limit, s) - countFun(ss, limit, s);
    }
    public long countFun(String num, int limit, String suf) {
        if (num.length() < suf.length())
            return 0;

        String trailing = num.substring(num.length() - suf.length());
        int prefixLength = num.length() - suf.length();
        long cnt = 0;

        for (int i = 0; i < prefixLength; i++) {
            int digit = num.charAt(i)-'0';  // if digit = 3 then possibilities = (0,1,2) 3*_*_*_
            if (digit <= limit) {
                cnt += digit * Math.pow(limit+1, prefixLength-1-i);
            } else {
                cnt += Math.pow(limit+1, prefixLength-i);
                return cnt;
            }
        }
                                            // "10", "10" --> 1
        if (trailing.compareTo(suf) >= 0)   // "15", "10" --> 1
            cnt++;                          // "215", "10" --> 3

        return cnt;
    }
}