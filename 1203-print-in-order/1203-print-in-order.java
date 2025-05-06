class Foo {
// Semaphores can also be used to execute threads/process in a desired manner
    Semaphore s2 = new Semaphore(0);
    Semaphore s3 = new Semaphore(0);

    public Foo() {
        
    }

    public void first(Runnable printFirst) throws InterruptedException {
        
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        s2.release();               // S(s2)
    }

    public void second(Runnable printSecond) throws InterruptedException {
        
        // printSecond.run() outputs "second". Do not change or remove this line.
        s2.acquire();               // W(s2)
        printSecond.run();
        s3.release();               // S(s3)
    }

    public void third(Runnable printThird) throws InterruptedException {
        
        // printThird.run() outputs "third". Do not change or remove this line.
        s3.acquire();               // W(s3)
        printThird.run();
    }
}