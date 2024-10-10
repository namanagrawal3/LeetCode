class Solution {
    public char kthCharacter(int k) {
        int size = 1;
        int c = 0;
        while (size < k) {
            size *= 2;
            c++;
        }

        char[] arr = new char[size];
        arr[0] = 'a';

        for (int i = 0; i < c; i++) {
            int limit = 1 << i;
            for (int j = 0; j < limit; j++) {
                arr[j + limit] = (char)('a' + ((arr[j]-'a' + 1) % 26));
            }
        }

        return arr[k-1];
    }
}