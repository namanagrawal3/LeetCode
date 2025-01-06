class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] suf = new int[n];
        int[] pre = new int[n];

        suf[n-1] = 0;
        int c1 = (boxes.charAt(n-1) == '1') ? 1 : 0;
        for (int i = n-2; i >= 0; i--) {
            suf[i] = suf[i+1] + c1;
            if (boxes.charAt(i) == '1')
                c1++;
        }

        pre[0] = 0;
        c1 = (boxes.charAt(0) == '1') ? 1 : 0;
        for (int i = 1; i < n; i++) {
            pre[i] = pre[i-1] + c1;
            if (boxes.charAt(i) == '1')
                c1++;
        }

        for (int i = 0; i < n; i++) {       // we store the "pre[i] + suf[i]" in pre[i]
            pre[i] = pre[i] + suf[i];
        }

        return pre;
    }
}