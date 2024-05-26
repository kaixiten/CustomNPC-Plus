package noppes.npcs;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;

public class ElementResistances {

	public float one = 1f;
	public float two = 1f;
	public float three = 1f;
	public float four = 1f;
    public float five = 1f;
    public float six = 1f;

	public NBTTagCompound writeToNBT() {
		NBTTagCompound compound = new NBTTagCompound();

        NBTTagCompound resistance = new NBTTagCompound();
        resistance.setFloat("One", one);
        resistance.setFloat("Two", two);
        resistance.setFloat("Three", three);
        resistance.setFloat("Four", four);
        resistance.setFloat("Five", five);
        resistance.setFloat("Six", six);

        compound.setTag("ElementResistance", resistance);
		return compound;
	}

	public void readToNBT(NBTTagCompound compound) {

        NBTTagCompound resistance = compound.getCompoundTag("ElementResistance");

		one = resistance.getFloat("One");
		two = resistance.getFloat("Two");
		three = resistance.getFloat("Three");
		four = resistance.getFloat("Four");
        five = resistance.getFloat("Five");
        six = resistance.getFloat("Six");
	}

	public float applyResistance(DamageSource source, float damage) {

		if(source.damageType.equals("arrow") || source.damageType.equals("thrown")){
			damage *= (2 - two);
		}
		else if(source.damageType.equals("player") || source.damageType.equals("mob")){
			damage *= (2 - three);
		}
		else if(source.damageType.equals("explosion") || source.damageType.equals("explosion.player")){
			damage *= (2 - four);
		}

		return damage;
	}

}
