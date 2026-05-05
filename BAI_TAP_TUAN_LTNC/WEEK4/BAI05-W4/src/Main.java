class Pair<K,V>{
    private K key;
    private V value;
    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }
    public K getKey(){
        return key;
    }
    public V getValue(){
        return value;
    }
    public void setKey(K key){
        this.key = key;
    }
    public void setValue(V value){
        this.value = value;
    }
    @Override
    public String toString(){
        return key + " - " + value;
    }
}
public class Main{
    public static void main(String[] args){
        Pair<String, Integer> agePair = new Pair<>("Tuổi", 20);
        System.out.println(agePair.toString());
        Pair<String, String> studentPair = new Pair<>("Mã SV","SV001");
        System.out.println(studentPair.toString());
        Pair<Integer,Double> locationPair = new Pair<>(105,21.5);
        System.out.println(locationPair.toString());
        //PHẦN THỬ NGHIỆM LỖI: GÁN SAI KIỂU DỮ LIỆU
//        Pair<String, Integer> errorPair = new Pair<>("error","test");
        System.out.println("Nếu gán sai kiểu dữ liệu, java sẽ báo lỗi");
    }
}