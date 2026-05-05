import java.util.*;


public class Main{
    public static void main(String[] args){
        List<Student> students = new ArrayList<>();
        students.add(new Student("S01", "NguyenVanA", 7.5));
        students.add(new Student("S02", "TranThiB", 4.5));
        students.add(new Student("S03", "LeVanC", 8.0));
        students.add(new Student("S04", "PhamVanD", 5.0));

        students.removeIf(s -> s.getGpa() < 5.0);
        System.out.println("After removing GPA < 5.0:");
        students.forEach(System.out::println);
        students.sort((s1, s2) -> s1.getName().compareTo(s2.getName()));
        System.out.println("\nAfter sorting by name:");
        students.forEach(System.out::println);
        System.out.println("\nCustom Operations:");
        Operation<Double> add = (a, b) -> a + b;
        Operation<Double> multiply = (a, b) -> a * b;
        System.out.println("Addition (10.5 + 5.5): " + add.execute(10.5, 5.5));
        System.out.println("Multiplication (10.0 * 2.5): " + multiply.execute(10.0, 2.5));
    }
}