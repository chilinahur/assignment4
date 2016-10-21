package assignment4;

public class Ambush extends Critter{

	private int dir;
	private boolean right = false;
	private boolean left = false;
	
	Ambush(){
		
	}
	
	@Override
	public String toString() { return "="; }
	
	@Override
	public void doTimeStep(){
		
		if(right == false && left == false){
			Ambush ambush1 = new Ambush();
			Ambush ambush2 = new Ambush();
			
			ambush1.left = true;
			ambush2.right = true;
			
			reproduce(ambush1, 0);
			reproduce(ambush2, 4);
			
			left = true;
			right = true;
		}
		
		else if(right == false){
			Ambush ambush = new Ambush();
			ambush.left = true;
			reproduce(ambush, 0);
		}
		
		else if(left == false){
			Ambush ambush = new Ambush();
			ambush.right = true;
			reproduce(ambush, 4);
		}
		
	}
	
	public boolean fight(String not_used) { return true; }
	
}
