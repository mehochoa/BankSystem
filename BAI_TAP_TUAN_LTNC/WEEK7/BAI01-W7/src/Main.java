class Task implements Runnable { //runnable
    private String name;
    private long durationMs;

    public Task(String name, long durationMs) {
        this.name = name;
        this.durationMs = durationMs;
    }

    @Override
    public void run() {
        System.out.println("Start " + name);
        try {
            Thread.sleep(durationMs);    //sleep() tạm dừng luồng hiện tại mà không giải phóng các tài nguyên khóa
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("End " + name);
    }
}

public class Main {
    public static void main(String[] args) {

        Task task1 = new Task("Task 1", 2000);
        Task task2 = new Task("Task 2", 3000);

        Thread t1 = new Thread(task1);  //thread
        Thread t2 = new Thread(task2);

        t1.start();
        t2.start();

        try {
            // Đợi cả 2 thread chạy xong mới chạy
            t1.join();
            t2.join();
        } catch (InterruptedException e) {//lỗi khi bị gián đoạn
            e.printStackTrace();
        }

        System.out.println("All tasks done.");
    }
}