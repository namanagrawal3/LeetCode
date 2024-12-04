class Solution {
    public int numberOfWeakCharacters(int[][] pro) {
        // same approach as 'Russian Doll Envelopes'

        Arrays.sort(pro, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0])
                    return b[1] - a[1];
                return a[0] - b[0];
            }
        });

        int n = pro.length;
        int maxDef = pro[n-1][1];
        int cnt = 0;

        for (int i = n-2; i >= 0; i--) {
            if (pro[i][1] < maxDef) 
                cnt++;
            else 
                maxDef = pro[i][1];
        }

        return cnt;
    }
}