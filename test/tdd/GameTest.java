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
	
	@BeforeEach
	public void init() {
		game = new Game();
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
}
