interface IData {
    void show(); // Mặc định là public abstract
}
class DataManager implements IData {
    // Cố tình KHÔNG ghi public
    public void show() {
        System.out.println("Show Data");
    }
}
public class Main{
    public static void main(String[] args){
        System.out.println("khi chạy sẽ gây lỗi, vì ko ghi public ở DataManeger nên sẽ coi như là default access\n -> Báo lỗi vì không cho phép override phạm vi hẹp hơn\n Cách sửa: thêm public vào trước void show() khi overriding");
    }
}