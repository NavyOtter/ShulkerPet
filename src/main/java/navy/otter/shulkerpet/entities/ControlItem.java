package navy.otter.shulkerpet.entities;

import java.util.List;
import navy.otter.shulkerpet.config.Configuration;
import navy.otter.shulkerpet.ShulkerPetPlugin;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ControlItem {

  private static Configuration config = ShulkerPetPlugin.getConfiguration();
  private static Material ciMaterial = config.getControlItemMaterial();
  private static Enchantment enchantment = Enchantment.MENDING;

  public static ItemStack createControlItem() {
    ItemStack ciItem = new ItemStack(ciMaterial, 1);
    ItemMeta ciMeta = ciItem.getItemMeta();
    List<String> ciLore = config.getControlItemLore();
    ciMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "ShulkerPet-Zepter");
    ciMeta.setLore(ciLore);
    ciMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
    ciItem.setItemMeta(ciMeta);
    ciItem.addUnsafeEnchantment(enchantment, 1);

    return ciItem;
  }
}
