class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int cnt = 0;
        for (int i = low; i <= high; i++) {
            if (symmFun(String.valueOf(i)))
                cnt++;
        }
        return cnt;
    }
    public boolean symmFun(String s) {
        int n = s.length();
        if (n % 2 != 0)
            return false;

        int l = 0, r = n-1;
        int suml = 0, sumr = 0;
        while (l < r) {
            suml += s.charAt(l)-'0';
            sumr += s.charAt(r)-'0';
            l++;
            r--;
        }

        return suml == sumr;
    }
}