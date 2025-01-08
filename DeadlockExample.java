package lab1;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadlockExample {
    
    // Create three locks
    private static final Lock lock1 = new ReentrantLock();
    private static final Lock lock2 = new ReentrantLock();
    private static final Lock lock3 = new ReentrantLock();

    public static void main(String[] args) {
        Thread t1 = new Thread(new Task1());
        Thread t2 = new Thread(new Task2());
        Thread t3 = new Thread(new Task3());

        t1.start();
        t2.start();
        t3.start();
    }

    static class Task1 implements Runnable {
        public void run() {
            try {
                System.out.println("Thread 1: Trying to acquire lock1");
                lock1.lock();
                System.out.println("Thread 1: Acquired lock1");

                Thread.sleep(1000); // Simulate work
                System.out.println("Thread 1: Trying to acquire lock2");
                lock2.lock();
                System.out.println("Thread 1: Acquired lock2");

                Thread.sleep(1000); // Simulate work
                System.out.println("Thread 1: Trying to acquire lock3");
                lock3.lock();
                System.out.println("Thread 1: Acquired lock3");

                Thread.sleep(1000); // Simulate work
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                System.out.println("Thread 1: Released all locks");
                lock3.unlock();
                lock2.unlock();
                lock1.unlock();
            }
        }
    }

    // Task for thread 2 (introducing a deadlock by acquiring locks in a different order)
    static class Task2 implements Runnable {
        public void run() {
            try {
                System.out.println("Thread 2: Trying to acquire lock2");
                lock2.lock();
                System.out.println("Thread 2: Acquired lock2");

                Thread.sleep(1000); // Simulate work
                System.out.println("Thread 2: Trying to acquire lock3");
                lock3.lock();
                System.out.println("Thread 2: Acquired lock3");

                Thread.sleep(1000); // Simulate work
                System.out.println("Thread 2: Trying to acquire lock1");
                lock1.lock();
                System.out.println("Thread 2: Acquired lock1");

                Thread.sleep(1000); // Simulate work
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                System.out.println("Thread 2: Released all locks");
                lock1.unlock();
                lock3.unlock();
                lock2.unlock();
            }
        }
    }

    // Task for thread 3
    static class Task3 implements Runnable {
        public void run() {
            try {
                System.out.println("Thread 3: Trying to acquire lock3");
                lock3.lock();
                System.out.println("Thread 3: Acquired lock3");

                Thread.sleep(1000); // Simulate work
                System.out.println("Thread 3: Trying to acquire lock1");
                lock1.lock();
                System.out.println("Thread 3: Acquired lock1");

                Thread.sleep(1000); // Simulate work
                System.out.println("Thread 3: Trying to acquire lock2");
                lock2.lock();
                System.out.println("Thread 3: Acquired lock2");

                Thread.sleep(1000); // Simulate work
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                System.out.println("Thread 3: Released all locks");
                lock2.unlock();
                lock1.unlock();
                lock3.unlock();
            }
        }
    }
}
