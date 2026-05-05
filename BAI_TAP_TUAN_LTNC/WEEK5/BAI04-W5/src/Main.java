import java.util.*;

public class Main{
    private List<String> listWords = new ArrayList<>();
    private Map<String, Integer> mapWords = new HashMap<>();

    public void analyze(String text){
        String cleanText = text.toLowerCase().replaceAll("[,.]", " ");
        String[] words = cleanText.split("\\s+");
        for (String w: words){
            if (w.isEmpty()) continue;
            //ArrayList
            listWords.add(w);
            //HashMap
            if (mapWords.containsKey(w)){
                mapWords.put(w, mapWords.get(w) + 1);
            }else{
                mapWords.put(w, 1);
            }
        }
    }
    public void displayResult(){
        System.out.println("---Kết quả đểm từ (HashMap)---");
        String topWord = "";
        int maxCount = 0;
        for (Map.Entry<String, Integer> entry : mapWords.entrySet()){
            System.out.println(entry.getKey() + ": " + entry.getValue());
            //tìm từ xuất hiện nhiều nhất
            if (entry.getValue() > maxCount){
                maxCount = entry.getValue();
                topWord = entry.getKey();
            }
        }
        System.out.println("\n=> Từ khóa xuất hiện nhiều nhất: '" + topWord + "' (" + maxCount + " lần)");
    }

    static void main(String[] args) {
        Main counter = new Main();
        String data = "Hello world. This is a java program. Hello java, hello world.";
        counter.analyze(data);
        counter.displayResult();
    }
}