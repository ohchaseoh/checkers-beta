package com.example.checkers.alpha.offline;

import com.example.checkers.alpha.offline.GameConfig;
import com.example.checkers.alpha.offline.GamePlayerType;
import java.util.ArrayList;

/**
 * Creates the default configuration for the game, the local game controlling the entire game
 * @authors Alex, Chase, Mohammad
 */
public class CheckersMainActivity extends GameMainActivity{

    private static final int PORT_NUMBER = 2278;
    @Override
    public GameConfig createDefaultConfig() {
        //Define the allowed player typed
        ArrayList<GamePlayerType> playerTypes = new ArrayList<>();

        playerTypes.add(new GamePlayerType("Human (Local)") {
            @Override
            public GamePlayer createPlayer(String name) {
                return new CheckersHumanPlayer(name);
            }
        });

        playerTypes.add(new GamePlayerType("Computer (Dumb)") {
            @Override
            public GamePlayer createPlayer(String name) {
                return new CheckersComputerPlayer(name, false);
            }
        });

        playerTypes.add(new GamePlayerType("Computer (Smart)") {
            @Override
            public GamePlayer createPlayer(String name) {
                return new CheckersComputerPlayer(name, true);
            }
        });


        //Create the game configuration object with the max and min number of players
        //and the game name and add the default players to it
        GameConfig defaultConfig = new GameConfig(playerTypes, 1,
                CheckersGameState.MAX_PLAYERS, "Checkers", PORT_NUMBER);

        defaultConfig.addPlayer("Joe", 0);
        defaultConfig.addPlayer("Goofy", 1);
        return defaultConfig;
    }

    @Override
    public LocalGame createLocalGame(GameState gameState) {
        return new CheckersLocalGame();
    }
}
