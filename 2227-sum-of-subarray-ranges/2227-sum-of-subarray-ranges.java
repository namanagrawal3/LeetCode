class Solution {
    public long subArrayRanges(int[] nums) {
        int n = nums.length;

        long largestSum = sumOfMax(nums, n);
        long smallestSum = sumOfMin(nums, n);

        return largestSum - smallestSum;
    }
    public long sumOfMin(int[] arr, int n) {
        int[] nsl = new int[n];
        int[] nsr = new int[n];

        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[i] <= arr[st.peek()]) {
                st.pop();
            }
            if (st.isEmpty())
                nsl[i] = -1;
            else
                nsl[i] = st.peek();
            st.push(i);
        }

        st.clear();

        for (int i = n-1; i >= 0; i--) {
            while (!st.isEmpty() && arr[i] < arr[st.peek()]) {
                st.pop();
            }
            if (st.isEmpty())
                nsr[i] = n;
            else
                nsr[i] = st.peek();
            st.push(i);
        }

        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans = ans + (1L * arr[i] * (i-nsl[i]) * (nsr[i]-i));
        }
//        System.out.println(Arrays.toString(nsl));
//        System.out.println(Arrays.toString(nsr));
        return ans;
    }
    public long sumOfMax(int[] arr, int n) {
        int[] nll = new int[n];
        int[] nlr = new int[n];

        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[i] >= arr[st.peek()]) {
                st.pop();
            }
            if (st.isEmpty())
                nll[i] = -1;
            else
                nll[i] = st.peek();
            st.push(i);
        }

        st.clear();

        for (int i = n-1; i >= 0; i--) {
            while (!st.isEmpty() && arr[i] > arr[st.peek()]) {
                st.pop();
            }
            if (st.isEmpty())
                nlr[i] = n;
            else
                nlr[i] = st.peek();

            st.push(i);
        }

        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans = ans + (1L * arr[i] * (i-nll[i]) * (nlr[i]-i));
        }
//        System.out.println(Arrays.toString(nll));
//        System.out.println(Arrays.toString(nlr));
        return ans;
    }
}