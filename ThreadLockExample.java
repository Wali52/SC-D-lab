package threadlockexample;
import java.io.IOException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class ThreadLockExample {

    private final Lock lock = new ReentrantLock();
    private static final Logger logger = Logger.getLogger(ThreadLockExample.class.getName());

    public static void main(String[] args) {
        setupLogger();
        ThreadLockExample example = new ThreadLockExample();

        Thread thread1 = new Thread(example::performTask, "Thread-1");
        Thread thread2 = new Thread(example::performTask, "Thread-2");

        thread1.start();
        thread2.start();
    }

    private void performTask() {
        logAction("Starting task");

        try {
            logAction("Trying to acquire lock");
            lock.lock();

            logAction("Lock acquired, performing task");
            Thread.sleep(1000); // Simulate task
        } catch (InterruptedException e) {
            logAction("Task interrupted: " + e.getMessage());
            Thread.currentThread().interrupt();
        } finally {
            logAction("Releasing lock");
            lock.unlock();
        }

        logAction("Task completed");
    }

    private static void setupLogger() {
        try {
            FileHandler fileHandler = new FileHandler("thread_actions.log", true);
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);
            logger.setUseParentHandlers(false); // Disable console logging
        } catch (IOException e) {
            System.err.println("Failed to set up logger: " + e.getMessage());
        }
    }

    private void logAction(String message) {
        String threadName = Thread.currentThread().getName();
        logger.info(threadName + ": " + message);
    }
}


