class Person{
    String name;
    String dob;
    public Person(String name){
        this.name = name; //gán tham số truyền vào cho biến trong obj
        System.out.println("1. Person is created");
    }
}

class Employee extends Person{
    double salary;
    public Employee(){
        super("abc");  //tạo constructor của lớp cha và truyền tham số cho nó
        System.out.println("2. Employee is created");
    }
}

class Manager extends Employee{
    String department;
    public Manager(){
        super();
        System.out.println("3. Manager is created");
    }
}

public class Main{
    public static void main(String[] args){
        Manager m = new Manager();
    }
}