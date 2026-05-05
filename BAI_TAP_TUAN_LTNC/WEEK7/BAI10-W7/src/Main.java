class Worker implements Runnable {
    // volatile đảm bảo các luồng khác nhìn thấy giá trị mới nhất ngay lập tức
    private volatile boolean running = true;

    public void stop() {
        running = false; // yêu cầu dừng luồng
    }

    @Override
    public void run() {
        while (running) {
            System.out.println("Working...");
            try {
                Thread.sleep(200); // tránh spam CPU
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("Worker stopped.");
    }
}

public class Main {
    public static void main(String[] args) {
        Worker worker = new Worker();
        Thread t = new Thread(worker);

        t.start(); // chạy luồng

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        worker.stop();

        try {
            t.join(); // đợi luồng kết thúc
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main finished.");
    }
}