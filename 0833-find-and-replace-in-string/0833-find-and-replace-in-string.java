class Solution {
    class Pair {
        String src;
        String des;
        public Pair(String s, String d) {
            src = s;
            des = d;
        }
    }

    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
    // Simply store all the valid indices with the strings and then iterate

        int n = s.length();
        int k = indices.length;
        HashMap<Integer, Pair> map = new HashMap<>();

        for (int i = 0; i < k; i++) {
            int idx = indices[i];
            String src = sources[i];
            String des = targets[i];
            int l = src.length();

            if (idx+l <= n && s.substring(idx, idx+l).equals(src))
                map.put(idx, new Pair(src, des));
        }

        StringBuilder ans = new StringBuilder();
        int i = 0;

        while (i < n) {
            if (map.containsKey(i)) {
                Pair pp = map.get(i);
                String src = pp.src;
                i += src.length();
                ans.append(pp.des);
            }
            else {
                ans.append(s.charAt(i));
                i++;
            }
        }

        return ans.toString();
    }
}