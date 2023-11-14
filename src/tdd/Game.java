package tdd;

public class Game {
	
	private int ipartie = 0;
	private int[] partie = {1,2,3,4,5,6,7,8,9,10};
	private int[] scores = new int[10];
	private boolean spare = false;
	
	public void roll(int nb) {
		if (ipartie % 2 == 1) {
			scores[(ipartie-1)/2]+=nb;
		} else {
			spare = (ipartie/2 >= 1 && scores[(ipartie/2)-1] == 10);
			if (spare) {
				scores[ipartie/2]+=nb;
				scores[(ipartie/2)-1]+=nb;
				spare = false;
			} else {
				scores[ipartie/2]+=nb;
			}
		}
		ipartie ++;
	}
	
	public int score() {
		int scoreFinal = 0;
		for (int i = 0; i<partie.length; i++) {
			System.out.println("score "+i+":"+scores[i]);
			scoreFinal += scores[i];
		}
		return scoreFinal;
	}
}