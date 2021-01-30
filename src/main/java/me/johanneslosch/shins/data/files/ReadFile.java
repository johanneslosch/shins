package me.johanneslosch.shins.data.files;

import me.johanneslosch.shins.data.Logger;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * <p>ReadFile class.</p>
 *
 * @author hannes
 * @version $Id: $Id
 */
public class ReadFile {

  /**
   * <p>read.</p>
   *
   * @param path a {@link java.lang.String} object.
   * @param filename a {@link java.lang.String} object.
   * @param ending a {@link java.lang.String} object.
   * @return a {@link java.util.List} object.
   */
  public static List<String> read(String path, String filename, String ending) {
    ArrayList<String> content = new ArrayList<>();
    try {
      File fileDir =
          new File(String.format("%s/%s.%s", path, filename, ending));

      BufferedReader in = new BufferedReader(new InputStreamReader(
          new FileInputStream(fileDir), StandardCharsets.UTF_8));

      String str;

      while ((str = in.readLine()) != null) {
        Objects.requireNonNull(content).add(str);
      }
      in.close();
      return content;
    } catch (UnsupportedEncodingException | FileNotFoundException e) {
      System.out.println(e.getMessage());
    } catch (IOException e) {
      Logger.error(e.getMessage());
      e.printStackTrace();
    }
    return null;
  }
}
