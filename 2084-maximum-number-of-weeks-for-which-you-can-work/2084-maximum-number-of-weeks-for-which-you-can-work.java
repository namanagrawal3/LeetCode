class Solution {
    public long numberOfWeeks(int[] milestones) {
        int n = milestones.length;
        if (n == 1)
            return 1;

        long sum = milestones[0];
        int max = milestones[0];
        for (int i = 1; i < n; i++) {
            sum += milestones[i];
            max = Math.max(max, milestones[i]);
        }

        if (sum-max >= max)
            return sum;
        return 2*(sum-max) + 1;
    }
}