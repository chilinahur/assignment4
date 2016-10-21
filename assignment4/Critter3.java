/* CRITTERS Critter3.java
 * EE422C Project 4 submission by
 * Sriram Chilukuri
 * smc4474
 * 16445
 * Yousef Abdelrazzaq
 * Yja87
 * 16445
 * Slip days used: <0>
 * Fall 2016
 */

package assignment4;

/**
 * Satan refers to Critter3.
 * This Critter subclass runs then reproduces when energy is greater than 66 but only when
 * its parent opens the gates of Hell (every six turns).
 */
public class Critter3 extends Critter {

	@Override
	public String toString() { return "3"; }
	private int numberTurns = 1;	//Hell's doors only open every six turns with double the vigor
	private int dir;
	
	/**
	 * Constructor
	 * Initializes the direction of the Satan
	 */
	public Critter3() {
		dir = Critter.getRandomInt(8);	//each Satan moves in different direction to commit most damage
	}
	
	/**
	 * Satan always wants to fight
	 * @param not_used = passed empty string
	 * @return whether it wants to fight or not
	 */
	public boolean fight(String not_used) { return true; }

	/**
	 * Satan runs in the initialized direction and 
	 * reproduces when energy is greater than 66 and only every 6 turns.
	 * Baby is pooped out behind parent.
	 */
	@Override
	public void doTimeStep() {
		run(dir);
		if (getEnergy() > 66 && numberTurns % 6 == 0) {	//reproduces @ energy>66 and numberTurns=multiple of 6
			Critter3 child = new Critter3();
			reproduce(child, (dir + 4) % 8);	//reproduces behind the parent
		}
		numberTurns++;
	}
}