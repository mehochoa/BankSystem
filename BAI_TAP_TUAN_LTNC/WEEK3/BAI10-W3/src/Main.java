import java.util.*;

class Employee {
    protected String name;
    protected double baseSalary;

    public Employee(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public double calculateBonus() {
        return baseSalary * 0.1;
    }

    public String toString() {
        return name + " - Bonus: " + calculateBonus();
    }
}

class Developer extends Employee {
    private int overtimeHours;

    public Developer(String name, double baseSalary, int overtimeHours) {
        super(name, baseSalary);
        this.overtimeHours = overtimeHours;
    }

    public double calculateBonus() {
        return baseSalary * 0.1 + overtimeHours * 200000;
    }
}

class Tester extends Employee {
    private int bugsFound;

    public Tester(String name, double baseSalary, int bugsFound) {
        super(name, baseSalary);
        this.bugsFound = bugsFound;
    }

    public double calculateBonus() {
        return baseSalary * 0.1 + bugsFound * 50000;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        ArrayList<Employee> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().split(" ");

            if (parts[0].equals("E")) {
                list.add(new Employee(parts[1], Double.parseDouble(parts[2])));
            } else if (parts[0].equals("D")) {
                list.add(new Developer(parts[1], Double.parseDouble(parts[2]), Integer.parseInt(parts[3])));
            } else if (parts[0].equals("T")) {
                list.add(new Tester(parts[1], Double.parseDouble(parts[2]), Integer.parseInt(parts[3])));
            }
        }

        for (Employee e : list) {
            System.out.println(e);

            if (e instanceof Developer) {
                System.out.println("Tặng khóa học AWS");
            } else if (e instanceof Tester) {
                System.out.println("Tặng tool Test");
            }
        }
    }
}
