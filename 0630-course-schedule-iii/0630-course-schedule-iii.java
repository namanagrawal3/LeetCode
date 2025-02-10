class Solution {
    public int scheduleCourse(int[][] courses) {
        int n = courses.length;
        Arrays.sort(courses, new Comparator<int[]>() {      // sort on the basis of LastDay
            @Override
            public int compare(int[] a, int[] b) {
                if (a[1] == b[1])
                    return a[0] - b[0];
                return a[1] - b[1];
            }
        });
        
    // For each iteration we will try to minimize the endtime while maximising the no. of courses 
         
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int curr = 0;
        for (int i = 0; i < n; i++) {
            if (curr + courses[i][0] <= courses[i][1]) {
                curr += courses[i][0];
                pq.add(courses[i][0]);
            }
            else {
                if (!pq.isEmpty() && pq.peek() > courses[i][0]) {
                    int rv = pq.poll();
                    curr -= rv;
                    pq.add(courses[i][0]);
                    curr += courses[i][0];
                }
            }
        }

        return pq.size();
    }
}