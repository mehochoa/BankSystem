import java.util.*;
import java.util.concurrent.*;

class SumTask implements Callable<Integer> {   //callable mỗi luồng tính xong phải trả về 1 con số
    private int[] arr;
    private int start, end;

    public SumTask(int[] arr, int start, int end) {
        this.arr = arr;
        this.start = start;
        this.end = end;
    }

    @Override
    public Integer call() {
        int sum = 0;
        for (int i = start; i < end; i++) {
            sum += arr[i];
        }
        System.out.println(Thread.currentThread().getName() +
                " tính từ " + start + " đến " + (end - 1) + " = " + sum);
        return sum;
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập n: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Nhập mảng:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int k = 4; // số thread2
        //executor service và thread pool
        ExecutorService executor = Executors.newFixedThreadPool(k);   //dùng thread pool giúp xử lý nhanh hơn

        List<Future<Integer>> futures = new ArrayList<>();

        int Size = (int) Math.ceil((double) n / k);

        // chia task
        for (int i = 0; i < k; i++) {
            int start = i * Size;
            int end = Math.min(start + Size, n);

            if (start >= n) break;
            //divide and conquer
            futures.add(executor.submit(new SumTask(arr, start, end)));   //chia nhỏ bài toán
        }

        int total = 0;
        for (Future<Integer> f : futures) {
            total += f.get(); // chờ luồng phụ tính xong rồi mới chạy luồng chính
        }

        System.out.println("Tổng cuối = " + total);

        // đóng thread pool
        executor.shutdown();
    }
}