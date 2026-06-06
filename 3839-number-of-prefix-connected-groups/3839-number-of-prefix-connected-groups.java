class Solution {
    public int prefixConnected(String[] words, int k) {
    // Simply, use the HashMap to store the count

        int n = words.length;
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (words[i].length() < k)
                continue;
            String s = words[i].substring(0, k);
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        int cnt = 0;
        for (int v: map.values()) {
            if (v > 1)
                cnt++;
        }

        return cnt;
    }
}