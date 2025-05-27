class Solution {
    public int differenceOfSums(int n, int m) {
        int c = n/m;
        int num2 = ((c * (c+1))/2) * m;

        int sum = (n * (n+1))/2;
        int num1 = sum - num2;

        return num1 - num2; 
    }
}