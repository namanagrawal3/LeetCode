class LockingTree {
    int[] p;
    HashMap<Integer, Integer> locked = new HashMap<>();   // stores the locking info of nodes 
    HashMap<Integer, List<Integer>> map = new HashMap<>();// stores all the children

    public LockingTree(int[] parent) {
        p = parent;
        int n = parent.length;

        for (int i = -1; i < n; i++) {
            map.put(i, new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            map.get(p[i]).add(i);
        }
    }
    
    public boolean lock(int num, int user) {
        if (!locked.containsKey(num)) {
            locked.put(num, user);
            return true;
        }
        return false;
    }
    
    public boolean unlock(int num, int user) {
        if (locked.containsKey(num) && locked.get(num) == user) {
            locked.remove(num);
            return true;
        }
        return false;
    }
    
    public boolean upgrade(int num, int user) {
        // 1. checking the node
        if (locked.containsKey(num))
            return false;

        // 2. checking the ancestors
        int anc = p[num];
        while (anc != -1) {
            if (locked.containsKey(anc))
                return false;
            anc = p[anc];
        }

        // 3. checking the descendants (using the BFS)
        Queue<Integer> q = new ArrayDeque<>();
        q.add(num);
        boolean found = false;

        while (!q.isEmpty()) {
            int rv = q.poll();
            if (locked.containsKey(rv)) {
                found = true;
                locked.remove(rv);
            }

            for (int child: map.get(rv)) {
                q.add(child);
            }
        }

        if (!found)
            return false;

        locked.put(num, user);
        return true;
    }
}


/**
 * Your LockingTree object will be instantiated and called as such:
 * LockingTree obj = new LockingTree(parent);
 * boolean param_1 = obj.lock(num,user);
 * boolean param_2 = obj.unlock(num,user);
 * boolean param_3 = obj.upgrade(num,user);
 */