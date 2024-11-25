class Solution {
    public int slidingPuzzle(int[][] board) {
        // clearly, we have to reach the 'target starte' with the minimum moves --> 'BFS'

        HashMap<Integer, int[]> swap = new HashMap<>();  // stores the indices with which 'i' can be swapped
        swap.put(0, new int[]{1, 3});
        swap.put(1, new int[]{0, 2, 4});
        swap.put(2, new int[]{1, 5});
        swap.put(3, new int[]{0, 4});
        swap.put(4, new int[]{1, 3, 5});
        swap.put(5, new int[]{2, 4});

        Queue<String> q = new ArrayDeque<>();
        HashSet<String> set = new HashSet<>();
        String target = "123450";
        int level = 0;

        StringBuilder org = new StringBuilder();
        for (int[] r : board) {
            for (int e : r) {
                org.append(e);
            }
        }

        if (org.toString().equals(target))
            return 0;

        q.add(org.toString());
        set.add(org.toString());

        while (!q.isEmpty()) {
            int n = q.size();
            while (n-- > 0) {
                String rv = q.poll();
                if (rv.equals(target))
                    return level;

                int idx = rv.indexOf('0');
                for (int adjIdx : swap.get(idx)) {
                    char[] nn = rv.toCharArray();
                    char t = nn[idx];
                    nn[idx] = nn[adjIdx];
                    nn[adjIdx] = t;

                    String s = new String(nn);
                    if (!set.contains(s)) {
                        q.add(s);
                        set.add(s);
                    }
                }
            }
            level++;
        }

        return -1;
    }
}