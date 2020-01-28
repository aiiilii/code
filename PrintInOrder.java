import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class PrintInOrder {

    Semaphore run2;
    Semaphore run3;

    /**
     * Concurrency - Using Semaphore
     * @param 
     */
    public PrintInOrder() {
        run2 = new Semaphore(0);
        run3 = new Semaphore(0);
    }
    
    public void first(Runnable printFirst) throws InterruptedException {
        
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        run2.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {

        run2.acquire();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        run3.release();
    }

    public void third(Runnable printThird) throws InterruptedException {

        run3.acquire();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }



    private AtomicInteger firstJobDone = new AtomicInteger(0);
    private AtomicInteger secondJobDone = new AtomicInteger(0);

    // public PrintInOrder() {

    // }

    public void first1(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        firstJobDone.incrementAndGet();
    }

    public void second1(Runnable printSecond) throws InterruptedException {

        while (firstJobDone.get() != 1) {
            // waiting for the first job to be done.
        }
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        secondJobDone.incrementAndGet();
    }

    public void third3(Runnable printThird) throws InterruptedException {

        while (secondJobDone.get() != 1) {
            // waiting for the second job to be done;
        }
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}