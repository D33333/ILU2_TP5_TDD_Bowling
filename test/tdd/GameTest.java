package tdd;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class GameTest {
	
	Game game;
	
	private void lancer(int nbLancers, int valeurObtenue) {
		for (int i = 0; i < nbLancers; i++) {
			game.roll(valeurObtenue);
		}
	}
	
	private void lancer_en_chaine(int[] lancers) {
		for (int lancer : lancers) {
			game.roll(lancer);
		}
	}
	
	@BeforeEach
	public void init() {
		game = new Game();
		System.out.println("Initialisation...");
	}

	@Test
	public void test_pas_de_jeu() {
		assertEquals(game.score(),0);
	}
	
	@Test
	public void test_aucune_quille() {
		lancer(20,0);
		assertEquals(game.score(),0);
	}
	
	@Test
	public void test_en_1_fois() {
		lancer(20,1);
		assertEquals(game.score(),20);
	}
	
	@Test
	public void test_en_2_fois() {
		lancer(10,1);
		lancer(10,2);
		assertEquals(game.score(),30);
	}
	
	@Test
	public void test_spare() {
		lancer(1,7);
		lancer(1,3);
		lancer(1,4);
		lancer(17,0);
		assertEquals(game.score(),18);
	}
	
	@Test
	public void test_strike() {
		lancer(1,10);
		lancer(1,3);
		lancer(1,4);
		lancer(16,0);
		assertEquals(game.score(),24);
	}
	
	@Test
	public void test_général() {
		int[] lancers = new int[] {1,2,10,0,10,4,2,0,10,6,2,0,10,6,4,8,2,2,7};
		lancer_en_chaine(lancers);
		assertEquals(game.score(),122);
	}
	
	@Test
	public void test_extension() {
		int[] lancers = new int[] {1,2,10,0,10,4,2,0,10,6,2,0,10,6,4,8,2,2,8,8};
		lancer_en_chaine(lancers);
		assertEquals(game.score(),131);
	}
	
	@Test
	public void test_genie() {
		lancer(12,10);
		assertEquals(game.score(),300);		
	}
}
