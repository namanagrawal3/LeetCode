class FrequencyTracker {
    private Map<Integer, Integer> currMap = new HashMap<>();
    private Map<Integer, HashSet<Integer>> freqMap = new HashMap<>();

    public FrequencyTracker() {
        
    }
    
    public void add(int number) {
        int oldFreq = currMap.getOrDefault(number, 0);
        int newFreq = oldFreq + 1;

        currMap.put(number, newFreq);

        if (oldFreq > 0)
            freqMap.get(oldFreq).remove(number);

        freqMap.computeIfAbsent(newFreq, k -> new HashSet<>()).add(number);
    }
    
    public void deleteOne(int number) {
        int oldFreq = currMap.getOrDefault(number, 0);
        if (oldFreq == 0)
            return;
        
        int newFreq = oldFreq - 1;
        freqMap.get(oldFreq).remove(number);

        if (newFreq > 0) {
            currMap.put(number, newFreq);
            freqMap.get(newFreq).add(number);
        }    
        else
            currMap.remove(number);
    }
    
    public boolean hasFrequency(int frequency) {
        return freqMap.containsKey(frequency) && freqMap.get(frequency).size() > 0;
    }
}

/**
 * Your FrequencyTracker object will be instantiated and called as such:
 * FrequencyTracker obj = new FrequencyTracker();
 * obj.add(number);
 * obj.deleteOne(number);
 * boolean param_3 = obj.hasFrequency(frequency);
 */