import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

class OrderTask implements Callable<Boolean> {
    private String id;
    private long processMs;
    private List<String> logs;
    private AtomicInteger successCount;  //atomicinteger khi nhiều luồng cùng muốn tăng giá trị của 1 biến

    public OrderTask(String id, long processMs, List<String> logs, AtomicInteger successCount) {
        this.id = id;
        this.processMs = processMs;
        this.logs = logs;
        this.successCount = successCount;
    }

    @Override
    public Boolean call() throws Exception {
        System.out.println("Start " + id);

        Thread.sleep(processMs);  //tạm dừng luồng này

        boolean success = processMs <= 1500;

        synchronized (logs) {
            if (success) {
                logs.add("DONE " + id);
            } else {
                logs.add("FAIL " + id);
            }
        }

        if (success) {
            successCount.incrementAndGet();
        }
        return success;
    }
}

public class Main {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        int m = Integer.parseInt(sc.nextLine());

        List<String> logs = new ArrayList<>();
        AtomicInteger successCount = new AtomicInteger(0);

        //executorservice và future
        ExecutorService executor = Executors.newFixedThreadPool(3); //threadbool xử lý được 3 luồng chính cùng lúc
        List<Future<Boolean>> futures = new ArrayList<>();

        for (int i = 0; i < m; i++) {

            String line = sc.nextLine();
            String[] parts = line.split(" ");

            String id = parts[0];
            long processMs = Long.parseLong(parts[1]);

            OrderTask task = new OrderTask(id, processMs, logs, successCount);
            futures.add(executor.submit(task));
        }

        for (Future<Boolean> f : futures) {
            f.get(); //chờ các luồng con chạy xong rồi mới chạy luồng chính
        }

        System.out.println("Success = " + successCount.get());

        for (String log : logs) {
            System.out.println(log);
        }

        executor.shutdown();
    }
}