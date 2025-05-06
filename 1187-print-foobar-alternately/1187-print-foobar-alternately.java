class FooBar {
    private int n;
    Semaphore f = new Semaphore(1);
    Semaphore b = new Semaphore(0);

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            
        	// printFoo.run() outputs "foo". Do not change or remove this line.
            f.acquire();
        	printFoo.run();
            b.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            
            // printBar.run() outputs "bar". Do not change or remove this line.
            b.acquire();
        	printBar.run();
            f.release();
        }
    }
}