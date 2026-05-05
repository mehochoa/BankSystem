class Animal{
    public void makeSound(){
        System.out.println("Animal sound");
    }
}

class Dog extends Animal{
    public void makeSound() {
        System.out.println("Woof woof");
    }
}
class Cat extends Animal{
    public void makeSound() {
        System.out.println("Meows meows");
    }
}
class MeoTamThe extends Cat{
    public void makeSound(){
        System.out.println("Meoooo");
    }
}
class Duck extends Animal{
}

public class Main{
    public static void main(String[] args){
        Animal[] zoo = new Animal[4];
        zoo[0] = new Dog();
        zoo[1] = new Cat();
        zoo[2] = new Duck();
        zoo[3] = new Dog();
        for (int i=0; i<zoo.length; i++){
            zoo[i].makeSound();
        }
    }
}
