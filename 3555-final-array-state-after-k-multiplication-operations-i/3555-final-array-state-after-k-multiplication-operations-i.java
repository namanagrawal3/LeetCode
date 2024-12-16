class Solution {
    class Pair {
        int ele;
        int idx;
        public Pair(int e, int i) {
            ele = e;
            idx = i;
        }
    }
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        int n = nums.length;
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair a, Pair b) {
                if (a.ele == b.ele)
                    return a.idx - b.idx;
                return a.ele - b.ele;
            }
        });

        for (int i = 0; i < n; i++) {
            pq.add(new Pair(nums[i], i));
        }

        while (k-- > 0) {
            Pair rv = pq.poll();
            int e = rv.ele;
            int i = rv.idx;
            nums[i] = e * multiplier;
            pq.add(new Pair(nums[i], i));
        }

        return nums;
    }
}