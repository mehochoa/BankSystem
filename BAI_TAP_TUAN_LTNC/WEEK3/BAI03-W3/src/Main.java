class MathUtils{
    public int sum(int a, int b){
        return a+b;
    }
}
class AdvancedMath extends MathUtils{
    public int sum(int a, int b){
        return a+b+10;
    }
    public double sum(double a, double b){
        return a+b;
    }
}
public class Main{
    public static void main(String[] args){
        MathUtils m = new AdvancedMath();
        System.out.println(m.sum(5,5));
        //System.out.println(m.sum(5.5,5.5));
    }
}