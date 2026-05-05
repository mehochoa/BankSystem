class Student{
    private String id;
    private String name;
    private String email;
    private double gpa;

    //Constructor không tham số
    public Student(){
        id = "";
        name = "";
        email = "";
        gpa = 0.0;
    }

    //Constructor có tham số (id, name)
    public Student(String id, String name){
        this.id = id;
        this.name = name;
        this.email = "";
        this.gpa = 0.0;
    }

    //Copy constructor
    public Student(Student s) {
        this.id = s.id;
        this.name = s.name;
        this.email = s.email;
        this.gpa = s.gpa;
    }

    //Getter
    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public double getGpa() {
        return gpa;
    }

    //setter
    public void setId(String id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setGpa(double gpa) {
        if (gpa >= 0.0 && gpa <= 4.0) {
            this.gpa = gpa;
        } else{
            System.out.println("Lỗi: GPA phải từ 0.0 đến 4.0");
        }
    }

    //Hàm hiển thị thông tin
    public void printInfo() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("GPA: " + gpa);
        System.out.println();
    }
}

public class Main{
    public static void main(String[] args){

        //constructor khong tham so
        Student s1 = new Student();
        s1.setId("SV01");
        s1.setName("An");
        s1.setEmail("an@gmail.com");
        s1.setGpa(-1);

        //constructor (id, name)
        Student s2 = new Student("SV02","Binh");
        s2.setEmail("binh@email.com");
        s2.setGpa(3.0);

        //copy constructor
        Student s3 = new Student(s2);

        //print
        s1.printInfo();
        s2.printInfo();
        s3.printInfo();
    }
}