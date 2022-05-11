//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package noppes.npcs.scripted.interfaces;

import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import noppes.npcs.scripted.interfaces.item.IItemStack;
import noppes.npcs.scripted.item.ScriptItemStack;
import noppes.npcs.scripted.entity.ScriptPlayer;

public interface IContainer {
    int getSize();

    IItemStack getSlot(int var1);

    void setSlot(int slot, IItemStack item);

    IInventory getMCInventory();

    Container getMCContainer();

    int count(IItemStack var1, boolean var2, boolean var3);

    IItemStack[] getItems();

    boolean isCustomGUI();

    void detectAndSendChanges();

    void putStackInSlot(int slot, ScriptItemStack itemStack);

    boolean isPlayerNotUsingContainer(ScriptPlayer player);
}
