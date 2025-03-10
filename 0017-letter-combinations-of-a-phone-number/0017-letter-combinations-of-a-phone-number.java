class Solution {   
    String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"}; 
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0)
            return new ArrayList<>();
            
        List<String> l = new ArrayList<>();
        combFun(digits, "", l);
        return l;
    }
    public void combFun(String que, String ans, List<String> l) {
        if (que.length() == 0) {
            l.add(ans);
            return;
        }

        String s = map[que.charAt(0)-'0'];
        String Que = que.substring(1);
        for (int i = 0; i < s.length(); i++) {
            combFun(Que, ans + s.charAt(i), l);
        }
    }
}