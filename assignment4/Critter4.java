/* CRITTERS Critter4.java
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
 * Ambush refers to Critter4.
 * This method produces a border. In the critter's time step, the border
 * reproduces sideways. The border children from the same parent don't fight each other
 * because borders to the right of the parent produce once to the right, and borders to the
 * left of the parent produce left once.
 */
public class Critter4 extends Critter{

	private boolean right = false;
	private boolean left = false;
	
	/**
	 * Constructor
	 * Initializes the direction of the Ambush
	 */
	public Critter4(){
	}
	
	@Override
	public String toString() { return "4"; }
	

	/**
	 * This method ensures Ambush critters create the longest border possible by utilizing 2
	 * flags. The parent creates 2 Ambush critters to its sides. After that the critter to the
	 * right creates another critter to the right, and the critter to the left does the same in
	 * the left direction. This keeps happening until no more Ambush critters can be produced.
	 */
	@Override
	public void doTimeStep(){
		
		if(right == false && left == false){
			Critter4 ambush1 = new Critter4();
			Critter4 ambush2 = new Critter4();
			
			ambush1.left = true;
			ambush2.right = true;
			
			reproduce(ambush1, 0);
			reproduce(ambush2, 4);
			
			left = true;
			right = true;
		}
		
		else if(right == false){
			Critter4 ambush = new Critter4();
			ambush.left = true;
			reproduce(ambush, 0);
		}
		
		else if(left == false){
			Critter4 ambush = new Critter4();
			ambush.right = true;
			reproduce(ambush, 4);
		}
		
	}
	
	/**
	 * Ambush always wants to fight
	 * @param not_used = passed empty string
	 * @return whether it wants to fight or not
	 */
	public boolean fight(String not_used) { return true; }
	
}
