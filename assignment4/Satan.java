package assignment4;

public class Satan extends Critter {

	@Override
	public String toString() { return "§"; }
	private int numberTurns = 1;	//Hell's doors only open every six turns with double the vigor
	private int dir;
	
	public Satan() {
		dir = Critter.getRandomInt(8);	//each satan moves in different direction to commit most damage
	}
	
	public boolean fight(String not_used) { return true; }

	@Override
	public void doTimeStep() {
		run(dir);
		if (getEnergy() > 66 && numberTurns % 6 == 0) {	//reproduces @ energy>66 and numberTurns=multiple of 6
			Satan child = new Satan();
			reproduce(child, (dir + 4) % 8);	//reproduces behind the parent
		}
		numberTurns++;
	}
}