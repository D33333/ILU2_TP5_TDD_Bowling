package tdd;

public class Game {
	
	private int nbPoints = 0;
	
	public void roll(int nb) {
		nbPoints+=nb;
	}
	
	public int score() {
		return nbPoints;
	}
}