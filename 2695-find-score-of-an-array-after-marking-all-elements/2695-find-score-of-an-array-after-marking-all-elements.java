class Solution {
    class Pair {
        int val;
        int idx;
        public Pair(int v, int i) {
            val = v;
            idx = i;
        }
    }
    public long findScore(int[] nums) {
        int n = nums.length;
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
            @Override                                // to select the smallest element
            public int compare(Pair a, Pair b) {
                if (a.val == b.val)
                    return a.idx - b.idx;
                return a.val - b.val;
            }
        });

        for (int i = 0; i < n; i++) {
            pq.add(new Pair(nums[i], i));
        }

        HashSet<Integer> set = new HashSet<>();      // to mark the elements
        long score = 0;
        while (!pq.isEmpty()) {
            Pair rv = pq.poll();
            if (!set.contains(rv.idx)) {
                score += rv.val;
                set.add(rv.idx);
                set.add(rv.idx - 1);
                set.add(rv.idx + 1);
            }
        }

        return score;
    }
}