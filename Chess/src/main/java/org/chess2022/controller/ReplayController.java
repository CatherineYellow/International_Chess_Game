package org.chess2022.controller;

import org.chess2022.dao.Steps;
import org.chess2022.entity.ChessColor;
import org.chess2022.entity.ChessGameFrame;
import org.chess2022.entity.Chessboard;
import org.chess2022.view.ViewManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static org.chess2022.controller.ClickController.chessboard;

public class ReplayController implements ActionListener {

    public static ChessGameFrame frame;
    public static int i=1;

    public ReplayController(ChessGameFrame frame){
        ReplayController.frame =frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            chessboard.initSavedChessboard(Steps.saveList.get(i));
            Steps.saveList.remove(i);
            chessboard.repaint();
        }catch (Exception x){
        }
    }
    public static void Replay(){
        ViewManager.framenow.panel.removeAll();
        Chessboard.currentColor= ChessColor.WHITE;
        ViewManager.framenow.addChessboard();
        ViewManager.framenow.addLabel();
        ViewManager.framenow.addRestartButton();
        ViewManager.framenow.addReplaysButton();
        ViewManager.framenow.repaint();
        ViewManager.framenow.panel.repaint();
    }
}

