class Solution {
    public boolean canThreePartsEqualSum(int[] arr) {
        int n = arr.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        
        if (sum % 3 != 0)
            return false;
        
        int target = sum/3;
        int cnt = 0;
        int curr = 0;
        for (int i = 0; i < n; i++) {
            if (curr + arr[i] == target) {
                cnt++;
                curr = 0;
            }
            else
                curr += arr[i];
        }

        return cnt >= 3;  
    }
}