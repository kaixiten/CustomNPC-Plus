package noppes.npcs.client.gui.script;

import net.minecraft.nbt.NBTTagCompound;
import noppes.npcs.NBTTags;
import noppes.npcs.client.Client;
import noppes.npcs.constants.EnumPacketServer;
import noppes.npcs.controllers.ScriptContainer;
import noppes.npcs.controllers.data.GlobalNPCDataScript;

import java.util.List;

public class GuiScriptAllNPCs extends GuiScriptInterface {
    private GlobalNPCDataScript script = new GlobalNPCDataScript(null);

    public GuiScriptAllNPCs() {
        hookList.add("init");
        hookList.add("tick");
        hookList.add("interact");
        hookList.add("dialog");
        hookList.add("damaged");
        hookList.add("killed");
        hookList.add("meleeAttack");
        hookList.add("meleeSwing");
        hookList.add("rangedLaunched");
        hookList.add("target");
        hookList.add("collide");
        hookList.add("kills");
        hookList.add("dialogClose");
        hookList.add("timer");
        hookList.add("targetLost");
        hookList.add("projectileTick");
        hookList.add("projectileImpact");
        hookList.add("animationStart");
        hookList.add("animationEnd");
        hookList.add("frameEnter");
        hookList.add("frameExit");

        this.handler = this.script;
        Client.sendData(EnumPacketServer.ScriptGlobalNPCGet);
    }

    public void setGuiData(NBTTagCompound compound) {
        if (!compound.hasKey("Tab")) {
            script.setLanguage(compound.getString("ScriptLanguage"));
            script.setEnabled(compound.getBoolean("ScriptEnabled"));
            super.setGuiData(compound);
        } else {
            int tab = compound.getInteger("Tab");
            ScriptContainer container = new ScriptContainer(script);
            container.readFromNBT(compound.getCompoundTag("Script"));
            if (script.getScripts().isEmpty()) {
                for (int i = 0; i < compound.getInteger("TotalScripts"); i++) {
                    script.getScripts().add(new ScriptContainer(script));
                }
            }
            script.getScripts().set(tab,container);
            initGui();
        }
    }

    public void save() {
        super.save();
        List<ScriptContainer> containers = this.script.getScripts();
        for (int i = 0; i < containers.size(); i++) {
            ScriptContainer container = containers.get(i);
            Client.sendData(EnumPacketServer.ScriptGlobalNPCSave, i, containers.size(), container.writeToNBT(new NBTTagCompound()));
        }
        NBTTagCompound scriptData = new NBTTagCompound();
        scriptData.setString("ScriptLanguage", this.script.getLanguage());
        scriptData.setBoolean("ScriptEnabled", this.script.getEnabled());
        scriptData.setTag("ScriptConsole", NBTTags.NBTLongStringMap(this.script.getConsoleText()));
        Client.sendData(EnumPacketServer.ScriptGlobalNPCSave, -1, containers.size(), scriptData);
    }
}
