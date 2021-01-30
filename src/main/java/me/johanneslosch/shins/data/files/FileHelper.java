package me.johanneslosch.shins.data.files;

import me.johanneslosch.shins.data.Logger;

import java.io.File;
import java.io.IOException;

/**
 * <p>FileHelper class.</p>
 *
 * @author hannes
 * @version $Id: $Id
 */
public class FileHelper {
  /**
   * Checks if File exists
   *
   * @param path      path to file
   * @param filename  filename without ending
   * @return          true if exist
   * @param ending a {@link java.lang.String} object.
   */
  public static boolean checkFile(String path, String filename, String ending) {
    if (checkDir(path)) {
      File f = new File(path + "/" + filename + "." + ending);
      try {
        f.createNewFile();
      } catch (IOException e) {
        Logger.error(e.getMessage());
        System.err.println("Error creating " + f.toString());
      }
      return f.isFile() && f.canWrite() && f.canRead();
    }
    return false;
  }

  /**
   * Checks if Dir exists
   * @param path      path to file
   * @return          true if exist
   */
  static boolean checkDir(String path) {
    File theDir = new File(path);

    if (!theDir.exists()) {
      System.out.println("creating directory: " + theDir.getName());
      boolean result = false;

      try {
        theDir.mkdir();
        result = true;
      } catch (SecurityException se) {
        Logger.error(se.getMessage());
        System.err.println(se);
      }
      if (result) {
        System.out.println("DIR created");
      }
    }
    return true;
  }
}
