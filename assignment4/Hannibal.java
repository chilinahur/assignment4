package assignment4;

public class Hannibal extends Critter{
	
	private int dir;
	private static boolean res = false;
	
	Hannibal(){
		
	}
	
	@Override
	public String toString() { return "†"; }
	
	@Override
	public void doTimeStep(){
		
		walk(2);
		
		if(res == false){
			Hannibal hannibal1 = new Hannibal();
			Hannibal hannibal2 = new Hannibal();
			Hannibal hannibal3 = new Hannibal();
			Hannibal hannibal4 = new Hannibal();
			
			reproduce(hannibal1, 0);
			reproduce(hannibal2, 2);
			reproduce(hannibal3, 4);
			reproduce(hannibal4, 6);
			
			res = true;
		}
		
	}
	
	public boolean fight(String not_used) { return true; }
	
}
