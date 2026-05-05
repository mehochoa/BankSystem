public class Solution {
    public static int reverse(int n){
        int res = 0;
        while (n != 0){
            int digit = n% 10;
            n = n / 10;
            if (res > Integer.MAX_VALUE / 10 || res < Integer.MIN_VALUE / 10) {
                return 0;
            }
            res = res * 10 + digit;
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println(reverse(123));
        System.out.println(reverse(-123));
        System.out.println(reverse(1000));
        System.out.println(reverse(1));
        System.out.println(reverse(12345689));
    }
}