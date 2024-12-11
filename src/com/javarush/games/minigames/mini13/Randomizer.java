package com.javarush.games.minigames.mini13;

import com.javarush.engine.cell.Color;
import com.javarush.engine.cell.Game;

/* 
Рандомайзер
*/

public class Randomizer extends Game {
    @Override
    public void initialize() {
        setScreenSize(3, 3);
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                setCellColor(x, y, Color.WHITE);
            }
        }
        setTurnTimer(1000);
    }

    @Override
    public void onTurn(int step) {
        //  1 вариант
//        int rndNum = getRandomNumber(100);
//        setCellNumber(1, 1, rndNum);

        //  2 вариант
        setCellNumber(1, 1, getRandomNumber(100));
    }
}
