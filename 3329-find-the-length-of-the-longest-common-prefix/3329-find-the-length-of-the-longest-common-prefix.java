class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : arr1) {
            while (num > 0 && !set.contains(num)) {
                set.add(num);
                num /= 10;
            }
        }

        int maxLen = 0;
        for (int num : arr2) {
            while (num > 0 && !set.contains(num)) {
                num /= 10;
            }
            if (num > 0)
                maxLen = Math.max(maxLen, (int)Math.log10(num)+1);
        }

        return maxLen;
    }
}