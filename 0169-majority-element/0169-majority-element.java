class Solution {
    public int majorityElement(int[] nums) {
    // Using Moore's Voting Algorithm Approach
    
    // Step-1 : Finding the only candidate
    // Step-2 : Verifying that candidate is majority by counting the frequency 
    // (In this que, not required since candidate always exists) 
    
        int count = 1;
        int candidate = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            if (count == 0)
                candidate = nums[i];

            if (nums[i] == candidate)
                count++;
            else 
                count--;
        }
        
        return candidate;        
    }
}