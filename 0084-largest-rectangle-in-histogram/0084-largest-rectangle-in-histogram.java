class Solution {
    public int largestRectangleArea(int[] arr) {
        int n = arr.length;
        int[] nsr = new int[n];
        int[] nsl = new int[n];

        // -------- finding the 'Next Smaller to Right'
        Stack<Integer> st = new Stack<>();

        for (int i = n-1; i >= 0; i--) {
            if (st.isEmpty())
                nsr[i] = n;
            else {
                while (!st.isEmpty() && arr[i] <= arr[st.peek()]) {
                    st.pop();
                }
                nsr[i] = (st.isEmpty()) ? n : st.peek();
            }

            st.push(i);
        }

        st.clear();

        // -------- finding the 'Next Smaller to Left'

        for (int i = 0; i < n; i++) {
            if (st.isEmpty())
                nsl[i] = -1;
            else {
                while (!st.isEmpty() && arr[i] <= arr[st.peek()]) {
                    st.pop();
                }
                nsl[i] = (st.isEmpty()) ? -1 : st.peek();
            }

            st.push(i);
        }

        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            int area = arr[i] * (nsr[i] - nsl[i] - 1);
            maxArea = Math.max(area, maxArea);
        }

        return maxArea;
    }
}