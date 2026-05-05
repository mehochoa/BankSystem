import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào một đoạn văn bản bằng tiếng Anh: ");
        String input = sc.nextLine();

        //chuyển về chữ thường
        String cleanInput = input.toLowerCase();
        //bỏ dấu câu
        cleanInput = cleanInput.replaceAll("[^a-z]", " ");
        //tách thành mảng các từ
        String[] words = cleanInput.split("\\s+");

        //đếm từ
        Map<String, Integer> wordMap = new HashMap<>();

        for (String word: words){
            //bỏ qua khoảng trắng
            if (word.isEmpty()) continue;
            //từ chưa có trong Map
            if (!wordMap.containsKey(word)){
                wordMap.put(word, 1);
            //từ có trong Map
            }else{
                int oldVal = wordMap.get(word);
                wordMap.put(word, oldVal + 1);
            }
        }
        //sắp xếp và thống kê
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(wordMap.entrySet());
        String mostFrequentWord = "";
        int maxCount = 0;
        List<String> uniqueWords = new ArrayList<>();

        for (Map.Entry<String, Integer> entry: entryList){
            //Tìm từ xuất hiện nhiều nhất
            if (entry.getValue() > maxCount){
                maxCount = entry.getValue();
                mostFrequentWord = entry.getKey();
            }
            //Liệt kê các từ chỉ xuất hiện đúng 1 lần
            if (entry.getValue() == 1){
                uniqueWords.add(entry.getKey());
            }
        }
        System.out.println("\n---KẾT QUẢ---");
        if (mostFrequentWord.isEmpty()){
            System.out.println("Không có dữ liệu.");
        }else{
            System.out.println("1. Từ xuất hiện nhiều nhất: '" + mostFrequentWord + "' (" + maxCount + "lần) ");
            System.out.println("2. Số lượng từ duy nhất (chỉ xuất hiện 1 lần): " + uniqueWords.size());
            System.out.println("Danh sách các từ duy nhất: " + uniqueWords);
        }
        sc.close();
    }
}