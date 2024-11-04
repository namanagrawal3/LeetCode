class Solution {
    public long countOfSubstrings(String word, int k) {
        return countFun(word, k) - countFun(word, k-1);
    }
    public long countFun(String s, int k) {
        int[] vow = new int[5];             // stores the last index of vowels
        int[] fre = new int[5];             // stores the freq of vowels
        int n = s.length();
        int consonants = 0;
        int uniqueVow = 0;


        long count = 0;
        int si = 0, ei = 0;
        while (ei < n) {
            char ch = s.charAt(ei);
            if (isVowel(ch)) {
                int idx = vowIdx(ch);
                if (fre[idx] == 0)
                    uniqueVow++;
                fre[idx]++;
                vow[idx] = ei;
            }
            else
                consonants++;

            while (consonants > k && si <= ei) {
                char ch2 = s.charAt(si);
                if (isVowel(ch2)) {
                    int idx2 = vowIdx(ch2);
                    fre[idx2]--;
                    if (fre[idx2] == 0)
                        uniqueVow--;
                }
                else
                    consonants--;
                si++;
            }

            if (uniqueVow == 5) {
                int i = Math.min(vow[4], Math.min(Math.min(vow[0], vow[1]), Math.min(vow[2], vow[3])));
                count += (ei-si+1) - (ei-i);
            }

            ei++;
        }
        return count;
    }
    public boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
    public int vowIdx(char ch) {
        if (ch == 'a')
            return 0;
        else if (ch == 'e')
            return 1;
        else if (ch == 'i')
            return 2;
        else if (ch == 'o')
            return 3;
        return 4;
    }
}