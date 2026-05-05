interface canFly{
    void fly();
}
interface canSwim{
    void swim();
}
interface canFight{
    void fight();
}
class ActionCharacter{
    public void fight(){
        System.out.println("Đấm bốc...");
    }
}
class Hero extends ActionCharacter implements canFly, canSwim, canFight{
    @Override
    public void fly(){
        System.out.println("Hero is flying");
    }
    @Override
    public void swim(){
        System.out.println("Hero is swimming");
    }
    //không cần ghi đè fight vì trên lớp cha đã có
}
class Main{
    public static void main(String[] args){
        Hero hero = new Hero();
        canSwim swimmer = hero;
        swimmer.swim();
        canFight fighter = hero;
        fighter.fight();
    }
}