package me.johanneslosch.shins.util;

import me.johanneslosch.shins.Initialisation;
import me.johanneslosch.shins.data.Logger;
import me.johanneslosch.shins.data.files.FileHelper;
import me.johanneslosch.shins.data.files.ReadFile;
import me.johanneslosch.shins.data.files.WriteFile;
import me.johanneslosch.shins.data.files.config.ConfigReader;

import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.ExecutionException;

public class Setup {
  private static boolean isFirstStartup() {
    return !FileHelper.checkFile("data", "firstRun", "dat") ||
        !Objects.requireNonNull(ReadFile.read("data", "firstRun", "dat"))
             .contains("false");
  }

  public static void setup() {
    if (isFirstStartup()) {
      Logger.msg("Init first Startup ...");

      if (ConfigReader.read("data", "credentials", "BRIDGE_URL") == null){
        Initialisation.getHubIP();
      }

      if(ConfigReader.read("data", "credentials", "BRIDGE_TOKEN") == null){
        try {
          Initialisation.getBridgeToken();
        } catch (ExecutionException | InterruptedException e) {
          e.printStackTrace();
        }
      }

      WriteFile.writer("data", "firstRun", "dat", "false");
    }
  }
}
