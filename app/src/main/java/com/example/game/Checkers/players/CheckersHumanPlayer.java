package com.example.game.Checkers.players;

import com.example.game.GameFramework.GameMainActivity;
import com.example.game.GameFramework.info.GameInfo;
import com.example.game.GameFramework.players.GameHumanPlayer;

import android.view.View;

public class CheckersHumanPlayer extends GameHumanPlayer {
    /**
     * Creates a new human player with the specified name
     *
     * @param name the name of the player to crate
     */
    public CheckersHumanPlayer(String name) {
        super(name);
    }

    @Override
    public View getTopView() {
        return null;
    }

    @Override
    public void receiveInfo(GameInfo info) {

    }

    @Override
    public void setAsGui(GameMainActivity activity) {

    }
}