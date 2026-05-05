class Animal{
    public void makeSound(){
        System.out.println("Animal sound");
    }
}
class Dog extends Animal{
    public void makeSound(){
        System.out.println("Woof woof");
    }
}
class Cat extends Animal{
    public void makeSound(){
        System.out.println("Meow meow");
    }
}
public class Main{
    public static void main(String[] args){
        //Bước 1: Upcasting (an toàn)
        Animal a = new Dog(); //Dog kế thừa Animal
        //Bước 2: Downcasting (rủi ro)
        // Cat c = (Cat) a; //Nếu chạy dòng này sẽ lỗi ClassCastException
        //Bước 3: Sửa lỗi bằng instanceof
        if ( a instanceof Cat){
            Cat c = (Cat) a;
            c.makeSound();
        }else{
            System.out.println("Đây không phải là Mèo!!");
        }
    }
}
