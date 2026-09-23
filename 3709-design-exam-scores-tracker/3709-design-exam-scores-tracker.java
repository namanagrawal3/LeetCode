class ExamTracker {
    private List<Integer> times = new ArrayList<>();
    private List<Long> prefix = new ArrayList<>();
    private int size = 0;

    public ExamTracker() {
        
    }
    
    public void record(int time, int score) {
        if (size == 0)
            prefix.add(1L*score);
        else
            prefix.add(prefix.get(size-1) + score);
        
        times.add(time);
        size++;
    }
    
    public long totalScore(int startTime, int endTime) {
        int left = lowerBound(times, startTime); 
        int right = upperBound(times, endTime);
        if (left > right)
            return 0;
            
        if (left == 0)
            return prefix.get(right);
        return prefix.get(right) - prefix.get(left-1);
    }

    private int lowerBound(List<Integer> l, int target) {
        int si = 0;
        int ei = size-1;
        while (si <= ei) {
            int mid = si + (ei-si)/2;
            if (l.get(mid) >= target)
                ei = mid - 1;
            else 
                si = mid + 1;
        }
        return si;
    }

    private int upperBound(List<Integer> l, int target) {
        int si = 0;
        int ei = size-1;
        while (si <= ei) {
            int mid = si + (ei-si)/2;
            if (l.get(mid) <= target)
                si = mid + 1;
            else 
                ei = mid - 1;
        }
        return ei;
    }
}

/**
 * Your ExamTracker object will be instantiated and called as such:
 * ExamTracker obj = new ExamTracker();
 * obj.record(time,score);
 * long param_2 = obj.totalScore(startTime,endTime);
 */