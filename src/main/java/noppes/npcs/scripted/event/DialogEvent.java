package noppes.npcs.scripted.event;

import cpw.mods.fml.common.eventhandler.Cancelable;
import noppes.npcs.api.entity.IPlayer;
import noppes.npcs.api.event.IDialogEvent;
import noppes.npcs.api.handler.data.IDialog;
import noppes.npcs.constants.EnumScriptType;

public abstract class DialogEvent extends CustomNPCsEvent implements IDialogEvent {
    public final IDialog dialog;
    public final IPlayer player;

    public DialogEvent(IPlayer player, IDialog dialog){
        this.dialog = dialog;
        this.player = player;
    }

    public IPlayer getPlayer() {
        return player;
    }

    public IDialog getDialog() {
        return dialog;
    }

    public String getHookName() {
        return EnumScriptType.DIALOG_EVENT.function;
    }

    @Cancelable
    public static class DialogOpen extends DialogEvent implements IDialogEvent.DialogOpen {
        public DialogOpen(IPlayer player, IDialog dialog) {
            super(player, dialog);
        }

        public String getHookName() {
            return EnumScriptType.DIALOG_OPEN.function;
        }
    }

    @Cancelable
    public static class DialogOption extends DialogEvent implements IDialogEvent.DialogOption {
        private int optionId;

        public DialogOption(IPlayer player, IDialog dialog, int optionId) {
            super(player, dialog);
            this.optionId = optionId;
        }

        public int getOptionId() {
            return this.optionId;
        }

        public void setOptionId(int optionId) {
            this.optionId = optionId;
        }

        public String getHookName() {
            return EnumScriptType.DIALOG_OPTION.function;
        }

    }

    public static class DialogClosed extends DialogEvent implements IDialogEvent.DialogClosed {
        private final int optionId;

        public DialogClosed(IPlayer player, IDialog dialog, int optionId){
            super(player, dialog);
            this.optionId = optionId;
        }

        public int getOptionId() {
            return optionId;
        }

        public String getHookName() {
            return EnumScriptType.DIALOG_CLOSE.function;
        }

    }
}
