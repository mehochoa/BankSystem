public class Solution5 {
    public static int sumOfDigits(int n){
        n = Math.abs(n);
        int sum = 0;
        while (n != 0){
            sum += n % 10;
            n = n / 10;
        }
        return sum;
    }
    public static void main(String[] args){
        System.out.println(sumOfDigits(123));
        System.out.println(sumOfDigits(-123));
        System.out.println(sumOfDigits(0));
        System.out.println(sumOfDigits(111));
        System.out.println(sumOfDigits(123456));
    }
}
