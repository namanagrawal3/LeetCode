class AllOne {

    class Pair {
        int fre;
        String key;
        public Pair(int f, String s) {
            this.fre = f;
            this.key = s;
        }
    }

    private Map<String, Integer> map;
    private TreeSet<Pair> set;

    public AllOne() {
        map = new HashMap<>();
        set = new TreeSet<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if (o1.fre == o2.fre)
                    return o1.key.compareTo(o2.key);
                return o1.fre - o2.fre;
            }
        });
    }
    
    public void inc(String key) {
        int n = map.getOrDefault(key, 0);
        if (n > 0)
            set.remove(new Pair(n, key));

        map.put(key, n+1);
        set.add(new Pair(n+1, key));       
    }
    
    public void dec(String key) {
        int n = map.get(key);
        set.remove(new Pair(n, key));

        if (n == 1)
            map.remove(key);
        else {
            map.put(key, n-1);
            set.add(new Pair(n-1, key));   
        }
    }
    
    public String getMaxKey() {
        return set.isEmpty() ? "" : set.last().key;
    }
    
    public String getMinKey() {
        return set.isEmpty() ? "" : set.first().key;
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */