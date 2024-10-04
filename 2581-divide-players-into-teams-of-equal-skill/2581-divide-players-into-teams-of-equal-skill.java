class Solution {
    public long dividePlayers(int[] skill) {
        Arrays.sort(skill);
        int i = 0, j = skill.length-1;

        int sum = skill[i] + skill[j];
        long ans = skill[i] * skill[j];
        i++;
        j--;

        while (i < j) {
            if (skill[i] + skill[j] != sum)
                return -1;
            ans += skill[i] * skill[j];
            i++;
            j--;
        }
        
        return ans;
    }
}