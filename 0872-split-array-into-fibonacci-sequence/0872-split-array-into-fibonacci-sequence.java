class Solution {
    int max = Integer.MAX_VALUE;
    int len = (int)Math.log10(max)+1;

    public List<Integer> splitIntoFibonacci(String num) {
        int n = num.length();
        List<Integer> l = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String a = num.substring(0, i+1);
            if (a.charAt(0) == '0' && a.length() > 1)
                break;
            if (a.length() > len || Long.parseLong(a) > max)
                continue;

            l.add(Integer.parseInt(a));
            boolean ans = fiboFun(num, i+1, Integer.parseInt(a), -1, l);
            if (ans)
                break;   
            l.remove(l.size()-1);         
        }

        return l;
    }
    public boolean fiboFun(String num, int idx, int a, int b, List<Integer> l) {
        if (idx == num.length()) 
            return l.size() >= 3;

        if (b == -1) {
            for (int i = idx; i < num.length(); i++) {
                String nxt = num.substring(idx, i+1);
                if (nxt.charAt(0) == '0' && nxt.length() > 1)
                    break;
                if (nxt.length() > len || Long.parseLong(nxt) > max)
                    continue;

                l.add(Integer.parseInt(nxt));
                boolean ans = fiboFun(num, i+1, a, Integer.parseInt(nxt), l);
                if (ans)
                    return true;
                l.remove(l.size()-1);
            }
        }
        else {
            for (int i = idx; i < num.length(); i++) {
                String nxt = num.substring(idx, i+1);
                if (nxt.charAt(0) == '0' && nxt.length() > 1)
                    break;
                if (nxt.length() > len || Long.parseLong(nxt) > max)
                    continue;
                if (a+b != Integer.parseInt(nxt))
                    continue;
                

                l.add(Integer.parseInt(nxt));
                boolean ans = fiboFun(num, i+1, b, Integer.parseInt(nxt), l);
                if (ans)
                    return true;
                l.remove(l.size()-1);
            }
        }

        return false;    
    }
}