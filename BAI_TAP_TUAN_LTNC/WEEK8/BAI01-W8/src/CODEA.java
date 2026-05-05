//CODE SMELL: Đoạn code A đặt tên biến ko rõ ràng, người đọc khó bảo trì và sửa lỗi, magic number ở số 0.9, xuất hiện mà ko biết ý nghĩa là gì
//REFACTOR CODE A: rename variable and replace magic number with symbolic constant
public class CODEA {
    public double calculateFee(String type, int hours, double rate, boolean isMember) {
        double finalFee = hours * rate;
        double memberDiscount = 0.9;

        if (isMember) {
            finalFee = finalFee * memberDiscount;
        }
        return finalFee;
    }
}