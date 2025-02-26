class Solution {
    public int getXORSum(int[] arr1, int[] arr2) {
        int xor1 = xorFun(arr1);
        int xor2 = xorFun(arr2);

        return xor1 & xor2;
    }
    public int xorFun(int[] arr) {
        int xor = 0;
        for (int num : arr) {
            xor ^= num;
        }
        return xor;
    }
}