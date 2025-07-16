class Solution {
    public int maximumLength(int[] nums) {
        int n = nums.length;
        int ans = 0;

        int even = 0;
        int odd = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] % 2 == 0)
                even++;
            else
                odd++;
        }

        // all even
        ans = Math.max(ans, even);

        // all odd
        ans = Math.max(ans, odd);

        // even-odd alternate
        int cnt = 0;
        int rem = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] % 2 == rem) {
                cnt++;
                rem = 1 - rem;
            }
        }
        ans = Math.max(ans, cnt);

        // odd-even alternate
        cnt = 0;
        rem = 1;
        for (int i = 0; i < n; i++) {
            if (nums[i] % 2 == rem) {
                cnt++;
                rem = 1 - rem;
            }
        }
        ans = Math.max(ans, cnt);

        return ans;
    }
}