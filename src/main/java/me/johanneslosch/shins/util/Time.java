package me.johanneslosch.shins.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * <p>Time class.</p>
 *
 * @author hannes
 * @version $Id: $Id
 */
public class Time {
  /**
   * provides current time
   * usable for ex. logs
   *
   * @return String with current time
   */
  public static String getCurrentTime() {
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
    LocalDateTime now = LocalDateTime.now();
    return dtf.format(now);
  }
  /**
   * provides current date
   * usable for ex. logs
   *
   * @return String with current date
   */
  public static String getCurrentDate() {
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    LocalDateTime now = LocalDateTime.now();
    return dtf.format(now);
  }
}
