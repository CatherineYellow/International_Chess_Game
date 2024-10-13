package org.chess2022.dao;

import org.chess2022.entity.ChessComponent;

import java.util.ArrayList;
import java.util.Stack;

public class Steps {
    public static ArrayList<ChessComponent[][]> saveList = new ArrayList<>();

    public static void step(ChessComponent[][] chessboard) {
        ChessComponent[][] saving = new ChessComponent[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                saving[i][j] = chessboard[i][j];
            }
        }
        saveList.add(saving);
    }
}
