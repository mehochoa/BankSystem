import java.util.*;
import java.util.Scanner;

abstract class MediaItem{
    protected String id;
    protected String name;
    public MediaItem(String id, String name){
        this.id = id;
        this.name = name;
    }
    public abstract String getDisplayInfo();
}
class Book extends MediaItem{
    private String author;
    private int pages;
    public Book(String id, String name, String author, int pages){
        super(id, name);
        this.author = author;
        this.pages = pages;
    }
    @Override
    public String getDisplayInfo(){
        return name + " - " + author + " - " + pages;
    }
}
class DVD extends MediaItem{
    private String director;
    private int duration;
    public DVD(String id, String name, String director, int duration){
        super(id, name);
        this.director = director;
        this.duration = duration;
    }
    @Override
    public String getDisplayInfo(){
        return name + " - " + director + " - " + duration;
    }
}
class LibrarySection<T extends MediaItem>{
    private List<T> items = new ArrayList<>();
    public void addItem(T item){
        items.add(item);
    }
    public void displaySection(String title){
        System.out.println(title + ":");
        for (T item: items){
            System.out.println(item.getDisplayInfo());
        }
        System.out.println();
    }
}
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        LibrarySection<Book> bookSection = new LibrarySection<>();
        LibrarySection<DVD> dvdSection = new LibrarySection<>();
        System.out.println("Nhập số tài liệu: ");
        int n = Integer.parseInt(sc.nextLine());
        for (int i=0; i<n; i++){
            String line = sc.nextLine();
            String[] p = line.split(" ");
            String type = p[0];
            String id = p[1];
            String name = p[2];
            if (type.equalsIgnoreCase("B")){
                bookSection.addItem(new Book(id, name, p[3], Integer.parseInt(p[4])));
            }else if (type.equalsIgnoreCase("D")){
                dvdSection.addItem(new DVD(id, name, p[3], Integer.parseInt(p[4])));
            }
        }
        bookSection.displaySection("Khu Vực Sách");
        dvdSection.displaySection("Khu Vực DVD");
        sc.close();
    }
}