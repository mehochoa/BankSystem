import java.util.*;
import java.util.concurrent.*;

class SecondLargestTask implements Callable<Integer> {  //dùng callable bắt lỗi null
    private int[] arr;

    public SecondLargestTask(int[] arr) {
        this.arr = arr;
    }

    @Override
    public Integer call() {
        try {
            if (arr.length < 2) {
                throw new Exception("Không đủ phần tử");
            }

            int max = Integer.MIN_VALUE;
            int second = Integer.MIN_VALUE;

            for (int num : arr) {
                if (num > max) {
                    second = max;
                    max = num;
                } else if (num > second && num != max) {
                    second = num;
                }
            }

            if (second == Integer.MIN_VALUE) {
                throw new Exception("Không có số lớn thứ hai");
            }

            return second;

        } catch (Exception e) {
            System.out.println("Bỏ qua mảng: " + e.getMessage());
            return null;
        }
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        //thread pool chỉ xử lý 3 luồng, còn lại xếp vào hàng đợi
        ExecutorService executor = Executors.newFixedThreadPool(3);
        List<Future<Integer>> futures = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int size = sc.nextInt();
            int[] arr = new int[size];

            for (int j = 0; j < size; j++) {
                arr[j] = sc.nextInt();
            }

            futures.add(executor.submit(new SecondLargestTask(arr)));
        }

        int s = 0;

        for (int i = 0; i < futures.size(); i++) {
            try {
                Integer kq = futures.get(i).get();  //chờ luồng phụ chạy xong

                if (kq != null) {
                    System.out.println("Array " + i + ": " + kq);
                    s += kq;
                }

            } catch (Exception e) {  //ném lỗi nếu luồng phụ lỗi
                System.out.println("Not found");
            }
        }

        System.out.println("Tổng = " + s);

        executor.shutdown();
    }
}