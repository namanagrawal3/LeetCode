class Solution {
    public String removeDigit(String number, char digit) {
    // Simply, store all the numbers and sort them

        List<String> nums = new ArrayList<>();
        int n = number.length();

        for (int i = 0; i < n; i++) {
            if (number.charAt(i) == digit) {
                String num = number.substring(0, i) + number.substring(i + 1);
                nums.add(num);
            }
        }        

        Collections.sort(nums);
        return nums.get(nums.size() - 1);
    }
}