import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

public class FizzBuzzMultithreaded {

    private int n;
    private Semaphore fizz = new Semaphore(0);
    private Semaphore buzz = new Semaphore(0);
    private Semaphore fizzbuzz = new Semaphore(0);
    private Semaphore num = new Semaphore(1); // starts with number 1, which is a number;

    public FizzBuzzMultithreaded(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        for (int k = 1; k <= n; k++) {
            if (k % 3 == 0 && k % 5 != 0) {
                fizz.acquire();
                printFizz.run();
                releaseLock(k + 1); //releases the next number's semaphore;
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        for (int k = 1; k <= n; k++) {
            if (k % 5 == 0 && k % 3 != 0) {
                buzz.acquire();
                printBuzz.run();
                releaseLock(k + 1);
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        for (int k = 1; k <= n; k++) {
            if (k % 3 == 0 && k % 5 == 0) {
                fizzbuzz.acquire();
                printFizzBuzz.run();
                releaseLock(k + 1);
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        for (int k = 1; k <= n; k++) {
            if (k % 3 != 0 && k % 5 != 0) {
                num.acquire(); // start here, number 1 gets acquired, then printed out,
                printNumber.accept(k);
                releaseLock(k + 1); // the number 2 gets released, which can be acquired again;
            }
        }
    }

    public void releaseLock(int n) {
        if (n % 3 == 0 && n % 5 != 0) {
            fizz.release();
        } else if (n % 5 == 0 && n % 3 != 0) {
            buzz.release();
        } else if (n % 3 == 0 && n % 5 == 0) {
            fizzbuzz.release();
        } else {
            num.release();
        }
    }
}
