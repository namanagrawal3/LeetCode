class TaskManager {
    class Task {
        int userId;
        int taskId;
        int priority;
        public Task(int u, int t, int p) {
            userId = u;
            taskId = t;
            priority = p;
        }
    }
    private HashMap<Integer, Task> map;
    private TreeSet<Task> set;

    public TaskManager(List<List<Integer>> tasks) {
        map = new HashMap<>();
        set = new TreeSet<>(new Comparator<Task>() {
            @Override
            public int compare(Task a, Task b) {
                if (a.priority == b.priority)
                    return b.taskId - a.taskId;
                return b.priority - a.priority;
            }
        });

        for (List<Integer> t : tasks) {
            int user = t.get(0);
            int task = t.get(1);
            int priority = t.get(2);
            
            Task tt = new Task(user, task, priority);
            map.put(task, tt);
            set.add(tt);
        }
    }
    
    public void add(int userId, int taskId, int priority) {
        Task tt = new Task(userId, taskId, priority);
        map.put(taskId, tt);
        set.add(tt);
    }
    
    public void edit(int taskId, int newPriority) {
        Task tt = map.get(taskId);
        set.remove(tt);

        Task ntt = new Task(tt.userId, taskId, newPriority); 
        map.put(taskId, ntt);
        set.add(ntt);
    }
    
    public void rmv(int taskId) {
        Task tt = map.get(taskId);
        map.remove(taskId);
        set.remove(tt);
    }
    
    public int execTop() {
        if (set.size() == 0)
            return -1;
        
        Task top = set.first();
        int userId = top.userId;
        int taskId = top.taskId;

        map.remove(taskId);
        set.remove(top);
        return userId;
    }
}

/**
 * Your TaskManager object will be instantiated and called as such:
 * TaskManager obj = new TaskManager(tasks);
 * obj.add(userId,taskId,priority);
 * obj.edit(taskId,newPriority);
 * obj.rmv(taskId);
 * int param_4 = obj.execTop();
 */