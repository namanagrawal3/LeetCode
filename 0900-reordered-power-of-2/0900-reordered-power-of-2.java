class Solution {
    public boolean reorderedPowerOf2(int n) {
        char[] num = sortedDigits(n);

        for (int i = 0; i < 31; i++) {
            char[] temp = sortedDigits(1 << i);
            if (Arrays.equals(num, temp))
                return true;
        }

        return false;
    }
    public static char[] sortedDigits(int n) {
        char[] arr = String.valueOf(n).toCharArray();
        Arrays.sort(arr);
        return arr;
    }
}