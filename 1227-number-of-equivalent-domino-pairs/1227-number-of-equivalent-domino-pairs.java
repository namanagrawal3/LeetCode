class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        HashMap<String, Integer> map = new HashMap<>();
        int cnt = 0;
        
        for (int[] d: dominoes) {
            String orgS = d[0]+" "+d[1];
            String revS = d[1]+" "+d[0];

            if (map.containsKey(orgS)) {
                cnt += map.get(orgS);
                map.put(orgS, map.get(orgS) + 1);
            }
            else if (map.containsKey(revS)) {
                cnt += map.get(revS);
                map.put(revS, map.get(revS) + 1);
            }
            else
                map.put(orgS, 1);
        }

        return cnt;
    }
}