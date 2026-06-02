class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
    // Try all possible combination pairs (brute force)

        int n = landStartTime.length;
        int m = waterStartTime.length;
        int minTime = 100000;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // first land then water ride
                int landWater = landStartTime[i] + landDuration[i];
                landWater = (landWater < waterStartTime[j]) ? waterStartTime[j] + waterDuration[j] : landWater + waterDuration[j];

                // first water then land ride
                int waterLand = waterStartTime[j] + waterDuration[j];
                waterLand = (waterLand < landStartTime[i]) ? landStartTime[i] + landDuration[i] : waterLand + landDuration[i];

                minTime = Math.min(minTime, Math.min(landWater, waterLand));
            }
        }

        return minTime;
    }
}