import java.util.List;

public class ItemPicker {

  public static String pickRandomElement(List<String> list) {
    int randomNum = (int) (Math.random() * list.size());
    return list.get(randomNum);
  }
}
