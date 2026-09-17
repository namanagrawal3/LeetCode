class RideSharingSystem {
// Use the 'Queue' for maintaining the FIFO property for both Riders-Drivers & Keep track of the active riders in the HashSet

    private Queue<Integer> riders = new ArrayDeque<>();
    private Queue<Integer> drivers = new ArrayDeque<>();
    private HashSet<Integer> activeRiders = new HashSet<>();

    public RideSharingSystem() {
        
    }
    
    public void addRider(int riderId) {
        riders.add(riderId);
        activeRiders.add(riderId);
    }
    
    public void addDriver(int driverId) {
        drivers.add(driverId);
    }
    
    public int[] matchDriverWithRider() {
        if (drivers.isEmpty())
            return new int[] {-1, -1};

        int driver = drivers.peek();
        int rider = -1;
        
        while (!riders.isEmpty()) {
            int first = riders.poll();
            if (!activeRiders.contains(first))
                continue;
            
            rider = first;
            break;   
        }

        if (rider == -1)
            return new int[] {-1, -1};

        drivers.poll();
        activeRiders.remove(rider);
        return new int[] {driver, rider};
    }
    
    public void cancelRider(int riderId) {
        activeRiders.remove(riderId);
    }
}

/**
 * Your RideSharingSystem object will be instantiated and called as such:
 * RideSharingSystem obj = new RideSharingSystem();
 * obj.addRider(riderId);
 * obj.addDriver(driverId);
 * int[] param_3 = obj.matchDriverWithRider();
 * obj.cancelRider(riderId);
 */