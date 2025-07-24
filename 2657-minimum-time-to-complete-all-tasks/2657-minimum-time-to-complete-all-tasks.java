class Solution {
    public int findMinimumTime(int[][] tasks) {
    // We will try to perform the tasks at the overlapping of intervals

        // Sort on the basis of end so that end of task(i) 
        // can help us in overlapping with start of task(i+1)
        Arrays.sort(tasks, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[1] - b[1];
            }
        });

        // check for each interval
        boolean[] timeOn = new boolean[2001];
        for (int[] task: tasks) {
            int start = task[0];
            int end = task[1];
            int duration = task[2];

            for (int i = start; i <= end; i++) {
                if (timeOn[i])
                    duration--;
            }

            for (int i = end; duration > 0; i--) {
                if (timeOn[i])
                    continue;
                timeOn[i] = true;
                duration--;
            }
        }

        int cnt = 0;
        for (int i = 1; i <= 2000; i++) {
            if (timeOn[i])
                cnt++;
        }

        return cnt;
    }
}