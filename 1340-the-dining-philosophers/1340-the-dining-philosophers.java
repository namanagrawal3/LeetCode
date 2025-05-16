class DiningPhilosophers {
    // Without using the Globol-Control 'table' mutex, output can't be matched using an array of 5 semaphores
    // Practical solution is to use 5 semaphores with last philosopher having differnt picking order than others
    Semaphore lock = new Semaphore(1);

    public DiningPhilosophers() {
        
    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
        lock.acquire();

        pickLeftFork.run();
        pickRightFork.run();

        eat.run();

        putRightFork.run();
        putLeftFork.run();

        lock.release(); 
    }
}