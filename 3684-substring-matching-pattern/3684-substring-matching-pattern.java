class Solution {
    public boolean hasMatch(String s, String p) {
        int idx = p.indexOf('*');
        String first = p.substring(0, idx);
        String last = p.substring(idx + 1);

        int idx1 = s.indexOf(first);
        if (idx1 == -1)
            return false;

        int idx2 = s.indexOf(last, idx1 + first.length());
        if (idx2 == -1)
            return false;

        return true;
    }
}