class Solution {
    public boolean isPossible(int[] target) {
    // Move in a reverse way ie, make 'arr' from 'target' array  
        int n = target.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int sum = 0;

        for (int a: target) {
            sum += a;
            pq.add(a);
        }

        while (pq.peek() != 1) {
            int maxEle = pq.poll();
            int remSum = sum - maxEle;

            if (remSum <= 0 || remSum >= maxEle)   // remSum + Element = maxEle
                return false;

            int element = maxEle % remSum;    // use '%' for repetitive subtraction
            if (element == 0) {
                if (remSum != 1)
                    return false;
                return true;
            }

            pq.add(element);
            sum = remSum + element;
        }

        return true;
    }
}