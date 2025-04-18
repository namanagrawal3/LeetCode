class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> l = new ArrayList<>();
        String s = String.valueOf(k);

        int i = num.length-1, j = s.length()-1;
        int carry = 0;
        while (i >= 0 && j >= 0) {
            int digit = s.charAt(j)-'0';
            int sum = num[i] + digit + carry;
            l.add(sum % 10);
            carry = sum / 10;
            i--;
            j--;
        }
        
        while (i >= 0) {
            int sum = num[i] + carry;
            l.add(sum % 10);
            carry = sum / 10;
            i--;
        }

        while (j >= 0) {
            int digit = s.charAt(j)-'0';
            int sum = digit + carry;
            l.add(sum % 10);
            carry = sum / 10;
            j--;
        }

        if (carry != 0)
            l.add(carry);

        int left = 0, right = l.size()-1;
        while (left < right) {
            int temp = l.get(left);
            l.set(left, l.get(right));
            l.set(right, temp);
            left++;
            right--;
        }
        
        return l;
    }
}