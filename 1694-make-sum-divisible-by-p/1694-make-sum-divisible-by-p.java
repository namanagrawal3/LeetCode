class Solution {
    public int minSubarray(int[] nums, int p) {
        int n = nums.length;
        int sum = 0;
        
        for (int i = 0; i < n; i++) {
            sum = (sum + nums[i]) % p;
        }
        
        int target = sum % p;        
        if (target == 0)
            return 0;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        int curr = 0;
        int ans = n;
        map.put(curr, -1);
        
        for (int i = 0; i < n; i++) {
            curr = (curr + nums[i]) % p;
            int find = (curr - target + p) % p;
            
            if (map.containsKey(find))
                ans = Math.min(ans, i-map.get(find));
            
            map.put(curr, i);
        }

        return (ans == n) ? -1 : ans;
    }
}