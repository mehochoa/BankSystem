class Person {
    private String name;
    private Person me;

    public Person(String name) {
        this.name = name;
    }
    public void setMe(Person other) {
        this.me = other;
    }
    public Person getMe() {
        return me;
    }
    public String getName() {
        return name;
    }
}

public class Main {
    public static void main(String[] args) {
        Person p = new Person("A");
        Person a = new Person("B");
        a.setMe(p);
        System.out.println(a.getMe().getName());
        p = null;
    }
}
