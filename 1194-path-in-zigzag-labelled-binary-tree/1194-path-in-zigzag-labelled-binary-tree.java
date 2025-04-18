class Solution {
    public List<Integer> pathInZigZagTree(int n) {
        // finding the 'h' of the label of n
        int h = 0;
        while ((1<<(h+1))-1 < n) {          // end = 2^(h+1) - 1
            h++;
        }

        List<Integer> path = new ArrayList<>();
        path.add(n);

        while (n > 1) {
            int st = 1 << h;
            int end = (1 << (h+1)) - 1;

            int comp = end - n + st;
            int parent = comp/2;

            path.add(parent);
            n = parent;
            h--;
        }

        // reversing the path list
        int l = 0, r = path.size()-1;
        while (l < r) {
            int temp = path.get(l);
            path.set(l, path.get(r));
            path.set(r, temp);
            l++;
            r--;
        }

        return path;
    }
}