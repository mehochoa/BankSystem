import java.util.*;
import java.util.concurrent.*;

public class Main {

    // Kiểm tra số nguyên tố
    static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    // Task Stage 1
    static class Stage1 implements Callable<List<Integer>> {
        private final int[] arr;
        private final int index;

        public Stage1(int[] arr, int index) {
            this.arr = arr;
            this.index = index;
        }

        @Override
        public List<Integer> call() {
            List<Integer> primes = new ArrayList<>();
            for (int num : arr) {
                if (isPrime(num)) {
                    primes.add(num);
                }
            }
            System.out.println("Stage 1 - Array " + index + ": " + primes);
            return primes;
        }
    }

    // Task Stage 2
    static class Stage2 implements Callable<Integer> {
        private final List<Integer> primes;
        private final int index;

        public Stage2(List<Integer> primes, int index) {
            this.primes = primes;
            this.index = index;
        }

        @Override
        public Integer call() {
            int sum = 0;

            if (primes.size() % 2 == 0) {
                for (int x : primes) {
                    sum += x * x;
                }
                System.out.println("Stage 2 - Array " + index + ": sum of squares = " + sum);
            } else {
                for (int x : primes) {
                    sum += x * x * x;
                }
                System.out.println("Stage 2 - Array " + index + ": sum of cubes = " + sum);
            }

            return sum;
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<int[]> arrays = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int m = sc.nextInt();
            int[] arr = new int[m];
            for (int j = 0; j < m; j++) {
                arr[j] = sc.nextInt();
            }
            arrays.add(arr);
        }

        // 2 thread pool riêng
        ExecutorService pool1 = Executors.newFixedThreadPool(n);
        ExecutorService pool2 = Executors.newFixedThreadPool(n);

        CompletionService<List<Integer>> cs1 = new ExecutorCompletionService<>(pool1);
        CompletionService<Integer> cs2 = new ExecutorCompletionService<>(pool2);

        // submit stage 1
        for (int i = 0; i < n; i++) {
            cs1.submit(new Stage1(arrays.get(i), i));
        }

        int total = 0;

        // xử lý kết quả stage 1 -> submit sang stage 2
        for (int i = 0; i < n; i++) {
            Future<List<Integer>> f1 = cs1.take(); // task nào xong trước lấy trước
            List<Integer> primes = f1.get();

            int index = i;

            cs2.submit(new Stage2(primes, index));
        }

        // lấy kết quả stage 2
        for (int i = 0; i < n; i++) {
            total += cs2.take().get();
        }

        pool1.shutdown();
        pool2.shutdown();

        System.out.println("Total = " + total);
    }
}