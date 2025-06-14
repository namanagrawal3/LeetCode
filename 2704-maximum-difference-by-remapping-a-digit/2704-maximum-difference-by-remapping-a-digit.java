class Solution {
    public int minMaxDifference(int num) {
    // Max-value will be get by mapping the first non-'9' digit with '9'
    // Min-value will be get by mapping the first non-'0' digit with '0'
        
        String s = String.valueOf(num);
        int n = s.length();
        int maxIdx = -1;
        int minIdx = -1;
        
        for (int i = 0; i < n; i++) {
            if (maxIdx == -1 && s.charAt(i) != '9')
                maxIdx = i;
            if (minIdx == -1 && s.charAt(i) != '0')
                minIdx = i;
        }

        int maxNum = mapFun(s, maxIdx, '9');
        int minNum = mapFun(s, minIdx, '0');

        return maxNum - minNum;
    }
    public int mapFun(String s, int idx, char ch) {
        if (idx == -1)
            return Integer.parseInt(s);

        StringBuilder ans = new StringBuilder();
        char target = s.charAt(idx);

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == target)
                ans.append(ch);
            else
                ans.append(s.charAt(i));
        }

        return Integer.parseInt(ans.toString());
    }
}