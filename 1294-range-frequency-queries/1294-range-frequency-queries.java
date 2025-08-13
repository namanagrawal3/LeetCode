class RangeFreqQuery {
    private HashMap<Integer, List<Integer>> map;

    public RangeFreqQuery(int[] arr) {
        map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(arr[i]))
                map.put(arr[i], new ArrayList<>());
            map.get(arr[i]).add(i);
        }
    }
    
    public int query(int left, int right, int value) {
        if (!map.containsKey(value))
            return 0;

        List<Integer> ll = map.get(value);
        int l = lowerBound(left, ll);
        int r = upperBound(right, ll);

        if (l == ll.size() || r == -1)
            return 0;
        return r-l+1;
    }

    private int lowerBound(int target, List<Integer> ll) {
        int si = 0;
        int ei = ll.size()-1;
        while (si <= ei) {
            int mid = si + (ei-si)/2;
            if (ll.get(mid) >= target)
                ei = mid - 1;
            else
                si = mid + 1;
        }
        return si;
    }

    private int upperBound(int target, List<Integer> ll) {
        int si = 0;
        int ei = ll.size()-1;
        while (si <= ei) {
            int mid = si + (ei-si)/2;
            if (ll.get(mid) <= target)
                si = mid + 1;
            else
                ei = mid - 1;
        }
        return ei;
    }
}

/**
 * Your RangeFreqQuery object will be instantiated and called as such:
 * RangeFreqQuery obj = new RangeFreqQuery(arr);
 * int param_1 = obj.query(left,right,value);
 */