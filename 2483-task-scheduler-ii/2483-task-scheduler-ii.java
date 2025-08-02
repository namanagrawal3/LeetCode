class Solution {
    public long taskSchedulerII(int[] tasks, int space) {
        HashMap<Integer, Long> map = new HashMap<>();
        long currDay = 0;

        for (int task: tasks) {
            currDay++;
            if (map.containsKey(task)) {
                long prev = map.get(task);

                if (currDay-prev-1 < space)
                    currDay = map.get(task) + space + 1;
            }
            map.put(task, currDay);
        }

        return currDay;
    }
}