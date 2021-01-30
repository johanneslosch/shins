package me.johanneslosch.shins.data;


import me.johanneslosch.shins.data.files.WriteFile;
import me.johanneslosch.shins.util.Time;

/**
 * <p>Logger class.</p>
 *
 * @author hannes
 * @version $Id: $Id
 */
public class Logger {
  /**
   * <p>msg.</p>
   *
   * @param content a {@link java.lang.String} object.
   */
  public static void msg(String content) { logger("msg", content); }
  /**
   * <p>error.</p>
   *
   * @param content a {@link java.lang.String} object.
   */
  public static void error(String content) { logger("error", content); }
  /**
   * <p>warning.</p>
   *
   * @param content a {@link java.lang.String} object.
   */
  private static void logger(String type, String content) {
    if (type.equals("warning")) {
      WriteFile.writer("logs", "LOG", "log",
                       String.format("%s %s - [WARNING]: %s \n", Time.getCurrentDate(), Time.getCurrentTime(), content));
    } else if (type.equals("error")) {
      WriteFile.writer("logs", "LOG", "log",
                       String.format("%s %s - [ERROR]: %s \n", Time.getCurrentDate(), Time.getCurrentTime(), content));
    } else {
      WriteFile.writer("logs", "LOG", "log",
                       String.format("%s %s - [MESSAGE]: %s \n", Time.getCurrentDate(), Time.getCurrentTime(), content));
    }
  }
}
