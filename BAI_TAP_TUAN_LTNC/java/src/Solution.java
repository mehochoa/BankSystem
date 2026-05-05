public class Solution {
    public static long fibonacci(long n) {
        if (n < 0){
            return -1;
        }
        if (n == 0) return 0;
        if (n == 1) return 1;
        long prev1 = 0;
        long prev2 = 1;
        long cur = 0;
        for (long i = 2; i <= n; i++) {
            if (Long.MAX_VALUE - prev2 < prev1) {
                return Long.MAX_VALUE;
            }
            cur = prev1 + prev2;
            prev1 = prev2;
            prev2 = cur;
        }
        return cur;
    }
    public static void main(String[] args) {
        System.out.println(fibonacci(0));
        System.out.println(fibonacci(1));
        System.out.println(fibonacci(10));
        System.out.println(fibonacci(100));
        System.out.println(fibonacci(-1));
    }
}
