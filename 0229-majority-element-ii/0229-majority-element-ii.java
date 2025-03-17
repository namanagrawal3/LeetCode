class Solution {
    public List<Integer> majorityElement(int[] nums) {
    // Using Moore's Voting Algorithm Approach
    
    // Step-1 : Finding the 2 candidates
    // Step-2 : Verifying that candidates are majority by counting the frequency 
    
        int n = nums.length;
        Integer candidate1 = -1, candidate2 = -1;
        int cnt1 = 0, cnt2 = 0;
    
        for (int num : nums) {
            if (num == candidate1)
                cnt1++;
            else if (num == candidate2)
                cnt2++;
            else if (cnt1 == 0) {
                candidate1 = num;
                cnt1 = 1;
            }
            else if (cnt2 == 0) {
                candidate2 = num;
                cnt2 = 1;
            }
            else {
                cnt1--;
                cnt2--;
            }
        }

        cnt1 = 0; 
        cnt2 = 0;
        for (int num : nums) {
            if (num == candidate1)
                cnt1++;
            else if (num == candidate2)
                cnt2++;
        }
        
        List<Integer> ans = new ArrayList<>();
        if (cnt1 > n/3)
            ans.add(candidate1);
        if (cnt2 > n/3)
            ans.add(candidate2);

        return ans;     
    }
}