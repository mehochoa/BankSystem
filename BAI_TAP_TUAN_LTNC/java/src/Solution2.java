public class Solution2 {
    public static boolean isPrime(int n) {
        if (n < 2) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        for (int i = 3; i*i <= n; i+=2){
            if (n % i == 0)
                return false;
        }
        return true;
    }
    public static void main(String[] args){
        System.out.println(isPrime(-2));
        System.out.println(isPrime(0));
        System.out.println(isPrime(4));
        System.out.println(isPrime(11));
        System.out.println(isPrime(40));
    }
}
