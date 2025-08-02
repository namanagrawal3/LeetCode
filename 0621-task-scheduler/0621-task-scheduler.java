class Solution {
    class Pair {
        char ch;
        int fre;
        public Pair(char c, int f) {
            ch = c;
            fre = f;
        }
    }
    public int leastInterval(char[] tasks, int n) {
    // Similar to 'Hands of Straight' (Proceed with max fre task)

        HashMap<Character, Integer> map = new HashMap<>();
        for (char t: tasks) {
            map.put(t, map.getOrDefault(t, 0) + 1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.fre - a.fre);
        for (char key: map.keySet()) {
            pq.add(new Pair(key, map.get(key)));
        }

        int time = 0;
        while (!pq.isEmpty()) {
            int del = Math.min(pq.size(), n+1);
            List<Pair> temp = new ArrayList<>();

            for (int i = 0; i < del; i++) {
                Pair rv = pq.poll();
                rv.fre--;
                if (rv.fre > 0)
                    temp.add(rv);
            }

            time += (temp.size() > 0) ? n+1 : del;
            pq.addAll(temp);
        }

        return time;
    }
}