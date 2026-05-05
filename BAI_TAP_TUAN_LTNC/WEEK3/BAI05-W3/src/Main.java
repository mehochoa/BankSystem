import java.util.*;

class Employee{
    String name;
    String dob;
    String id;
    public Employee(String name, String dob, String id){
        this.name = name;
        this.dob = dob;
        this.id = id;
    }
    public double salary(){
        return 0;
    }
    public String getType(){
        return "Employee";
    }
    public String toString(){
        return name + " - " + getType() + " - " + salary();
    }
}
class FullTimeEmployee extends Employee{
    double baseSalary;
    double bonus;
    double penalty;
    public FullTimeEmployee(String name, String dob, String id, double baseSalary, double bonus, double penalty){
        super(name,dob,id);
        this.baseSalary = baseSalary;
        this.bonus = bonus;
        this.penalty = penalty;
    }
    public double salary(){
        return baseSalary + bonus - penalty;
    }
    public String getType(){
        return "Full-time";
    }
}
class PartTimeEmployee extends Employee{
    double workingHours;
    double hourlyRate;
    public PartTimeEmployee(String name, String dob, String id, double workingHours, double hourlyRate){
        super(name,dob,id);
        this.workingHours = workingHours;
        this.hourlyRate = hourlyRate;
    }
    public double salary(){
        return workingHours * hourlyRate;
    }
    public String getType(){
        return "Part-time";
    }
}
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        Employee[] emp = new Employee[n];
        for (int i = 0; i<n; i++){
            String type = sc.next();
            String name = sc.next();
            String dob = sc.next();
            String id = sc.next();
            if (type.equals("F")){
                double baseSalary = sc.nextDouble();
                double bonus = sc.nextDouble();
                double penalty = sc.nextDouble();
                emp[i] = new FullTimeEmployee(name, dob, id, baseSalary, bonus, penalty);
            } else if (type.equals("P")){
                double workingHours = sc.nextDouble();
                double hourlyRate = sc.nextDouble();
                emp[i] = new PartTimeEmployee(name, dob, id, workingHours, hourlyRate);
            }
        }
        for (Employee e: emp){
            System.out.println(e);
        }
        sc.close();
    }
}