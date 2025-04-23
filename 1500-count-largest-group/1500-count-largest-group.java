class Solution {
    public int countLargestGroup(int n) {
        HashMap<Integer, Integer> fre = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            int sum = sumFun(i);
            fre.put(sum, fre.getOrDefault(sum, 0) + 1);
        }

        int maxSize = 0;
        for (int sum: fre.keySet()) {
            int size = fre.get(sum);
            maxSize = Math.max(maxSize, size);
        }

        int cnt = 0;
        for (int sum: fre.keySet()) {
            if (maxSize == fre.get(sum))
                cnt++;
        }

        return cnt;
    }
    public int sumFun(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n = n / 10;
        }
        return sum;
    }
}