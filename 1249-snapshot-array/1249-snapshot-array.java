class SnapshotArray {
    private TreeMap<Integer, Integer>[] Tm;
    private int snapId = 0;

    public SnapshotArray(int length) {
        Tm = new TreeMap[length];

        for (int i = 0; i < length; i++) {
            Tm[i] = new TreeMap<>();
            Tm[i].put(0, 0);
        }
    }
    
    public void set(int index, int val) {
        Tm[index].put(snapId, val);
    }
    
    public int snap() {
        return snapId++;
    }
    
    public int get(int index, int snap_id) {
        return Tm[index].floorEntry(snap_id).getValue();
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */