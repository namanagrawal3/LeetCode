class Solution {
    public int minMirrorPairDistance(int[] nums) {
    // Simply use HashMap and proceed like subarray types using the index

        int n = nums.length;
        int minDist = n;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (map.containsKey(nums[i]))
                minDist = Math.min(minDist, i-map.get(nums[i]));
            map.put(reverse(nums[i]), i);
        }

        return (minDist == n) ? -1: minDist;
    }
    public int reverse(int n) {
        int ans = 0;
        while (n > 0) {
            ans = ans*10 + n%10;
            n /= 10;
        }
        return ans;
    } 
}