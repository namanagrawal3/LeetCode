class Solution {
    public int countOfSubstrings(String word, int k) {
        int n = word.length();
        HashSet<Character> vow = new HashSet<>();
        HashMap<Character, Integer> map = new HashMap<>();
        vow.add('a');
        vow.add('e');
        vow.add('i');
        vow.add('o');
        vow.add('u');

        int count = 0;
        int consonant = 0;
        int si = 0, ei = 0;
        while (ei < n) {
            char ch = word.charAt(ei);
            if (vow.contains(ch))
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            else
                consonant++;

            while (map.size() == 5 && consonant > k && si <= ei) {
                char ch2 = word.charAt(si);
                if (vow.contains(ch2)) {
                    map.put(ch2, map.get(ch2) - 1);
                    if (map.get(ch2) == 0)
                        map.remove(ch2);
                }
                else
                    consonant--;
                si++;
            }

            if (map.size() == 5 && consonant == k)
                count += countFun(word, si, ei, k);

            ei++;
        }

        return count;
    }
    public int countFun(String s, int si, int ei, int k) {
        HashSet<Character> set = new HashSet<>();
        int consonant = 0;

        for (int i = ei; i >= si; i--) {
            char ch = s.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
                set.add(ch);
            else
                consonant++;

            if (set.size() == 5 && consonant == k)
                return (ei-si+1) - (ei-i+1) + 1;
        }
        return 0;
    }
}