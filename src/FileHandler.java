import java.util.*;
import java.io.*;

public class FileHandler {
  private final String filePath;
  public final ArrayList<String> list = new ArrayList<>();

  FileHandler(String path) {
    this.filePath = path;
  }

  public List<String> readFile() {
    try {
      File file = new File(this.filePath);

      if (file.isFile()) {
        BufferedReader reader = new BufferedReader(new java.io.FileReader(file));
        String line = null;

        while ((line = reader.readLine()) != null) {
          this.list.add(line);
        }
        reader.close();
      }

      if (file.isDirectory()) {
        file.listFiles(new FileFilter() {
          @Override
          public boolean accept(File f) {
            if (!f.isHidden()) {
              list.add(f.getName());
            }
            return false;
          }
        });
      }

      return this.list;

    } catch (Exception ex) {
      ex.printStackTrace();
    }

    return new ArrayList<String>();
  }

}
