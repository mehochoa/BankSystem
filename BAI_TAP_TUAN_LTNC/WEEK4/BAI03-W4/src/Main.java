import java.util.Scanner;

interface IWorkable{
    void work();
}
abstract class Employee implements IWorkable{
    String id;
    String name;
    double baseSalary;
    public Employee(String id, String name, double baseSalary){
        this.id = id;
        this.name = name;
        this.baseSalary = baseSalary;
    }
    abstract double calculatePay();
}
class OfficeWorker extends Employee{
    public OfficeWorker(String id, String name, double baseSalary){
        super(id, name, baseSalary);
    }
    @Override
    public double calculatePay(){
        return baseSalary;
    }
    @Override
    public void work(){
        System.out.println("Soạn thảo văn bản");
    }
}
class Technician extends Employee{
    int overtimeHours;
    public Technician(String id, String name, double baseSalary, int overtimeHours){
        super(id, name, baseSalary);
        this.overtimeHours = overtimeHours;
    }
    @Override
    public double calculatePay(){
        return baseSalary + overtimeHours*20000;
    }
    @Override
    public void work(){
        System.out.println("Lắp đặt thiết bị");
    }
}
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        Employee[] employees = new Employee[n];
        for (int i = 0; i < n; i++){
            String line = sc.nextLine();
            String[] data = line.split(" ");
            if (data[0].equals("O")){
                String id = data[1];
                String name = data[2];
                double salary = Double.parseDouble(data[3]);
                employees[i] = new OfficeWorker(id, name, salary);
            } else if (data[0].equals("T")){
                String id = data[1];
                String name = data[2];
                double salary = Double.parseDouble(data[3]);
                int overtime = Integer.parseInt(data[4]);
                employees[i] = new Technician(id, name, salary, overtime);
            }
        }
        for (Employee e : employees){
            System.out.println(e.name + " - Pay: " + e.calculatePay());
            e.work();
            System.out.println();
        }
        sc.close();
    }
}