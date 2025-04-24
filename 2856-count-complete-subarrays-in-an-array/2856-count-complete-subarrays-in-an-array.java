class Solution {
    public int countCompleteSubarrays(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int ele : nums) {
            set.add(ele);
        }

        int k = set.size();
        return countSub(nums, k) - countSub(nums, k-1);
    }
    public int countSub(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int count = 0;
        int si = 0, ei = 0;
        while (ei < nums.length) {
            map.put(nums[ei], map.getOrDefault(nums[ei], 0) + 1);

            while (map.size() > k && si <= ei) {
                map.put(nums[si], map.get(nums[si]) - 1);
                if (map.get(nums[si]) == 0)
                    map.remove(nums[si]);
                si++;
            }
            
            count += ei-si+1;
            ei++;
        }
        return count;
    }
}