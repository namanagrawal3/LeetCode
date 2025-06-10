class Solution {
    public int maxDifference(String s) {
        int[] fre = new int[26];
        for (char ch: s.toCharArray()) {
            fre[ch - 'a']++;
        }

        int maxi = 0, mini = s.length();
        for (int i = 0; i < 26; i++) {
            if (fre[i] % 2 != 0) 
                maxi = Math.max(maxi, fre[i]);
            if (fre[i] % 2 == 0 && fre[i] > 0) 
                mini = Math.min(mini, fre[i]);
        }
        
        return maxi - mini;
    }
}