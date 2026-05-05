import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;
import java.util.ArrayList;

class PrimeCounter implements Callable<Integer> {
    private final int[] arr;

    public PrimeCounter(int[] arr){
        this.arr = arr;
    }
    private static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public Integer call() {
        int cnt = 0;
        for(int num : arr){
            if(isPrime(num)){
                cnt++;
            }
        }
        return cnt;
    }

}
public class Main {
    static void main() throws Exception {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        List<int[]> arrays = new ArrayList<>();
        List<Future<Integer>> futures = new ArrayList<>();

        ExecutorService executor = Executors.newFixedThreadPool(n);

        for(int i = 0; i < n; i++){
            int m = input.nextInt();
            int[] arr = new int[m];
            for (int j = 0; j < m; j++){
                arr[j] = input.nextInt();
            }
            arrays.add(arr);
        }

        // Submit task
        for(int[] arr : arrays){
            futures.add(executor.submit(new PrimeCounter(arr)));
        }

        List<Integer> results = new ArrayList<>();
        for(int i = 0; i < futures.size(); i++){
            int count = futures.get(i).get();
            results.add(count);
            System.out.println("Array " + i + ": " + count);
        }

        executor.shutdown();

        int max = results.stream().max(Integer::compare).get();

        System.out.print("Most primes: ");
        boolean first = true;
        for(int i = 0; i < results.size(); i++){
            if(results.get(i) == max){
                if(!first) System.out.print(", ");
                System.out.print("Array " + i);
                first = false;
            }
        }
        System.out.println(" with " + max + " primes");
    }
}