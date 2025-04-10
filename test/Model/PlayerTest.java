/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Model;

import java.util.LinkedList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author kaush
 */
public class PlayerTest {
    
    private Player instance;

    
    @Before
    public void setUp() {
        LinkedList<Card> testDeck = new LinkedList<>();
        instance = new Player("TestPlayer", testDeck); // Assuming Player has a constructor like Player(String name)
    }

    @After
    public void tearDown() {
        instance = null;
    }

    @Test
    public void testGetName() {
        System.out.println("getName");
        String expResult = "TestPlayer";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetDeckSize() {
        System.out.println("getDeckSize");
        int result = instance.getDeckSize();
        assertEquals(0, result); // or whatever initial deck size is
    }

    @Test
    public void testHasLost() {
        System.out.println("hasLost");
        boolean result = instance.hasLost();
        assertTrue(result); // If empty deck means lost
    }

    @Test
    public void testPlayCard() {
        System.out.println("playCard");
        instance.winCards(List.of(new Card(2, "Hearts")));  // Fixed here
        Card result = instance.playCard();
        assertNotNull(result);
    }

    @Test
    public void testWinCards() {
        System.out.println("winCards");
        List<Card> cards = List.of(
            new Card(5, "Hearts"),
            new Card(3, "Spades")
        );
        instance.winCards(cards); // Assuming winCards(List<Card>) or overload
        assertEquals(2, instance.getCardCount());
    }

    @Test
    public void testGetCardCount() {
        System.out.println("getCardCount");
        assertEquals(0, instance.getCardCount());
    }

    @Test
    public void testCanContinueWar() {
        System.out.println("canContinueWar");
        boolean result = instance.canContinueWar();
        assertFalse(result); // Assuming false when no cards are present
    }

    @Test
    public void testPlayWarCards() {
        System.out.println("playWarCards");
        instance.winCards(new Card[]{new Card("Hearts", 10), new Card("Clubs", 9), new Card("Diamonds", 8)});
        List<Card> warCards = instance.playWarCards();
        assertEquals(3, warCards.size());
    }
    
}
