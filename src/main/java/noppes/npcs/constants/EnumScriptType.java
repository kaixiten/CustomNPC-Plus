package noppes.npcs.constants;

public enum EnumScriptType {
	INIT("init"),
	TICK("tick"),
	INTERACT("interact"),
	DIALOG("dialog"),
	DAMAGED("damaged"),
	KILLED("killed"),
	ATTACK("attack"),
	TARGET("target"),
	COLLIDE("collide"),
	KILLS("kills"),
	DIALOG_CLOSE("dialogClose"),
	TIMER("timer"),
	TARGET_LOST("targetLost"),
	PROJECTILE_TICK("projectileTick"),
	PROJECTILE_IMPACT("projectileImpact"),

	ATTACKED("attacked"),
	ATTACK_MELEE("meleeAttack"),
	ATTACK_SWING("meleeSwing"),
    RIGHT_CLICK("rightClick"),
	ROLE("role"),
	RANGED_CHARGE("rangedCharge"),
	RANGED_LAUNCHED("rangedLaunched"),
	CLICKED("clicked"),
	FALLEN_UPON("fallenUpon"),
	RAIN_FILLED("rainFilled"),
	BROKEN("broken"),
	HARVESTED("harvested"),
	EXPLODED("exploded"),
	NEIGHBOR_CHANGED("neighborChanged"),
	REDSTONE("redstone"),
	DOOR_TOGGLE("doorToggle"),
	TOSS("toss"),
	DROP("drop"),
	CONTAINER_OPEN("containerOpen"),
	CONTAINER_CLOSED("containerClosed"),
	LOGIN("login"),
	LOGOUT("logout"),
	CHAT("chat"),
	DAMAGED_ENTITY("damagedEntity"),
	SPAWN("spawn"),
	TOSSED("tossed"),
	PICKEDUP("pickedUp"),
	PICKUP("pickUp"),
	LEVEL_UP("levelUp"),
	KEY_PRESSED("keyPressed"),
	QUEST_EVENT("questEvent"),
	QUEST_START("questStart"),
	QUEST_COMPLETED("questCompleted"),
	QUEST_TURNIN("questTurnIn"),
	FACTION_EVENT("factionEvent"),
	FACTION_POINTS("factionPoints"),
	DIALOG_EVENT("dialogEvent"),
	DIALOG_OPEN("dialogOpen"),
	DIALOG_OPTION("dialogOption"),
	CUSTOM_CHEST_CLOSED("customChestClosed"),
	CUSTOM_CHEST_CLICKED("customChestClicked"),
	SCRIPT_COMMAND("scriptCommand"),
	CUSTOM_GUI_EVENT("customGuiEvent"),
	CUSTOM_GUI_CLOSED("customGuiClosed"),
	CUSTOM_GUI_BUTTON("customGuiButton"),
	CUSTOM_GUI_SLOT("customGuiSlot"),
	CUSTOM_GUI_SLOT_CLICKED("customGuiSlotClicked"),
	CUSTOM_GUI_SCROLL("customGuiScroll"),
	CUSTOM_GUI_TEXTFIELD("customGuiTextfield"),
	PICKUP_XP("pickupXP"),
	MOUSE_CLICKED("mouseClicked"),
	START_USING_ITEM("startItem"),
	USING_ITEM("usingItem"),
	STOP_USING_ITEM("stopItem"),
	FINISH_USING_ITEM("finishItem"),
	USE_HOE("useHoe"),
	SLEEP("sleep"),
	WAKE_UP("wakeUp"),
	FILL_BUCKET("fillBucket"),
	BONEMEAL("bonemeal"),
	ACHIEVEMENT("achievement"),
	FALL("fall"),
	JUMP("jump"),
	LIGHTNING("lightning"),
	PLAYSOUND("playSound"),
	RESPAWN("respawn"),
	CHANGED_DIM("changedDim"),
	BREAK_BLOCK("breakBlock"),
	FORGE_EVENT("forgeEvent"),
	FORGE_INIT("forgeInit"),
	FORGE_ENTITY("forgeEntity"),
	FORGE_WORLD("forgeWorld"),
	CNPC_NATURAL_SPAWN("onCNPCNaturalSpawn"),
	CUSTOM_ITEM_EVENT("customItemEvent"),

    PARTY_EVENT("partyEvent"),
    PARTY_QUEST_COMPLETED("partyQuestCompleted"),
    PARTY_QUEST_SET("partyQuestSet"),
    PARTY_QUEST_TURNED_IN("partyQuestTurnedIn"),
    PARTY_INVITE("partyInvite"),
    PARTY_KICK("partyKick"),
    PARTY_LEAVE("partyLeave"),
    PARTY_DISBAND("partyDisband"),

    ANIMATION_START("animationStart"),
    ANIMATION_END("animationEnd"),
    ANIMATION_FRAME_ENTER("frameEnter"),
    ANIMATION_FRAME_EXIT("frameExit");

	public String function;

	public static EnumScriptType valueOfIgnoreCase(String channelName) {
		channelName = channelName.toUpperCase();
        try {
            return valueOf(channelName);
        } catch (IllegalArgumentException exception) {
            for (EnumScriptType value : EnumScriptType.values()) {
                if (value.function.toUpperCase().equals(channelName)) {
                    return value;
                }
            }
            throw exception;
        }
	}

	private EnumScriptType(String function) {
		this.function = function;
	}
}
