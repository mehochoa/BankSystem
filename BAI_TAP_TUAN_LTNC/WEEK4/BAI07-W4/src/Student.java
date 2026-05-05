import java.util.*;

public class Student {
    private String id;
    private String name;
    private double gpa;
    public Student(String id, String name, double gpa){
        this.id = id;
        this.name = name;
        this.gpa = gpa;
    }
    public String getName(){ return name;}
    public double getGpa(){ return gpa;}
    @Override
    public String toString(){
        return id + " " + name + " " + gpa;
    }
}
@FunctionalInterface //interface này chỉ có duy nhất một hàm trừu tượng
interface  Operation<T>{
    T execute(T a, T b);
}