package tdd;

public class Game {
	
	private int ipartie = 0;
	private int[] scores = new int[21];
	
	public void roll(int nb) {
		scores[ipartie] = nb;
		ipartie++;
	}
	
	public int score() {
		int scoreFinal = 0;
		int partie = 0;
		for (int i = 0; i < 10; i++) {
			scoreFinal += scores[partie] + scores[partie+1];
			if (isStrike(partie)) {
				scoreFinal += scores[partie+2];
				partie++;
			} else if (isSpare(partie)) {
				scoreFinal += scores[partie+2];
				partie += 2;
			} else {				
				partie += 2;
			}
		}
		return scoreFinal;
	}

	private boolean isStrike(int partie) {
		return scores[partie] == 10;
	}
	
	private boolean isSpare(int partie) {
		return scores[partie] + scores[partie+1] == 10;
	}
}