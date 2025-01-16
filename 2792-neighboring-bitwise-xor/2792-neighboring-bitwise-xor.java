class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        // if org --> [x, y, z] 
        // then derived --> [x^y, y^z, z^x]

        int xor = 0;
        for (int num : derived) {
            xor ^= num;
        } 

        return xor == 0;
    }
}