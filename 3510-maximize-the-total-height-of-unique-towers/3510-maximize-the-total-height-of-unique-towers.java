class Solution {
    public long maximumTotalSum(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);

        long sum = arr[n-1];
        int max = arr[n-1];

        for (int i = n-2; i >= 0; i--) {
            if (arr[i] < max) {
                sum += arr[i];
                max = arr[i];
            }
            else {
                arr[i] = max-1;
                if (arr[i] == 0)
                    return -1;
                sum += arr[i];
                max = arr[i];
            }
        }
        return sum;
    }
}