class Solution {
    static int MOD = 1000000007;
    public int countAnagrams(String s) {
        String[] words = s.split(" ");
        long ans = 1;

        for (String word : words) {
            ans = (ans * countAnagramsForWord(word)) % MOD;
        }

        return (int) ans;
    }

    public static long countAnagramsForWord(String word) {
        int[] freq = new int[26];  
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            freq[ch - 'a']++;
        }
        
        long nume = factorial(word.length());
        long deno = 1;
        for (int f : freq) {
            if (f > 1) {
                deno = (deno * factorial(f)) % MOD;
            }
        }

        // Multiply the numerator by the modular inverse of the denominator
        return (nume * modInverse(deno, MOD)) % MOD;
    }
    public static long factorial(int n) {
        long pro = 1;
        for (int i = 1; i <= n; i++) {
            pro = (pro * i) % MOD;
        }
        return pro;
    }
    public static long modInverse(long a, int mod) {
        return powMod(a, mod - 2, mod);
    }
    public static long powMod(long base, long exp, int mod) {
        long result = 1;
        while (exp > 0) {
            if (exp % 2 == 1) {
                result = (result * base) % mod;  // Multiply when exp is odd
            }
            base = (base * base) % mod;  // Square the base
            exp /= 2;  // Reduce the exponent by half
        }
        return result;
    }
}