class Solution {
    public int largestAltitude(int[] gain) {
    // Simply, iterate on the array to find the max altitude

        int max = 0;
        int curr = 0;

        for (int num: gain) {
            curr += num;
            if (curr > max)
                max = curr;
        }

        return max;
    }
}