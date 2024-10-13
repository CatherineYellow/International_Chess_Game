package org.chess2022.controller;

import org.chess2022.dao.Steps;
import org.chess2022.entity.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.chess2022.entity.ChessGameFrame;


public class RegretController implements ActionListener {

    ChessGameFrame frame;

    public RegretController(ChessGameFrame frame){
        this.frame=frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ChessGameFrame.panel.removeAll();
        Chessboard chessboard = new Chessboard(ChessGameFrame.CHESSBOARD_SIZE,ChessGameFrame.CHESSBOARD_SIZE);
        ChessGameFrame.gameController=new GameController(chessboard);
        chessboard.setLocation(ChessGameFrame.height / 10, ChessGameFrame.height / 10);
        try {
            chessboard.initSavedChessboard(Steps.saveList.get(Steps.saveList.size()-1));
            Steps.saveList.remove(Steps.saveList.size()-1);
        }catch (Exception x){
            ChessGameFrame.panel.add(chessboard);
            chessboard.repaint();
            ChessGameFrame.panel.repaint();
            frame.addLabel();
            frame.addRestartButton();
            frame.addTimeLabel();
            frame.addLoadButton();
            frame.addBackGroundButton();
            frame.addAttributesButton();
            frame.addRegretButton();
            chessboard.swapColor();
            System.out.println(Steps.saveList.size());
            if(Chessboard.currentColor== ChessColor.BLACK) {
                ChessGameFrame.statusLabel.setText("Black Chess Round");
            }else{
                ChessGameFrame.statusLabel.setText("White Chess Round");
            }
            frame.repaint();
            ChessGameFrame.panel.repaint();
        }
        ChessGameFrame.panel.add(chessboard);
        chessboard.repaint();
        ChessGameFrame.panel.repaint();
        frame.addLabel();
        frame.addBackGroundButton();
        frame.addAttributesButton();
        frame.addTimeLabel();
        frame.addRestartButton();
        frame.addLoadButton();
        frame.addRegretButton();
        frame.addSaveButton();
        chessboard.swapColor();
        if(Chessboard.currentColor== ChessColor.BLACK) {
            ChessGameFrame.statusLabel.setText("Black Chess Round");
        }else{
            ChessGameFrame.statusLabel.setText("White Chess Round");
        }
        frame.repaint();
        ChessGameFrame.panel.repaint();
    }
}
