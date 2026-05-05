import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class BookStore {
    private final Map<String, Integer> stock = new HashMap<>();
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();   //reentrantreadwritelock cho phép nhiều luồng đọc
    // Đọc sách
    public int getStock(String title) {
        lock.readLock().lock();  //khóa đọc
        try {
            System.out.println(Thread.currentThread().getName() + " đang đọc sách " + title);
            return stock.getOrDefault(title, 0);
        } finally {
            lock.readLock().unlock();  //mở khóa đọc
        }
    }

    // Thêm sách
    public void addBook(String title, int qty) {
        lock.writeLock().lock();  //khóa ghi
        try {
            System.out.println(Thread.currentThread().getName() + " đang thêm sách: " + title);
            stock.put(title, stock.getOrDefault(title, 0) + qty);
        } finally {
            lock.writeLock().unlock();  //mở khóa ghi
        }
    }

    // Mượn sách
    public void borrow(String title, int qty) {
        lock.writeLock().lock();
        try {
            int current = stock.getOrDefault(title, 0);

            if (current >= qty) {
                stock.put(title, current - qty);
                System.out.println(Thread.currentThread().getName() +
                        " mượn " + qty + " sách " + title);
            } else {
                System.out.println("Không đủ sách để mượn " + title);
            }
        } finally {
            lock.writeLock().unlock();
        }
    }
}

public class Main {
    public static void main(String[] args) {

        BookStore store = new BookStore();
        store.addBook("Java", 10);
        store.addBook("Python", 5);

        // Tạo luồng đọc
        Runnable reader = () -> {
            int qty = store.getStock("Java");
            System.out.println(Thread.currentThread().getName() + " thấy: " + qty);
        };

        Thread r1 = new Thread(reader, "Reader-1");
        Thread r2 = new Thread(reader, "Reader-2");
        Thread r3 = new Thread(reader, "Reader-3");

        // Tạo luồng ghi
        Runnable writer1 = () -> {
            store.borrow("Java", 3);
        };

        Runnable writer2 = () -> {
            store.addBook("Java", 5);
        };

        Thread w1 = new Thread(writer1, "Writer-1");
        Thread w2 = new Thread(writer2, "Writer-2");

        r1.start();
        r2.start();
        r3.start();
        w1.start();
        w2.start();

        System.out.println("Hoàn thành");
    }
}