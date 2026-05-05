class MyDate {
    int day;
    int month;
    int year;

    public MyDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    //copy constructor
    public MyDate(MyDate d){
        this.day = d.day;
        this.month = d.month;
        this.year = d.year;
    }

    public void printDate() {
        System.out.println(day + "/" + month + "/" + year);
    }
}

class Employee {
    String name;
    MyDate birthday;

    public Employee(String name, MyDate birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    public Employee(Employee e) {
        this.name = e.name;
        this.birthday = new MyDate(e.birthday);
    }

    public void printInfo() {
        System.out.print(name + " - Birthday: ");
        birthday.printDate();
    }
}

public class Main{
    public static void main(String[] args){
        MyDate d1 = new MyDate(1, 1, 2000);
        Employee emp1 = new Employee("An", d1);
        Employee emp2 = new Employee(emp1);

        emp1.birthday.day = 2;
        emp1.birthday.month = 2;
        emp1.birthday.year = 2022;

        System.out.print("Birthday of emp2: ");
        emp2.birthday.printDate();
    }
}