import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    @Test
    public void registerTest() {
        Game game = new Game();
        Player player1 = new Player(5, "Player1", 125);

        game.register(player1);
        //game.register(player2);
        Player actual = game.findByName("Player1");
        Assertions.assertEquals(player1, actual);
    }

    @Test
    public void roundTest() {
        Game game = new Game();
        Player player1 = new Player(5, "Player1", 125);
        Player player2 = new Player(9, "Player2", 99);
        Player player3 = new Player(5, "Player3", 125);

        game.register(player1);
        game.register(player2);
        game.register(player3);

        try {
            int actual = game.round(player1.name, player3.name);
            Assertions.assertEquals(0, actual);
        } catch (NotRegisteredException e) {
        }

        try {
            int actual = game.round(player1.name, player2.name);
            Assertions.assertEquals(1, actual);
        } catch (NotRegisteredException e) {
        }
        try {
            int actual = game.round(player2.name, player3.name);
            Assertions.assertEquals(2, actual);
        } catch (NotRegisteredException e) {
        }


        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("player4", player3.name);
        });
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round(player3.name, "player4");
        });

    }



}
