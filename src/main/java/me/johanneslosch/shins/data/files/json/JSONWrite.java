package me.johanneslosch.shins.data.files.json;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;

import me.johanneslosch.shins.data.Logger;
import org.json.JSONObject;

/**
 * <p>JSONWrite class.</p>
 *
 * @author hannes
 * @version $Id: $Id
 */
public class JSONWrite {
  /**
   * Writes String from a .json File
   *
   * @param jsonFile    File, with .json ending
   * @param key         key aspect to search for, like "name"
   * @param attribute   attribute for the key, ex. "johanneslosch"
   */
  public static void writeJSONString(File jsonFile, String key,
                                     String attribute) {
    try {
      JSONObject jsonObject =
          new JSONObject(Files.readString(Path.of(jsonFile.toURI())));
      jsonObject.put(key, attribute);
      FileWriter fileWriter = new FileWriter(jsonFile);
      fileWriter.write(jsonObject.toString());
      fileWriter.flush();
      fileWriter.close();
    } catch (IOException e) {
      e.printStackTrace();
      Logger.error(e.getMessage());
    }
  }

  /**
   * Writes Integer from a .json file
   *
   * @param jsonFile    File, with .json ending
   * @param key         key aspect to search for, like "age"
   * @param attribute   attribute for the key, ex. "100"
   */
  public static void writeJSONInt(File jsonFile, String key,
                                  Integer attribute) {
    try {
      JSONObject jsonObject =
          new JSONObject(Files.readString(Path.of(jsonFile.toURI())));
      jsonObject.put(key, attribute);
      FileWriter fileWriter = new FileWriter(jsonFile);
      fileWriter.write(jsonObject.toString());
      fileWriter.flush();
      fileWriter.close();
    } catch (IOException e) {
      e.printStackTrace();
      Logger.error(e.getMessage());
    }
  }

  /**
   * Writes Boolean from a .json file
   *
   * @param jsonFile    File, with .json ending
   * @param key         key aspect to search for, like "has_arms"
   * @param attribute   attribute for the key, ex. "true"
   */
  public static void writeJSONBool(File jsonFile, String key,
                                   Boolean attribute) {
    try {
      JSONObject jsonObject =
          new JSONObject(Files.readString(Path.of(jsonFile.toURI())));
      jsonObject.put(key, attribute);
      FileWriter fileWriter = new FileWriter(jsonFile);
      fileWriter.write(jsonObject.toString());
      fileWriter.flush();
      fileWriter.close();
    } catch (IOException e) {
      e.printStackTrace();
      Logger.error(e.getMessage());
    }
  }
  /**
   * Writes Object from a .json file
   *
   * @param jsonFile    File, with .json ending
   * @param key         key aspect to search for
   * @param attribute   attribute for the key
   */
  public static void writeJSONObject(File jsonFile, String key,
                                     Object attribute) {
    try {
      JSONObject jsonObject =
          new JSONObject(Files.readString(Path.of(jsonFile.toURI())));
      jsonObject.put(key, attribute);
      FileWriter fileWriter = new FileWriter(jsonFile);
      fileWriter.write(jsonObject.toString());
      fileWriter.flush();
      fileWriter.close();
    } catch (IOException e) {
      e.printStackTrace();
      Logger.error(e.getMessage());
    }
  }
  /**
   * Writes Object from a .json file
   *
   * @param jsonFile    File, with .json ending
   * @param key         key aspect to search for
   * @param attribute   attribute for the key
   */
  public static void writeJSONArray(File jsonFile, String key,
                                    Array attribute) {
    try {
      JSONObject jsonObject =
          new JSONObject(Files.readString(Path.of(jsonFile.toURI())));
      jsonObject.put(key, attribute);
      FileWriter fileWriter = new FileWriter(jsonFile);
      fileWriter.write(jsonObject.toString());
      fileWriter.flush();
      fileWriter.close();
    } catch (IOException e) {
      e.printStackTrace();
      Logger.error(e.getMessage());
    }
  }
}
