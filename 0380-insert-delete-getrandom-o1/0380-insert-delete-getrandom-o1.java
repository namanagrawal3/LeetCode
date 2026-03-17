class RandomizedSet {
    private HashMap<Integer, Integer> map;
    private List<Integer> l;

    public RandomizedSet() {
        map = new HashMap<>();
        l = new ArrayList<>();
    }
    
    public boolean insert(int val) {
        if (map.containsKey(val))
            return false;
        
        map.put(val, l.size());
        l.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if (!map.containsKey(val))
            return false;

        // swap the last & element to be removed, then remove the last for O(1) deletion
        int rmIdx = map.get(val);
        int last = l.get(l.size()-1);
        l.set(rmIdx, last);
        map.put(last, rmIdx);        
        map.remove(val);
        l.remove(l.size()-1);
        return true;
    }
    
    public int getRandom() {
        int randomIdx = (int)(Math.random() * l.size());
        return l.get(randomIdx);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */