class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;
            
        int[] fre_s1 = new int[26];
        int[] fre_s2 = new int[26];

        int k = s1.length();
        for (int i = 0; i < k; i++) {
            int idx = s1.charAt(i) - 'a';
            fre_s1[idx]++;
        }

        int si = 0, ei = 0;
        for ( ; ei < k; ei++) {
            int idx = s2.charAt(ei) - 'a';
            fre_s2[idx]++;
        }
        if (checkEqual(fre_s1, fre_s2))
            return true;

        while (ei < s2.length()) {
            int idx = s2.charAt(ei) - 'a';
            fre_s2[idx]++;

            fre_s2[s2.charAt(si)-'a']--;
            si++;

            if (checkEqual(fre_s1, fre_s2))
                return true;
            
            ei++;
        }

        return false;
    }
    public static boolean checkEqual(int[] arr,int[] brr){
        for (int i = 0; i < 26; i++) {
            if (arr[i] != brr[i])
                return false;
        }
        return true;  
    }
}