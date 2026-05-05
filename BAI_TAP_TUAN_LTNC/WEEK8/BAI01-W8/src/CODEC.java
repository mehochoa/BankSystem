//CODE SMELL: switch statements, chuỗi if else dài, mỗi khi thêm 1 loại hình mới thì phải sửa lại code -> thiếu tính đa hình Polymorphism
//REFACTOR: replace conditional with polymorphism
interface Shape {
    double getArea();
}

class Rectangle implements Shape {
    private double width, height;
    public Rectangle(double w, double h) {
        this.width = width;
        this.height = height;
    }
    @Override
    public double getArea() {
        return width * height;
    }
}

class Triangle implements Shape {
    private double base, height;
    public Triangle(double base, double height ) {
        this.base = base;
        this.height = height;
    }
    @Override
    public double getArea() {
        return 0.5 * base * height;
    }
}

class Circle implements Shape {
    private double radius;
    public Circle(double radius) {
        this.radius = radius;
    }
    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }
}