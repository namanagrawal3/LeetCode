class Solution {
    class Node {
        int bit;
        Node zeroChild;
        Node oneChild;
    }

    private Node root;

    public Solution() {
        root = new Node();
        root.bit = 2;
    }

    public void insert(int num) {
        Node curr = root;
        for (int i = 31; i >= 0; i--) {
            int currBit = (num & (1 << i)) != 0 ? 1 : 0;

            if (currBit == 1) {
                if (curr.oneChild != null)
                    curr = curr.oneChild;
                else {
                    Node nn = new Node();
                    nn.bit = 1;
                    curr.oneChild = nn;
                    curr = nn;
                }
            }
            else {
                if (curr.zeroChild != null)
                    curr = curr.zeroChild;
                else {
                    Node nn = new Node();
                    nn.bit = 0;
                    curr.zeroChild = nn;
                    curr = nn;
                }
            }
        }
    }

    public int getMaxXOR(int num) {
        Node curr = root;
        int ans = 0;
        for (int i = 31; i >= 0; i--) {
            int currBit = (num & (1 << i)) != 0 ? 1 : 0;

            if (currBit == 1) {
                if (curr.zeroChild != null) {
                    ans += (1 << i);
                    curr = curr.zeroChild;
                }
                else
                    curr = curr.oneChild;
            }
            else {
                if (curr.oneChild != null) {
                    ans += (1 << i);
                    curr = curr.oneChild;
                }
                else
                    curr = curr.zeroChild;
            }
        }

        return ans;
    }

    public int findMaximumXOR(int[] nums) {
        Solution tt = new Solution();           // Binary-Trie

        for (int num: nums) {
            tt.insert(num);
        }

        int maxXor = 0;
        for (int num: nums) {
            maxXor = Math.max(maxXor, tt.getMaxXOR(num));
        }

        return maxXor;
    }
}