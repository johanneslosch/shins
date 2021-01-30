package me.johanneslosch.shins.data.files.config;

import me.johanneslosch.shins.data.Logger;
import me.johanneslosch.shins.data.files.FileHelper;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * <p>ConfigReader class.</p>
 *
 * @author hannes
 * @version $Id: $Id
 */
public class ConfigReader {
  /**
   * reads values from .prop(erties) file
   *
   * @param path      path to file
   * @param filename  filename (without ending)
   * @param key       category for value
   * @return          returns value
   */
  public static String read(String path, String filename, String key) {
    Properties prop = new Properties();
    InputStream input = null;
    if (FileHelper.checkFile(path, filename, "prop")) {
      try {

        input = new FileInputStream(new File(path + "/" + filename + ".prop"));

        // load a properties file
        prop.load(input);

        // get the property value and print it out
        prop.getProperty(key);

      } catch (IOException ex) {
        Logger.error(ex.getMessage());
        ex.printStackTrace();
      } finally {
        if (input != null) {
          try {
            input.close();
          } catch (IOException e) {
            Logger.error(e.getMessage());
            e.printStackTrace();
          }
        }
      }
    }
    return prop.getProperty(key);
  }
}
