class Book {
    private String title;
    private String author;
    private double price;

    public Book(String title, String author, double price){
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Book b = (Book) obj;

        return title.equals(b.title) && author.equals(b.author) && price == b.price;
    }
}

public class Main{
    public static void main(String[] args) {
        Book b1 = new Book("Java", "James", 10.5);
        Book b2 = new Book("Java", "James", 10.5);

        System.out.println("So sánh bằng == :" + ( b1 == b2));
        System.out.println("So sánh bằng equals : " + b1.equals(b2));
    }
}
