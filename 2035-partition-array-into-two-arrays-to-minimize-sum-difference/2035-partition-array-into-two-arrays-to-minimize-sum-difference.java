class Solution {
    public int minimumDifference(int[] nums) {
    // Since, s1 + s2 = S and we have to minimize "abs(s1 - s2)",ie, "abs(2s1 - S) so we have to find the sum of subset (size 'n'),ie, s1 which should be near to 'S/2' for the min diff , ie, "s1 = S/2"

    // Approach 1: Use Recursion to find all 's1' sum subsets, TLE --> O(2^2n)
    // Approach 2: Apply the DP to memoize, TLE & MLE --> [2n][n][sum]
    // Approach 3: See the constraints & try 'Meet In The Middle' technique but since the subset size is 'n' so need to track the subset sums with their size for both halves subset sums

        int n = nums.length/2;              
        // n1 = n2 = n
        int sum = 0;
        for (int num: nums) {
            sum += num;
        }

        HashMap<Integer, List<Integer>> sumA = new HashMap<>();     // stores the subset sums according to the subset sizes for both halves
        HashMap<Integer, List<Integer>> sumB = new HashMap<>();

        fillSubsetsSum(sumA, nums, n, 0);
        fillSubsetsSum(sumB, nums, n, n);

        // sort the subset sums for second half
        for (int size: sumB.keySet()) {
            List<Integer> sumLList = sumB.get(size);
            Collections.sort(sumLList);
        }

        /*
            s1 = S/2,   lSum + rSum = s1
            lSum + rSum = S/2
            rSum = (S - 2*lSum)/2, ie, 'rSum' must be this near about
        */
        int minDiff = Integer.MAX_VALUE;
        for (int size: sumA.keySet()) {
            List<Integer> sumLList = sumA.get(size);
            List<Integer> sumRList = sumB.get(n - size);

            for (int lSum: sumLList) {
                int rSum = findCloseNeigh(sumRList, sum, lSum);
                int diff = Math.abs(2*(lSum+rSum) - sum);
                minDiff = Math.min(minDiff, diff);
            }
        }

        return minDiff;
    }
    public void fillSubsetsSum(HashMap<Integer, List<Integer>> sumMap, int[] nums, int n, int si) {
        for (int mask = 0; mask < (1<<n); mask++) {
            int sum = 0;
            int cnt = 0;

            for (int i = 0; i < n; i++) {
                if ((mask & (1<<i)) != 0) {
                    sum += nums[i+si];
                    cnt++;
                }
            }

            if (!sumMap.containsKey(cnt))
                sumMap.put(cnt, new ArrayList<>());
            sumMap.get(cnt).add(sum);
        }
    }
    public int findCloseNeigh(List<Integer> ll, int S, int lSum) {
    // Find the nearest neighbour using the 'lower-bound' & its 'prev'
        int target = (S - 2*lSum)/2;
        int si = 0;
        int ei = ll.size() - 1;

        while (si <= ei) {
            int mid = si + (ei-si)/2;
            if (ll.get(mid) >= target) 
                ei = mid - 1;
            else
                si = mid + 1;
        }

        if (si == 0)
            return ll.get(si);
        else if (si == ll.size())
            return ll.get(si-1);
        
        if (ll.get(si) == target)
            return target;
        
        int next = ll.get(si) - target;
        int prev = target - ll.get(si-1);
        return next >= prev ? ll.get(si-1): ll.get(si);
    }
}