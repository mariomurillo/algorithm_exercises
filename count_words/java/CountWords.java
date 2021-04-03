import java.util.HashMap;
import java.util.Map;

public class CountWords {
  public static void main(String args[]) {
    String sentence = "hello, world! Hello?.";
    System.out.println(countWords(sentence));
  }

  private static Map<String, Integer> countWords(String sentence) {
    Map<String, Integer> resultMap = new HashMap<>();
    sentence = sentence.trim().toLowerCase().replaceAll("[,\\.;!\\?]?", "");
    String[] words = sentence.split(" ");
    for (String word: words) {
      if (resultMap.containsKey(word)) {
        resultMap.compute(word, (k,v) -> ++v);
      } else {
        resultMap.put(word, 1);
      }
    }
    return resultMap;
  }
}
