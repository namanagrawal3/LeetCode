class Solution {
    public int[] rotateElements(int[] nums, int k) {
    // Simply, apply the 'Reversal Algorithm' (cyclic rotate array)

        int n = nums.length;
        ArrayList<Integer> l = new ArrayList<>();

        for (int num: nums) {
            if (num >= 0)
                l.add(num);
        }

        int m = l.size();
        if (m <= 1)
            return nums;
            
        k = k % m;
        reverseFun(l, 0, k-1);
        reverseFun(l, k, m-1);
        reverseFun(l, 0, m-1);

        int idx = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] >= 0)
                nums[i] = l.get(idx++);
        }

        return nums;
    }
    public void reverseFun(ArrayList<Integer> l, int left, int right) {
        while (left < right) {
            int temp = l.get(left);
            l.set(left, l.get(right));
            l.set(right, temp);
            left++;
            right--;
        }
    }
}