class Solution {
    public int minimumIndex(List<Integer> nums) {
    // First find the majority element (using Moore's Voting Algorithm)
    // then, using the prefix & suffix count find the split idx

        int n = nums.size();
        int maj = -1;
        int cnt = 0;
        for (int num : nums) {
            if (cnt == 0) {
                maj = num;
                cnt = 1;
            }
            else if (num == maj)
                cnt++;
            else
                cnt--;
        }

        int leftCnt = 0;
        int rightCnt = 0;
        for (int num : nums) {
            if (num == maj)
                rightCnt++;
        }

        for (int i = 0; i < n-1; i++) {
            if (nums.get(i) == maj) {
                leftCnt++;
                rightCnt--;
            }
            
            if (leftCnt > (i+1)/2 && rightCnt > (n-1-i)/2)
                return i;
        }

        return -1;   
    }
}