class Solution {
    public long calculateScore(String[] instructions, int[] values) {
    // Simply do the Simulation

        int n = values.length;
        long score = 0;
        int i = 0;
        HashSet<Integer> set = new HashSet<>();

        while (i >= 0 && i < n) {
            if (set.contains(i))
                break;
                
            set.add(i);
            if (instructions[i].equals("add")) {
                score += values[i];
                i++;
            }
            else 
                i = i + values[i];
        }

        return score;
    }
}