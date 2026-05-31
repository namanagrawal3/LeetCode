class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
    // Simply use the binary search for the efficient searching
    
        int n1 = nums1.length;
        int n2 = nums2.length;
        int maxDist = 0;

        int min = Math.min(n1, n2);
        for (int i = 0; i < min; i++) {
            if (nums1[i] > nums2[i])
                continue;
            int dist = binFun(nums2, nums1[i], i);
            maxDist = Math.max(dist, maxDist);
        }

        return maxDist;
    }
    public int binFun(int[] nums2, int num, int idx) {
        int si = idx;
        int ei = nums2.length-1;
        while (si <= ei) {
            int mid = si + (ei-si)/2;
            if (nums2[mid] >= num)
                si = mid + 1;
            else
                ei = mid - 1;
        }
        return ei - idx;
    }
}