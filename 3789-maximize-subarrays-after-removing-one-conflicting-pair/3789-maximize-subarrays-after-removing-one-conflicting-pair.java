class Solution {
    public long maxSubarrays(int n, int[][] conflictingPairs) {
        // stores the conflicting points for each point
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            map.put(i, new ArrayList<>());
        }

        for (int[] pair: conflictingPairs) {
            int a = Math.min(pair[0], pair[1]);
            int b = Math.max(pair[0], pair[1]);
            map.get(b).add(a);
        }

        int maxConflictPoint = 0;
        int secMaxConflictPoint = 0;
        long valid = 0;

        // stores the count of extra subarrays on removing that conflicting point
        long[] extra = new long[n+1];   
        long max = 0;

        for (int end = 1; end <= n; end++) {
            for (int point: map.get(end)) {
                if (point > maxConflictPoint) {
                    secMaxConflictPoint = maxConflictPoint;
                    maxConflictPoint = point;
                }
                else if (point > secMaxConflictPoint)
                    secMaxConflictPoint = point;
            }

            valid += end - maxConflictPoint;
            extra[maxConflictPoint] += maxConflictPoint - secMaxConflictPoint;
            max = Math.max(max, extra[maxConflictPoint]);
        }

        return valid + max;
    }
}