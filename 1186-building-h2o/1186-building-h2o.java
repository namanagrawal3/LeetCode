class H2O {

    Semaphore HSem = new Semaphore(2);
    Semaphore OSem = new Semaphore(1);
    CyclicBarrier barrier = new CyclicBarrier(3);

    public H2O() {
        
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
		try {
            HSem.acquire();
            barrier.await();
            releaseHydrogen.run();
        } 
        catch (Exception e) {

        }
        finally {
            HSem.release();
        }

        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        try {
            OSem.acquire();
            barrier.await();
            releaseOxygen.run();
        } 
        catch (Exception e) {

        }
        finally {
            OSem.release();
        }
        
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
    }
}