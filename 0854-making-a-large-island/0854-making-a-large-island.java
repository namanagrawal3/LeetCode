class Solution {
    int[] parent;
    int[] rank;
    int[] size;                 // for finding the size of component optimally

    public int largestIsland(int[][] grid) {
        int n = grid.length;

        parent = new int[n*n];
        rank = new int[n*n];
        size = new int[n*n];
        for (int i = 0; i < n*n; i++) {
            parent[i] = i;
        }
        Arrays.fill(rank, 0);
        Arrays.fill(size, 1);

        // first, connecting the possible components of '1'
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 1) {
                    int[] r = {0,1,0,-1};
                    int[] c = {1,0,-1,0};

                    for (int i = 0; i < 4; i++) {
                        int nr = row + r[i];
                        int nc = col + c[i];

                        if (nr < 0 || nr >= n || nc < 0 || nc >= n || grid[nr][nc] == 0)
                            continue;
                        int curr_node = row * n + col;
                        int new_node = nr * n + nc;
                        union(curr_node, new_node);
                    }
                }
            }
        }

        // now, check for each '0' island size possible
        int maxSize = 0;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 0) {
                    int[] r = {0,1,0,-1};
                    int[] c = {1,0,-1,0};
                    HashSet<Integer> component = new HashSet<>();

                    for (int i = 0; i < 4; i++) {
                        int nr = row + r[i];
                        int nc = col + c[i];

                        if (nr < 0 || nr >= n || nc < 0 || nc >= n || grid[nr][nc] == 0)
                            continue;
                        int new_node = nr * n + nc;
                        component.add(findParent(new_node));
                    }

                    int currSize = 0;
                    for (int p : component) {
                        currSize += size[p];
                    }

                    maxSize = Math.max(maxSize, currSize+1);
                }
            }
        }

        // if all the values of grid are '1'        
        return (maxSize == 0) ? n*n : maxSize;
    }
    public int findParent(int x) {
        if (x == parent[x])
            return x;

        return parent[x] = findParent(parent[x]);
    }
    public void union(int x, int y) {
        int parent_x = findParent(x);
        int parent_y = findParent(y);

        if (parent_x == parent_y)
            return;

        if (rank[parent_x] > rank[parent_y]) {
            parent[parent_y] = parent_x;
            size[parent_x] += size[parent_y];           // update size
        }    
        else if (rank[parent_x] < rank[parent_y]) {
            parent[parent_x] = parent_y;
            size[parent_y] += size[parent_x];           // update size
        }
        else {
            parent[parent_x] = parent_y;
            rank[parent_y]++;
            size[parent_y] += size[parent_x];           // update size
        }
    }
    public int compSize(int p, int n) {
        int c = 0;
        for (int i = 0; i < n*n; i++) {
            if (findParent(i) == p)
                c++;
        }
        return c;
    }
}