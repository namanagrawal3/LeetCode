class Solution {
    static class Pair {
        char ch;
        int fre;
        public Pair(char c, int f) {
            ch = c;
            fre = f;
        }
    }
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {  
            @Override                                   // max-Heap
            public int compare(Pair a, Pair b) {
                return b.fre - a.fre;
            }
        });

        if (a > 0)
            pq.add(new Pair('a', a));
        if (b > 0)
            pq.add(new Pair('b', b));
        if (c > 0)
            pq.add(new Pair('c', c));

        StringBuilder ans = new StringBuilder();
        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            char currChar = p.ch;
            int currFre = p.fre;

            if (ans.length() >= 2 && ans.charAt(ans.length()-1) == currChar && ans.charAt(ans.length()-2) == currChar) {
                if (!pq.isEmpty()) {
                    Pair n = pq.poll();
                    char nextChar = n.ch;
                    int nextFre = n.fre;

                    ans.append(nextChar);
                    nextFre--;

                    if (nextFre > 0)
                        pq.add(new Pair(nextChar, nextFre));
                }
                else
                    break;
            }
            else {
                ans.append(currChar);
                currFre--;
            }

            if (currFre > 0)
                pq.add(new Pair(currChar, currFre));
        }
        
        return ans.toString();
    }
}