package org.chess2022.controller;

import org.chess2022.entity.ChessColor;
import org.chess2022.entity.ChessGameFrame;
import org.chess2022.entity.Chessboard;
import org.chess2022.ui.Count;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RestartController implements ActionListener {

    public ChessGameFrame frame;

    public RestartController(ChessGameFrame frame){
        this.frame=frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ChessGameFrame.panel.removeAll();
        Chessboard.currentColor= ChessColor.WHITE;
        frame.addChessboard();
        frame.addLabel();
        frame.addTimeLabel();
        frame.addRestartButton();
        frame.addLoadButton();
        frame.addRegretButton();
        frame.addSaveButton();
        frame.addBackGroundButton();
        frame.addAttributesButton();
        frame.repaint();
        ChessGameFrame.panel.repaint();
    }
}
