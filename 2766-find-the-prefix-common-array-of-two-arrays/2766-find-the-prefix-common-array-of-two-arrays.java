class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] fre = new int[n+1];
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            fre[A[i]]++;
            fre[B[i]]++;

            int c = 0;
            if (A[i] == B[i])
                c++;
            else {
                if (fre[A[i]] % 2 == 0)
                    c++;
                if (fre[B[i]] % 2 == 0)
                    c++;
            }

            ans[i] = (i > 0) ? ans[i-1]+c : c;
        }

        return ans;
    }
}