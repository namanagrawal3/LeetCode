class Solution {
    public String getHint(String secret, String guess) {
        int n = secret.length();
        HashSet<Integer> set = new HashSet<>();

        int bulls = 0;
        for (int i = 0; i < n; i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bulls++;
                set.add(i);
            }
        }

        int[] fre = new int[10];
        for (int i = 0; i < n; i++) {
            if (set.contains(i))
                continue;
            int digit = secret.charAt(i)-'0';
            fre[digit]++;
        }
        
        int cows = 0;
        for (int i = 0; i < n; i++) {
            if (set.contains(i))
                continue;
            int digit = guess.charAt(i)-'0';
            if (fre[digit] > 0) {
                cows++;
                fre[digit]--;
            }
        }
        
        return bulls + "A" + cows + "B";
    }
}