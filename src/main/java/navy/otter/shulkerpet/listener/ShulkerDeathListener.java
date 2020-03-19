package navy.otter.shulkerpet.listener;

import java.util.HashMap;
import java.util.UUID;
import navy.otter.shulkerpet.ShulkerPetPlugin;
import navy.otter.shulkerpet.config.Configuration;
import navy.otter.shulkerpet.entities.ShulkerPet;
import navy.otter.shulkerpet.worker.ShulkerPetManager;
import org.apache.commons.lang.ObjectUtils.Null;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Shulker;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class ShulkerDeathListener implements Listener {

  HashMap<UUID, ShulkerPet> shulkerMap = ShulkerPetManager.getShulkerMap();
  static Configuration config = ShulkerPetPlugin.getConfiguration();

  @EventHandler
  public void onEntityDeathEvent(EntityDeathEvent e) {
    Entity entity = e.getEntity();
    if(!(entity instanceof Shulker)) {
      return;
    }
    Shulker shulker = (Shulker) entity;
    ShulkerPet sp = shulkerMap.get(shulker.getUniqueId());
    Player player = Bukkit.getPlayer(sp.getOwnerUuid());
    if(player != null && player.isOnline()) {
      player.sendMessage(config.getShulkerDeathMsg());
    }
    shulkerMap.remove(shulker.getUniqueId());
  }

}
