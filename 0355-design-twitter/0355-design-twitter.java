class Twitter {
    private int timeStamp;      // maintains the current timestamp for the tweets
    private HashMap<Integer, List<int[]>> tweets;   // stores the tweets for each user
    private HashMap<Integer, HashSet<Integer>> followMap; // stores the follow relationship

    public Twitter() {
        timeStamp = 0;
        tweets = new HashMap<>();
        followMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        if (!tweets.containsKey(userId))
            tweets.put(userId, new ArrayList<>());
        tweets.get(userId).add(new int[]{tweetId, timeStamp++});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        HashSet<Integer> followees = followMap.getOrDefault(userId, new HashSet<>());
        followees.add(userId);

        for (int followee: followees) {
            List<int[]> tweetList = tweets.getOrDefault(followee, new ArrayList<>());
            pq.addAll(tweetList);
        }
        
    // We can optimize its complexity by maintaining the fixed size (of 10) priorityqueue 

        int k = 10;
        List<Integer> ll = new ArrayList<>();
        while (!pq.isEmpty() && k-- > 0) {
            ll.add(pq.poll()[0]);
        }
        return ll;
    }
    
    public void follow(int followerId, int followeeId) {
        if (!followMap.containsKey(followerId))
            followMap.put(followerId, new HashSet<>());
        followMap.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (followMap.containsKey(followerId))
            followMap.get(followerId).remove(followeeId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */