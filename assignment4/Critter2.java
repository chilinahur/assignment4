/* CRITTERS Critter2.java
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
 * Coward refers to Critter2.
 * This Critter subclass walks forward and reproduces randomly behind it.
 * The critter always avoids fighting.
 */
public class Critter2 extends Critter {

	@Override
	public String toString() { return "2"; }
	private int dir;
	
	/**
	 * Constructor
	 * Initializes the direction of the Coward
	 */
	public Critter2() {
		dir = Critter.getRandomInt(8);	//each coward moves in different direction
	}
	
	/**
	 * Coward tries to run away and never wants to fight
	 * @param not_used = passed empty string
	 * @return whether it wants to fight or not
	 */
	public boolean fight(String not_used) { run(dir); return false; }

	/**
	 * Coward walks in the initialized direction and 
	 * reproduces fairly randomly.
	 * Baby is pooped out behind parent.
	 */
	@Override
	public void doTimeStep() {
		walk(dir);
		if (getEnergy() > Critter.getRandomInt(50)) {	//reproduces randomly (when scared lol)
			Critter2 child = new Critter2();
			reproduce(child, (dir + 4) % 8);	//reproduces behind the parent
		}
	}
}