public class Solution1 {
    public static int gcd(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        if (a == 0) return b;
        if (b == 0) return a;
        while (b != 0){
            int cur = b;
            b = a % b;
            a = cur;
        }
        return a;
    }
    public static void main(String[] args) {
        System.out.println(gcd(6,12));
        System.out.println(gcd(25,5));
        System.out.println(gcd(3,4));
        System.out.println(gcd(1,0));
        System.out.println(gcd(-4,16));
    }
}
