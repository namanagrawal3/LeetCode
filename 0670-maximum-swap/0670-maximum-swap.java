class Solution {
    public int maximumSwap(int num) {
        TreeMap<Integer, Integer> map = new TreeMap<>(Comparator.reverseOrder());
        char[] arr = String.valueOf(num).toCharArray();
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            int digit = arr[i] - '0';
            map.put(digit, map.getOrDefault(digit, 0) + 1);
        }

        int i = 0;
        for (int key : map.keySet()) {
            int fre = map.get(key);
            for (int j = 0; j < fre; j++) {
                if (arr[i] != (char) (key + '0')) {
                    return helpFun(arr, i, key);
                }
                i++;
            }
        }

        return num;
    }
    public static int helpFun(char[] arr, int idx, int target) {
        int n = arr.length;
        for (int i = n-1; i >= 0; i--) {
            if (arr[i] == (char) (target + '0')) {
                char temp = arr[idx];
                arr[idx] = (char) (target + '0');
                arr[i] = temp;
                break;
            }
        }

        int ans = 0;
        int mul = 1;
        for (int i = n-1; i >= 0; i--) {
            ans += mul * (arr[i]-'0');
            mul *= 10;
        }

        return ans;
    }
}