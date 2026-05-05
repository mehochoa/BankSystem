import java.util.Arrays;

class ArrayUtils{
    public static <T> void swap(T[] array, int i, int j){
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    public static <T extends Comparable<T>> void sort(T[] array){
        int n = array.length;
        for (int i = 0; i < n - 1; i++){
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j].compareTo(array[j + 1]) > 0){
                    swap(array, j, j + 1);
                }
            }
        }
    }
}
class Student implements Comparable<Student>{
    private String name;
    private double gpa;
    public Student(String name, double gpa){
        this.name = name;
        this.gpa = gpa;
    }
    @Override
    public int compareTo(Student other){
        return this.name.compareTo(other.name);
    }
    @Override
    public String toString(){
        return name + "(" + gpa + ")";
    }
}
public class Main{
    public static void main(String[] args){
        Integer[] nums = {5,1,3,2};
        ArrayUtils.sort(nums);
        System.out.println("Numbers: " + Arrays.toString(nums));
        String[] languages = {"Java", "C++", "Python"};
        ArrayUtils.sort(languages);
        System.out.println("Languages:" + Arrays.toString(languages));
        Student[] students ={
                new Student("Minh", 3.5),
                new Student("An", 3.9),
                new Student("Bình", 3.2),
        };
        ArrayUtils.sort(students);
        System.out.println("Students: "+ Arrays.toString(students));
    }
}