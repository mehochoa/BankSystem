public class Solution {
    public static int secondLargest(int[] arr){
        if (arr == null || arr.length < 2){
            return -1;
        }
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        for (int num : arr){
            if (num > max1){
                max2 = max1;
                max1 = num;
            }
            else if (num > max2 && num != max1){
                max2 = num;
            }
        }
        if (max2 == Integer.MIN_VALUE){
            return -1;
        }
        return max2;
    }
    public static void main(String[] args){
        int[] arr1 = {1,3,5,7,9};
        int[] arr2 = {6,4,6,1,3};
        int[] arr3 = {2,2};
        int[] arr4 = {1};
        int[] arr5 = {1,6,5,5};

        System.out.println(secondLargest(arr1));
        System.out.println(secondLargest(arr2));
        System.out.println(secondLargest(arr3));
        System.out.println(secondLargest(arr4));
        System.out.println(secondLargest(arr5));
    }
}

