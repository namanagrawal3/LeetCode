class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
    // Simply move in both directions to find the minimum distance
        if (words[startIndex].equals(target))
            return 0;

        int n = words.length;
        int minDist = n;

        for (int i = 1; i < n; i++) {
            if (words[(startIndex + i) % n].equals(target)) {
                minDist = Math.min(minDist, i);
                break;
            }
        }

        for (int i = 1; i < n; i++) {
            if (words[(startIndex - i + n) % n].equals(target)) {
                minDist = Math.min(minDist, i);
                break;
            }
        }
        
        return (minDist == n) ? -1: minDist;
    }
}