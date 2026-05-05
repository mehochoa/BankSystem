//CODE SMELL: data clump: các thuộc tính authorName, authorEmail, ... luôn xuất hiện cùng nhau. Nếu có thêm class thì sẽ phải lặp lại rất phiền phức
//REFACTOR: extract class : gom các thuộc tính liên quan đến tác giả vào một class riêng
public class CODED {
    class Author {
        private String name;
        private String email;
        private String phone;
        private String adress;

        //getter, setter, constructor ...
    }

    class Report {
        private String title;
        private String content;
        private Author author;
    }
}
