import java.util.ArrayList;

public class Game {

    ArrayList<Player> registeredPlayers = new ArrayList<>();

    public void register(Player player) {
        registeredPlayers.add(player);
    }

    public int round (String playerName1, String playerName2) throws NotRegisteredException {
        Player player1 = findByName(playerName1);
        if (player1 == null) {
           throw new NotRegisteredException();
        }

        Player player2 = findByName(playerName2);
        if (player2 == null) {
            throw new NotRegisteredException();
        }

        if (player1.strength < player2.strength) {
            return 2;
        } else if (player1.strength > player2.strength) {
            return 1;
        }
        return 0;
    }

    public Player findByName (String name) {
        for (Player player: registeredPlayers) {
            if (player.name == name) {
                return player;
            }
        }
        return null;
    }
}
