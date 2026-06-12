class Solution {
    class Pair {
        String video;
        int freq;
        public Pair(String s, int f) {
            video = s;
            freq = f;
        }
    }

    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
    // Simply, iterate over the given 'level' (using BFS) and 'friends' is adjacency list then simple do the sorting after storing the videos

        int n = friends.length;
        boolean[] visited = new boolean[n];
        HashMap<String, Integer> map = new HashMap<>();
        Queue<Integer> q = new ArrayDeque<>();

        int currLevel = 0;
        q.add(id);
        visited[id] = true;

        while (!q.isEmpty()) {
            int size = q.size();
            if (currLevel == level) {
                while (size-- > 0) {
                    int u = q.poll();
                    for (String s: watchedVideos.get(u)) {
                        map.put(s, map.getOrDefault(s, 0) + 1);
                    }
                }
            }
            else {
                while (size-- > 0) {
                    int u = q.poll();
                    for (int v: friends[u]) {
                        if (!visited[v]) {
                            q.add(v);
                            visited[v] = true;
                        }
                    }
                }
                currLevel++;
            }
        }
        
        Pair[] arr = new Pair[map.size()];
        int idx = 0;
        for (String video: map.keySet()) {
            arr[idx++] = new Pair(video, map.get(video));
        }

        Arrays.sort(arr, (a, b) -> (a.freq == b.freq) ? a.video.compareTo(b.video) : a.freq - b.freq);

        List<String> ll = new ArrayList<>();
        for (Pair pp: arr) {
            ll.add(pp.video);
        }

        return ll;
    }
}