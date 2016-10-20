package assignment4;

public class Coward extends Critter {

	@Override
	public String toString() { return "Ç"; }
	private int dir;
	
	public Coward() {
		dir = Critter.getRandomInt(8);	//each coward moves in different direction
	}
	
	public boolean fight(String not_used) { run(dir); return false; }

	@Override
	public void doTimeStep() {
		walk(dir);
		if (getEnergy() > Critter.getRandomInt(50)) {	//reproduces randomly (when scared lol)
			Coward child = new Coward();
			reproduce(child, (dir + 4) % 8);	//reproduces behind the parent
		}
	}
}