/* CRITTERS Critter1.java
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
 * Jesus refers to Critter1.
 * This Critter subclass reproduces in the shape of a cross, then walks forward as a cross
 * in a unit of 5 (5 Jesus critters walking together). The cross maintains its shape because
 * the main Jesus critter produces 4 other critters only once, and those 4 critters do not
 * reproduce (to maintain the shape of the cross). The critter has the ability to fight.
 */
public class Critter1 extends Critter{
	
	//private int dir;
	private  boolean reborn = false;	//only reproduce if parent, children follow
	
	/**
	 * Constructor
	 * Initializes the direction of the Jesus
	 */
	public Critter1(){
	}
	
	@Override
	public String toString() { return "1"; }
	
	/**
	 * This method produces 4 Jesus critters in 4 directions (top,bot,left,right) and makes
	 * sure neither the parent nor the children can produce again.
	 */
	@Override
	public void doTimeStep(){
		
		walk(2);
		
		if(reborn == false){
			Critter1 jesus1 = new Critter1();
			Critter1 jesus2 = new Critter1();
			Critter1 jesus3 = new Critter1();
			Critter1 jesus4 = new Critter1();
			
			jesus1.reborn = true;
			jesus2.reborn = true;
			jesus3.reborn = true;
			jesus4.reborn = true;
			
			reproduce(jesus1, 0);
			reproduce(jesus2, 2);
			reproduce(jesus3, 4);
			reproduce(jesus4, 6);
			
			reborn = true;
		}
		
	}
	
	/**
	 * Jesus always wants to fight
	 * @param not_used = passed empty string
	 * @return whether it wants to fight or not
	 */
	public boolean fight(String not_used) { return true; }
	
}
