class Solution {
    public String generateString(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();

        char[] word = new char[n+m-1];
        Arrays.fill(word, '.');
        boolean[] canChange = new boolean[n+m-1];
        Arrays.fill(canChange, true);

        // Filling str2 for each 'T'
        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) == 'T') {
                for (int j = 0; j < m; j++) {
                    if (word[i+j] != '.' && word[i+j] != str2.charAt(j))
                        return "";
                    word[i+j] = str2.charAt(j);
                    canChange[i+j] = false;
                }
            }
        }

        // Filling empty spaces with 'a'
        for (int i = 0; i < n+m-1; i++) {
            if (word[i] == '.')
                word[i] = 'a';
        }

        // Checking str2 for each 'F'
        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) == 'F' && isSame(i, str2, word)) {
                boolean changed = false;
                for (int j = m-1; j >= 0; j--) {        // for lexical small (right to left)
                    if (canChange[i+j]) {
                        word[i+j] = 'b';
                        changed = true;
                        break;
                    }
                }

                if (!changed)
                    return "";
            }
        }

        StringBuilder s = new StringBuilder();
        for (int i = 0; i < n+m-1; i++) {
            s.append(word[i]);
        }

        return s.toString();
    }
    public boolean isSame(int idx, String s, char[] word) {
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (word[i+idx] != s.charAt(i))
                return false;
        }
        return true;
    }
}