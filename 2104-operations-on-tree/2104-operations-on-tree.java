class LockingTree {
    int[] p;
    HashMap<Integer, Integer> map = new HashMap<>();  // stores the locking info of nodes 
    HashMap<Integer, List<Integer>> children = new HashMap<>();// stores all the children

    public LockingTree(int[] parent) {
        p = parent;
        int n = parent.length;

        for (int i = -1; i < n; i++) {
            children.put(i, new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            children.get(p[i]).add(i);
        }
    }
    
    public boolean lock(int num, int user) {
        if (!map.containsKey(num)) {
            map.put(num, user);
            return true;
        }
        return false;
    }
    
    public boolean unlock(int num, int user) {
        if (map.containsKey(num) && map.get(num) == user) {
            map.remove(num);
            return true;
        }
        return false;
    }
    
    public boolean upgrade(int num, int user) {
        // 1. checking the node
        if (map.containsKey(num))
            return false;

        // 2. checking the ancestors
        int node = num;
        num = p[num];
        while (num != -1) {
            if (map.containsKey(num))
                return false;
            num = p[num];
        }

        // 3. checking the descendants (using the BFS)
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[p.length];
        q.add(node);
        boolean locked = false;

        while (!q.isEmpty()) {
            int rv = q.poll();
            if (map.containsKey(rv)) {
                locked = true;
                map.remove(rv);
            }

            if (visited[rv])
                continue;

            visited[rv] = true;

            for (int child: children.get(rv)) {
                if (!visited[child])
                    q.add(child);
            }
        }

        if (!locked)
            return false;

        map.put(node, user);
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