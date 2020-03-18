package navy.otter.shulkerpet;

import navy.otter.shulkerpet.commands.ShulkerPetCommand;
import navy.otter.shulkerpet.config.Configuration;
import navy.otter.shulkerpet.listener.BlockRightClickListener;
import navy.otter.shulkerpet.listener.ShulkerRightClickListener;
import navy.otter.shulkerpet.listener.ShulkerTargetingListener;
import navy.otter.shulkerpet.util.ShulkerTeleportThread;
import navy.otter.shulkerpet.worker.ShulkerPetManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class ShulkerPetPlugin extends JavaPlugin {

  private static ShulkerPetPlugin instance;
  public static Configuration config;
  public ShulkerPetManager spManager;

  @Override
  public void onEnable() {
    config = new Configuration(this);
    spManager = new ShulkerPetManager();
    instance = this;
    getCommand("shulkerpet").setExecutor(new ShulkerPetCommand());
    getServer().getPluginManager().registerEvents(new ShulkerRightClickListener(), this);
    getServer().getPluginManager().registerEvents(new BlockRightClickListener(), this);
    getServer().getPluginManager().registerEvents(new ShulkerTargetingListener(), this);

    Bukkit.getScheduler().runTaskTimerAsynchronously(this, new ShulkerTeleportThread(), 0L,
        (config.getCheckDelay() * 20));
  }

  @Override
  public void onDisable() {
    instance = null;
  }

  public static ShulkerPetPlugin getMainInstance() {
    return instance;
  }

  public static Configuration getConfiguration() {
    return config;
  }

  public ShulkerPetManager getSpManager() {
    return spManager;
  }
}

