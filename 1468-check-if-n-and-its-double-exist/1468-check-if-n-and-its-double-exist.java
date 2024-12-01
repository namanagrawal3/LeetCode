class Solution {
    public boolean checkIfExist(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        int c0 = 0;
        for (int num : arr) {
            set.add(num);
            if (num == 0)
                c0++;
        }

        for (int num : arr) {
            if (num%2 == 0 && set.contains(num/2)) {
                if (num == 0 && c0 == 1)
                    continue;
                return true;
            }
        }

        return false;
    }
}