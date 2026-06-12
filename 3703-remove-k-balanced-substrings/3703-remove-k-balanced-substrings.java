class Solution {
    class Pair {
        char ch;
        int freq;
        public Pair(char ch, int freq) {
            this.ch = ch;
            this.freq = freq;
        }
    }

    public String removeSubstring(String s, int k) {
    // Simply, simulate using the 'Stack' & store the chars with their freq
        
        int n = s.length();
        Stack<Pair> st = new Stack<>();
        
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (!st.isEmpty() && st.peek().ch == ch) 
                st.peek().freq++;             // Same character, increment count
            else
                st.push(new Pair(ch, 1));   // Different character, push new entry
            
            // Check if the last two groups form a k-balanced substring
            int l = st.size();
            if (l >= 2 && st.get(l-2).ch == '(' && st.get(l-1).ch == ')' && st.get(l-2).freq >= k && st.get(l-1).freq == k) {
                st.get(l-2).freq -= k;
                st.pop();
                if (st.peek().freq == 0)
                    st.pop();
            }    
        }
        
        StringBuilder ans = new StringBuilder();
        for (Pair pp : st) {
            char ch = pp.ch;
            int freq = pp.freq;
            while (freq-- > 0){
                ans.append(ch);
            }
        }
        
        return ans.toString();
    }
}