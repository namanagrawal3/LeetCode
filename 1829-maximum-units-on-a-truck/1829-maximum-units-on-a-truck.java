class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        // type of 'Fractional Knapsack' problem

        int n = boxTypes.length;
        Arrays.sort(boxTypes, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return b[1] - a[1];
            }
        });

        int maxUnits = 0;
        for (int i = 0; i < n; i++) {
            int boxes = boxTypes[i][0];
            int units = boxTypes[i][1];

            if (boxes <= truckSize) {
                maxUnits += units * boxes;
                truckSize -= boxes;
            }
            else if (truckSize != 0) {
                maxUnits += units * truckSize;
                truckSize = 0;
            }
            else
                break;
        }

        return maxUnits;
    }
}