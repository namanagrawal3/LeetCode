class Solution {
    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
    // same varient as 'LIS', only need to modify the checking condition
    // Best way to print the 'LIS' is to maintain the parent index

        int n = words.length;
        int[] dp = new int[n];
        int[] parent = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(parent, -1);

        int lis = 1;
        int lisIdx = 0;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (groups[i] != groups[j] && words[j].length() == words[i].length() && hamDist(words[j], words[i]) == 1 && dp[i] < dp[j]+1) {
                    dp[i] = dp[j]+1;
                    parent[i] = j;

                    if (dp[i] > lis) {
                        lisIdx = i;
                        lis = dp[i];
                    }
                }
            }
        }

        // storing all the parents in sequence order
        List<String> l = new ArrayList<>();
        int idx = lisIdx;
        while (idx != -1) {
            l.add(words[idx]);
            idx = parent[idx];
        }
        
        // reversing the list
        int left = 0, right = l.size()-1;
        while (left < right) {
            String temp = l.get(left);
            l.set(left, l.get(right));
            l.set(right, temp);
            left++;
            right--;
        }

        return l;
    }
    public int hamDist(String a, String b) {
        int cnt = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i))
                cnt++;
        }
        return cnt;
    }
}