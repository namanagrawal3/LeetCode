class Solution {
    public int repeatedStringMatch(String a, String b) {
        StringBuilder temp = new StringBuilder(a);
        int times = 1;
        
        while (temp.length() < b.length()) {
            times++;
            temp.append(a);
        }

        if (temp.indexOf(b) != -1)
            return times;
        
        temp.append(a);
        if (temp.indexOf(b) != -1)
            return times+1;

        return -1;
    }
}