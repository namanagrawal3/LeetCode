class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
    // Approach-1 : Using 4-nested for() loops ,i.e, O(n^4)

    // Approach-2 : Using 3-nested for() loops and a HashMap for nums4 ,i.e, O(n^3)
    //                nums4[l] = -(nums1[i] + nums2[j] + nums3[k])

    // Approach-3 : Using 2-nested for() loops and a HashMap for all pairs of nums3 & nums4 ,i.e, O(n^2)
    //                nums3[k] + nums4[l] = -(nums1[i] + nums2[j]) 

        int n = nums1.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int k = 0; k < n; k++) {
            for (int l = 0; l < n; l++) {
                int sum = nums3[k] + nums4[l];
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        } 

        int tuples = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int target = -(nums1[i] + nums2[j]);
                if (map.containsKey(target))
                    tuples += map.get(target);
            }
        }

        return tuples;    
    }
}