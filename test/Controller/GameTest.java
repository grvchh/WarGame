/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Controller;

import Controller.Game;
import Model.Card;
import Model.Player;
import Model.Rank;
import Model.Suit;
import java.util.LinkedList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author kaush
 */
public class GameTest {
    
    private Game game;

    @Before
    public void setUp() {
        LinkedList<Card> deck1 = new LinkedList<>();
        LinkedList<Card> deck2 = new LinkedList<>();

        // You can add dummy cards if needed for testing
        // Example:
//         



























































































































































.

        game = new Game("Alice", "Bob", deck1, deck2);
    }

    @Test
    public void testPlayersInitializedCorrectly() {
        List<Player> players = game.getPlayers();
        assertEquals(2, players.size());
        assertEquals("Alice", players.get(0).getName());
        assertEquals("Bob", players.get(1).getName());
    }

    @Test
    public void testDeckDistributedEqually() {
        List<Player> players = game.getPlayers();
        int totalCards = players.get(0).getCardCount() + players.get(1).getCardCount();
        assertEquals("Total cards should be 52", 52, totalCards);
        assertEquals("Players should have equal cards", players.get(0).getCardCount(), players.get(1).getCardCount());

    }

    @Test
    public void testDrawCardReducesCardCount() {
        Player player = game.getPlayers().get(0);
        int before = player.getCardCount();
        Card drawnCard = player.playCard();
        int after = player.getCardCount();

        assertNotNull(drawnCard);
        assertEquals("Card count should decrease after drawing", before - 1, after);

    }

    @Test
    public void testGameNotOverImmediately() {
        assertFalse("Game should not be over at the start", game.isGameOver());

    }
}
