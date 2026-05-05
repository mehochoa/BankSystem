class Product {
    private int id;
    private String name;
    private double price;

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public void setPrice(double price){
        this.price = price;
    }
    public void printProduct(){
        System.out.println(id + " - " + name + " - " + price);
    }
}

class Inventory{
    private Product[] items;
    public Inventory(Product[] initialItems){
        this.items = initialItems;
    }
    public void printInventory(){
        for (Product p : items){
            p.printProduct();
        }
    }
}
public class Main{
    public static void main(String[] args){
        Product[] arr = new Product[2];
        arr[0] = new Product(1,"Laptop",1000);
        arr[1] = new Product(2,"Mouse",50);
        Inventory kho = new Inventory(arr);
        arr[0].setPrice(5000);
        kho.printInventory();
    }
}