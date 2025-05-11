class FizzBuzz {
    private int n;

// We have created the releaseNext() method to avoid the same lines of code 
// ie, Principle of DRY (Don't Repeat Yourself)
    Semaphore fzSem = new Semaphore(0);
    Semaphore bzSem = new Semaphore(0);
    Semaphore fzbzSem = new Semaphore(0);
    Semaphore numSem = new Semaphore(1);
    private int curr = 1;

    public FizzBuzz(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        while (true) {
            fzSem.acquire();
            if (curr > n)
                break;

            printFizz.run();
            releaseNext();
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        while (true) {
            bzSem.acquire();
            if (curr > n)
                break;

            printBuzz.run();
            releaseNext();
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while (true) {
            fzbzSem.acquire();
            if (curr > n)
                break;

            printFizzBuzz.run();
            releaseNext();
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        while (true) {
            numSem.acquire();
            if (curr > n) {
                fzSem.release();
                bzSem.release();
                fzbzSem.release();
                break;
            }

            if (curr % 3 == 0 && curr % 5 == 0) 
                fzbzSem.release();
            else if (curr % 3 == 0) 
                fzSem.release();
            else if (curr % 5 == 0)
                bzSem.release();
            else {
                printNumber.accept(curr);
                releaseNext();
            }
        }
    }

    public void releaseNext() {
        curr++;
        numSem.release();
    }
}