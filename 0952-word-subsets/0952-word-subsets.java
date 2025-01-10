class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> ans = new ArrayList<>();
        int[] target = new int[26];

        for (String st : words2) {
            int[] temp = new int[26];
            for (int i = 0; i < st.length(); i++) {
                int idx = st.charAt(i) - 'a';
                temp[idx]++;
                target[idx] = Math.max(target[idx], temp[idx]);
            }
        }

        for (int i = 0; i < words1.length; i++) {
            if (check(words1[i], target))
                ans.add(words1[i]);
        }

        return ans;
    }
    public boolean check(String str, int[] target){
        int[] fre = new int[26];
        for(int i = 0; i < str.length(); i++) {
            int idx = str.charAt(i) - 'a';
            fre[idx]++;
        }

        for (int i = 0; i < 26; i++) {
            if (fre[i] < target[i])
                return false;
        }
        
        return true;
    }
}