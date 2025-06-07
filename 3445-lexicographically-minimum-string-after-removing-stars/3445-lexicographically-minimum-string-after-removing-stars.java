class Solution {
    class Pair {
        char ch;
        int idx;
        public Pair(char ch, int idx) {
            this.ch = ch;
            this.idx = idx;
        }
    }

    public String clearStars(String s) {
    // For each '*', we need to delete the smallest character to its left (with max index for lexicographically smallest string)
    // For each index we can't keep track of the smallest charchter to its left using 'Prefix Array' because we will be deleting the characters simultaneously
    // Thus, we can keep this track using the 'Min-Heap' which will give the smallest character (with max index) upto that index in constant time 

        int n = s.length();
        char[] arr = s.toCharArray();

        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair a, Pair b) {
                if (a.ch == b.ch)
                    return b.idx - a.idx;
                return a.ch - b.ch;
            }
        });

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != '*') 
                pq.add(new Pair(s.charAt(i), i));
            else 
                arr[pq.poll().idx] = '.';
        }
        
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (arr[i] != '.' && arr[i] != '*')
                ans.append(arr[i]);
        }

        return ans.toString();
    }
}