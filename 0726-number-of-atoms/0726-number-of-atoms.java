class Solution {
    public String countOfAtoms(String formula) {
        // Parenthesis '(' ')' gave the hint of 'Stack'
        
        int n = formula.length();
        Stack<TreeMap<String, Integer>> st = new Stack<>();
        st.push(new TreeMap<>());

        int i = 0;
        while (i < n) {
            char ch = formula.charAt(i);
            if (ch == '(') {
                st.push(new TreeMap<>());
                i++;
            }
            else if (ch == ')') {
                TreeMap<String, Integer> curr = st.pop();
                i++;

                StringBuilder mul = new StringBuilder();
                while (i < n && isDigit(formula.charAt(i))) {
                    mul.append(formula.charAt(i));
                    i++;
                }

                int mulInt = (mul.length() > 0) ? Integer.parseInt(mul.toString()) : 1;
                TreeMap<String, Integer> top = (st.isEmpty()) ? new TreeMap<>() : st.peek();

                for (String key : curr.keySet()) {
                    top.put(key, top.getOrDefault(key, 0) + curr.get(key)*mulInt);
                }
            }
            else {      // Uppercase Letter
                StringBuilder Ele = new StringBuilder();
                Ele.append(formula.charAt(i));
                i++;

                while (i < n && isLower(formula.charAt(i))) {
                    Ele.append(formula.charAt(i));
                    i++;
                }
                String key = Ele.toString();

                StringBuilder num = new StringBuilder();
                while (i < n && isDigit(formula.charAt(i))) {
                    num.append(formula.charAt(i));
                    i++;
                }
                int numInt = (num.length() > 0) ? Integer.parseInt(num.toString()) : 1;

                st.peek().put(key, st.peek().getOrDefault(key, 0) + numInt);
            }
        }

        TreeMap<String, Integer> map = st.pop();
        StringBuilder ans = new StringBuilder();
        for (String key : map.keySet()) {
            ans.append(key);
            if (map.get(key) > 1)
                ans.append(map.get(key));
        }

        return ans.toString();
    }
    public static boolean isDigit(char ch) {
        if (ch >= 48 && ch <= 57)
            return true;
        return false;
    }
    public static boolean isLower(char ch) {
        if (ch >= 97 && ch <= 122)
            return true;
        return false;
    }
}