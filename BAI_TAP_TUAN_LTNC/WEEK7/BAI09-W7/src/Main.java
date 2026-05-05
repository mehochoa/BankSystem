import java.util.concurrent.locks.ReentrantLock;

class Counter {
    private int value = 0;
    private final ReentrantLock lock = new ReentrantLock();

    //  Dùng lock()
    public void increment() {
        lock.lock(); // chiếm lock
        try {
            value++;
        } finally {
            lock.unlock(); // luôn mở khóa
        }
    }

    //Dùng tryLock()
    public void incrementTryLock() {
        if (lock.tryLock()) { // thử lấy lock
            try {
                value++;
            } finally {
                lock.unlock();
            }
        } else {
            System.out.println(Thread.currentThread().getName() + " không lấy được lock");
        }
    }

    public int getValue() {
        return value;
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        // Tạo 4 thread
        Thread[] threads = new Thread[4];

        for (int i = 0; i < 4; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 10000; j++) {
                    counter.increment();
                }
            }, "Thread-" + i);
            threads[i].start();
        }

        for (Thread t : threads) {
            t.join();
        }

        System.out.println("Final counter = " + counter.getValue());
    }
}