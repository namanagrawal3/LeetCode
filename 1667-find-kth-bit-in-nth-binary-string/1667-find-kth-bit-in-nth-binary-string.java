class Solution {
    public char findKthBit(int n, int k) {
        String[] arr = new String[n];
        arr[0] = "0";

        for (int i = 1; i < n; i++) {
            arr[i] = arr[i-1] + "1" + revInvert(arr[i-1]);
        }

        return arr[n-1].charAt(k-1);
    }
    public static String revInvert(String s) {
        StringBuilder ans = new StringBuilder();
        int n = s.length();
        
        for (int i = n-1; i >= 0; i--) {
            char ch = s.charAt(i);
            if (ch == '0')
                ans.append('1');
            else 
                ans.append('0');
        }
        
        return ans.toString();
    }
}