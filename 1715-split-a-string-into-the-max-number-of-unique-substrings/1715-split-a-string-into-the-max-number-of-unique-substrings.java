class Solution {
    public int maxUniqueSplit(String s) {
        HashSet<String> set = new HashSet<>();
        return countFun(s, 0, set); 
    }
    public int countFun(String s, int idx, HashSet<String> set) {
        if (idx == s.length())
            return 0;

        int count = Integer.MIN_VALUE;
        for (int j = idx+1; j <= s.length(); j++) {
            String temp = s.substring(idx, j);
            int result = 0;
            if (!set.contains(temp)) {
                set.add(temp);
                result = 1 + countFun(s, j, set);
                count = Math.max(count, result);
                set.remove(temp);
            }
        }

        return count;
    }
}