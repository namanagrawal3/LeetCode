class AuctionSystem {
// Simply maintain the current state of the System using the 'HashMaps'
//  While finding the highest bid, simply check that it must match the current state

    private Map<Integer, Map<Integer, Integer>> currMap = new HashMap<>();
    private Map<Integer, PriorityQueue<int[]>> orderedMap = new HashMap<>(); 

    public AuctionSystem() {
        
    }
    
    public void addBid(int userId, int itemId, int bidAmount) {
        if (!currMap.containsKey(itemId)) {
            currMap.put(itemId, new HashMap<>());
            orderedMap.put(itemId, new PriorityQueue<>(
                (a, b) -> (a[1] == b[1]) ? b[0]-a[0]: b[1]-a[1]
            ));
        }

        currMap.get(itemId).put(userId, bidAmount);
        orderedMap.get(itemId).add(new int[] {userId, bidAmount});
    }
    
    public void updateBid(int userId, int itemId, int newAmount) {
        currMap.get(itemId).put(userId, newAmount);
        orderedMap.get(itemId).add(new int[] {userId, newAmount});
    }
    
    public void removeBid(int userId, int itemId) {
        currMap.get(itemId).remove(userId);
    }
    
    public int getHighestBidder(int itemId) {
        PriorityQueue<int[]> pq = orderedMap.get(itemId);
        if (pq == null)
            return -1;

        while (!pq.isEmpty()) {
            int[] top = pq.peek();
            if (!isCurrStatus(top[0], top[1], itemId)) {
                pq.poll();
                continue;
            }
            return top[0];    
        }

        return -1;
    }

    private boolean isCurrStatus(int userId, int amount, int itemId) {
        Map<Integer, Integer> usersMap = currMap.get(itemId);
        if (!usersMap.containsKey(userId) || usersMap.get(userId) != amount)
            return false;
        return true;
    }
}

/**
 * Your AuctionSystem object will be instantiated and called as such:
 * AuctionSystem obj = new AuctionSystem();
 * obj.addBid(userId,itemId,bidAmount);
 * obj.updateBid(userId,itemId,newAmount);
 * obj.removeBid(userId,itemId);
 * int param_4 = obj.getHighestBidder(itemId);
 */