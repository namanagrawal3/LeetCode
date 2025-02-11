class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    // We are given the 'Source' & 'Destination' and 
    // we have to find the shortest path (in terms of edges)        --->    BFS

        HashSet<String> set = new HashSet<>();
        for (String word : wordList) {
            set.add(word);
        }

        Queue<String> q = new ArrayDeque<>();
        HashSet<String> visited = new HashSet<>();
        q.add(beginWord);
        visited.add(beginWord);

        int level = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                String rv = q.poll();
                if (rv.equals(endWord))
                    return level+1;

                for (int i = 0; i < rv.length(); i++) {
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        if (ch == rv.charAt(i))
                            continue;
                        String next = rv.substring(0, i) + ch + rv.substring(i+1);
                        if (set.contains(next) && !visited.contains(next)) {
                            q.add(next);
                            visited.add(next);
                        }
                    }
                }
            }
            level++;
        }
        
        return 0;
    }
}