import java.util.*;
class Book{
    String id;
    String title;
    String author;
    int year;

    public Book(String id, String title, String author, int year){
        this.id = id;
        this.title = title;
        this.author = author;
        this.year = year;
    }
    @Override
    public String toString(){
        return ("ID: " + id + " | Title: " + title + " | Author: " + author + " | Year: " + year);
    }
}

public class Main{
    public static void main(String[] args){
        //khởi tạo 3 cấu trúc dữ liệu
        List<Book> arrayList = new ArrayList<>();
        Map<String, Book> hashMap = new HashMap<>();
        Map<String, Book> treeMap = new TreeMap<>();

        //danh sách dữ liệu mẫu
        Book b1 = new Book("B03", "Toan", "Nguyen Hai Nam", 2007);
        Book b2 = new Book("B04", "Tieng Anh", "Nguyen Tran Minh Anh", 2008);
        Book b3 = new Book("B01", "Vat Ly", "Duong Nguyen Thach Son", 2026);
        Book b4 = new Book("B05", "Hoa Hoc", "Vu Ha Thuy Dung", 2012);
        Book b5 = new Book("B02", "Ngu Van", "Le Thi Thuy Tien", 2018);

        System.out.println("---1. ADD BOOK---");
        Book[] books = {b1, b2, b3, b4, b5};
        for (Book b: books){
            arrayList.add(b);
            hashMap.put(b.id, b);
            treeMap.put(b.id, b);
        }

        System.out.println("---2. SEARCH BY ID B04---");
        //ArrayList: duyet vong lap
        for (Book b: arrayList){
            if (b.id.equals("B04")){
                System.out.println("ArrayList tìm thấy: " + b.title);
                break;
            }
        }
        //map: truy cập trực tiếp
        System.out.println("HashMap tìm thấy: " + hashMap.get("B04").title);
        System.out.println("TreeMap tìm thấy: " + treeMap.get("B04").title);

        System.out.println("\n---3.DELETE BY ID (B02)---");
        arrayList.removeIf(b -> b.id.equals("B02"));
        hashMap.remove("B02");
        treeMap.remove("B02");
        System.out.println("Đã xóa B02 khỏi hệ thống.");

        System.out.println("\n---4.PRINT LIST---");
        System.out.println("\n---ArrayList---");
        arrayList.forEach(System.out::println);
        System.out.println("\n---HashMap---");
        hashMap.values().forEach(System.out::println);
        System.out.println("\n---TreeMap---");
        treeMap.values().forEach(System.out::println);
    }
}
/* - Độ phức tạp trong tìm kiếm:
    + ArrayList: O(n) do phải duyệt từng phần tử
    + HashMap: O(1) do tìm kiếm theo mã băm
    + TreeMap: O(logn) do tìm kiếm nhị phân
   - Khi cần tìm:
    + Số lượng sách nhỏ: dùng ArrayList do tốn ít bộ nhớ
    + Số lượng sách rất lớn: dùng HashMap để tìm kiếm diễn ra nhanh do tìm kiếm theo hashcode
    + Cần dữ liệu sắp xếp theo ID: dùng TreeMap vì cấu trúc cây nhị phân tự cân bằng nên các Key sẽ được xếp theo thứ tự tăng dần
   - HashMap nhanh hơn ArrayList vì ArrayList phải duyệt qua từng phần tử của danh sách, còn HashMap sử dụng thuật toán băm tính toán được vị trí của cuốn sách cần tìm qua Hash Code
 */