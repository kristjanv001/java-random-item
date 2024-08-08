import java.util.List;

public class Main {
  static String argMsg = "Please provide a path to a directory containing a " +
          "txt file or other directories. Exiting... .";

  public static void main(String[] args) {
    switch (args.length) {
      case 0 -> {
        System.out.println(Main.argMsg);
        System.exit(0);
      }
      case 1 -> {
        FileHandler fileReader = new FileHandler(args[0]);
        List<String> fileContents = fileReader.readFile();
        String randomItem = ItemPicker.pickRandomElement(fileContents);

        System.out.println(randomItem);
        System.exit(0);
      }
      default -> {
        System.out.println("Too many arguments. " + Main.argMsg);
        System.exit(0);
      }
    }
  }
}
