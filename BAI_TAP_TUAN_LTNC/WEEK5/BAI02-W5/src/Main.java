import java.util.*;

class Customer{
    String id;
    String name;
    Customer(String id, String name){
        this.id = id;
        this.name = name;
    }
    @Override
    public String toString(){
        return name + "(ID: " + id + ")";
    }
}
class Message{
    String id;
    String content;
    Message(String id, String content){
        this.id = id;
        this.content = content;
    }
}
class Ticket{
    String id, content, timestamp;
    Ticket(String id, String content, String timestamp){
        this.id = id;
        this.content = content;
        this.timestamp = timestamp;
    }
}
public class Main{
    public static void main(String[] args) {
        Queue<Customer> cus = new LinkedList<>();
        Stack<String> mes = new Stack<>();

        System.out.println("---HỆ THỐNG HỖ TRỢ SHOPEE XIN CHÀO---");

        cus.add(new Customer("C01", "Khách A"));
        cus.add(new Customer("C02", "Khách B"));
        System.out.println("Đã thêm vào hàng đợi.");
        handle(cus, mes);
        handle(cus, mes);
        handle(cus, mes);
    }
    public static void handle(Queue<Customer> queue, Stack<String> history){
        Customer cus = queue.poll();   //poll() lấy khách hàng ra khỏi hàng đợi
        if (cus == null){
            System.out.println("\n[Thông báo]: Không còn khách đợi.");
            return;
        }
        System.out.println("\n---Đang xử lý cho: " + cus + "---");

        //giả lập nhân viên
        history.push("Xin chào, tôi có thể giúp gì cho bạn?");
        history.push("Đơn đặt hàng của bạn đang được kiểm tra");
        history.push("Gõ nhầm");
        System.out.println("Nhân viên đã gõ ba tin nhắn.");

        //undo
        if (!history.isEmpty()){
            String removed = history.pop();
            System.out.println("Lệnh undo: Đã xóa dòng vừa gõ [" + removed + "]");
        }
        //View Last(peek)
        if (!history.isEmpty()){
            System.out.println("Xem lại câu vừa gõ: " + history.peek());
        }

        Ticket tic = new Ticket("T01", "Hỗ trợ" + cus.name, new Date().toString());
        System.out.println("Đã tạo ticket thành công lúc: " + tic.timestamp);
        history.clear();
    }
}
