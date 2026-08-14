class Solution {
    public boolean splitArraySameAverage(int[] nums) {
    /*
        n1 + n2 = n, s1 + s2 = S (say), if s1/n1 = s2/n2 , then it means "s1/n1 = S/n"
        ie, "average(subset) = average(nums)" 
    */ 

    // Approach 1: Use Recursion to find the average of all subsets, TLE --> O(2^n)
    // Approach 2: Use DP to memoize, TLE & MLE --> [n][n][sum]
    // Approach 3: See the constraints & try to use 'Meet In The Middle' technique (similar to 'Partition Array into Two...')

        int n = nums.length;
        int n1 = n/2;
        int n2 = n - n1;
        
        int sum = 0;
        for (int num: nums) {
            sum += num;
        }

        HashMap<Integer, List<Integer>> sumA = new HashMap<>();
        HashMap<Integer, List<Integer>> sumB = new HashMap<>();

        fillSubsetsSum(sumA, n1, nums, 0);
        fillSubsetsSum(sumB, n2, nums, n1);

        for (List<Integer> sumRList: sumB.values()) {
            Collections.sort(sumRList);
        }

        /*
            if s1/n1 = S/n,  (s1 = lSum + rSum,  n1 = p + q = size)
            then, (lSum + rSum)/size = S/n
            ie, 
                "rSum = (S * size)/n - lSum"
        */

        for (int p = 0; p <= n1; p++) {
            List<Integer> sumLList = sumA.get(p);

            for (int lSum: sumLList) {
                for (int q = 0; q <= n2; q++) {
                    int size = p+q;

                    // subsets should be non-empty 
                    if (size == 0 || size == n)
                        continue;

                    if ((sum * size) % n != 0)
                        continue;

                    int rSum = (sum * size)/n - lSum;
                    if (checkOccur(rSum, sumB.get(q)))
                        return true;
                }
            }
        }

        return false;
    }
    public void fillSubsetsSum(HashMap<Integer, List<Integer>> sumMap, int n, int[] nums, int si) {
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
    public boolean checkOccur(int target, List<Integer> l) {
        int si = 0;
        int ei = l.size()-1;
        
        while (si <= ei) {
            int mid = si + (ei-si)/2;
            if (l.get(mid) == target)
                return true;
            else if (l.get(mid) > target)
                ei = mid - 1;
            else
                si = mid + 1;
        }

        return false;
    }
}