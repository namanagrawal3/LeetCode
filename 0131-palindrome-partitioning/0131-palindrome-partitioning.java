class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        partitionFun(s, new ArrayList<>(), ans);
        return ans;
    }
    public void partitionFun(String que, List<String> l, List<List<String>> ans) {
        if (que.length() == 0) {
            ans.add(new ArrayList<>(l));
            return;
        }

        for (int i = 0; i < que.length(); i++) {
            String partition = que.substring(0, i+1);
            if (isPalindrome(partition)) {
                l.add(partition);
                partitionFun(que.substring(i+1), l, ans);
                l.remove(l.size()-1);
            }
        }
    }
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length()-1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right))
                return false;

            left++;
            right--;
        }
        return true;
    }
}