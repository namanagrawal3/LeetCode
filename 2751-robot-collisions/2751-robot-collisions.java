class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
    // Similar to 'Asteroid Collisions' (Application of Stack)
    // We just need to take care of the order & indices of simulation

        int n = positions.length;
        Integer[] actual_idx = new Integer[n];
        for (int i = 0; i < n; i++) {
            actual_idx[i] = i;
        }

        // sort indices on the basis of positions of robots
        Arrays.sort(actual_idx, (a, b) -> positions[a] - positions[b]);
        
        // We will maintain the healths' index in the stack (add for 'R' & remove for 'L')
        Stack<Integer> st = new Stack<>();

        for (int curr_idx: actual_idx) {
            if (directions.charAt(curr_idx) == 'R')
                st.push(curr_idx);
            else {
                while (!st.isEmpty() && healths[curr_idx] > 0) {
                    int top_idx = st.pop();
                    if (healths[top_idx] > healths[curr_idx]) {
                        healths[top_idx] -= 1;
                        healths[curr_idx] = 0;
                        st.push(top_idx);
                    }
                    else if (healths[top_idx] < healths[curr_idx]) {
                        healths[curr_idx] -= 1;
                        healths[top_idx] = 0;
                    }
                    else {
                        healths[curr_idx] = 0;
                        healths[top_idx] = 0;
                    }
                }
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (healths[i] > 0)
                ans.add(healths[i]);
        }

        return ans;
    }
}