package org.chess2022.controller;


import org.chess2022.dao.Steps;
import org.chess2022.entity.*;
import org.chess2022.ui.Count;
import org.chess2022.ui.MusicError;
import org.chess2022.ui.MusicPut;
import org.chess2022.ui.User;
import org.chess2022.values.FrameMod;
import org.chess2022.view.ViewManager;

import javax.swing.*;

import static org.chess2022.entity.Chessboard.chessComponents;

public class ClickController {
    public static Chessboard chessboard;
    public static ChessComponent first=null;
    public static ChessComponent a;
    public static ChessComponent b;

    public ClickController(Chessboard chessboard) {
        ClickController.chessboard = chessboard;
    }

    public void onClick(ChessComponent chessComponent) {
        b=chessComponent;
        if (first == null) {
            if (handleFirst(chessComponent)) {
                chessComponent.setSelected(true);
                first = chessComponent;
                first.repaint();
                for (int i = 0; i < first.canMoveToPoints().size(); i++) {
                   chessComponents[first.canMoveToPoints().get(i).getX()][first.canMoveToPoints().get(i).getY()].setSelected(true);
                    chessComponents[first.canMoveToPoints().get(i).getX()][first.canMoveToPoints().get(i).getY()].repaint();
                }
            }
        } else {
            if (first == chessComponent) { // 再次点击取消选取
                chessComponent.setSelected(false);
                for (int i = 0; i < first.canMoveToPoints().size(); i++) {
                    chessComponents[first.canMoveToPoints().get(i).getX()][first.canMoveToPoints().get(i).getY()].setSelected(false);
                    chessComponents[first.canMoveToPoints().get(i).getX()][first.canMoveToPoints().get(i).getY()].repaint();
                }
                ChessComponent recordFirst = first;
                first = null;
                recordFirst.repaint();
            } else if (handleSecond(chessComponent)) {
                //repaint in swap chess method.
                a=first;
                Count.zoule=true;
                for (int i = 0; i < first.canMoveToPoints().size(); i++) {
                    chessComponents[first.canMoveToPoints().get(i).getX()][first.canMoveToPoints().get(i).getY()].setSelected(false);
                    chessComponents[first.canMoveToPoints().get(i).getX()][first.canMoveToPoints().get(i).getY()].repaint();
                }
                chessboard.swapChessComponents(first, chessComponent);
                if (!EndGame.CheckWhiteMate() ) {
                    Steps.step(chessComponents);
                    chessboard.swapColor();
                    if (Chessboard.currentColor == ChessColor.BLACK) {
                        ChessGameFrame.statusLabel.setText("Black Chess Round");
                    } else {
                        ChessGameFrame.statusLabel.setText("White Chess Round");
                    }
//                    ChessGameFrame.addTimeLabel();
                    ChessGameFrame.statusLabel.repaint();
                    first.setSelected(false);
                    first.repaint();
                    first = null;
                    JOptionPane.showMessageDialog(null, "Black Wins", "WIN", 1);
                    ReplayController.Replay();
                }else if(!EndGame.CheckBlackMate()){
                    Steps.step(chessComponents);
                    chessboard.swapColor();
                    if (Chessboard.currentColor == ChessColor.BLACK) {
                        ChessGameFrame.statusLabel.setText("Black Chess Round");
                    } else {
                        ChessGameFrame.statusLabel.setText("White Chess Round");
                    }
//                    ChessGameFrame.addTimeLabel();
                    ChessGameFrame.statusLabel.repaint();
                    first.setSelected(false);
                    first.repaint();
                    first = null;
                    JOptionPane.showMessageDialog(null, "White Wins", "WIN", 1);
                    User.setGrade();
                    ReplayController.Replay();
                }else{
                    chessboard.swapColor();
                    if (Chessboard.currentColor == ChessColor.BLACK) {
                        ChessGameFrame.statusLabel.setText("Black Chess Round");
                    } else {
                        ChessGameFrame.statusLabel.setText("White Chess Round");
                    }
//                    ChessGameFrame.addTimeLabel();
                    ChessGameFrame.statusLabel.repaint();
                    first.setSelected(false);
                    first.repaint();
                    first = null;
                }
            }
        }
    }

    /**
     * @param chessComponent 目标选取的棋子
     * @return 目标选取的棋子是否与棋盘记录的当前行棋方颜色相同
     */

    public static boolean handleFirst(ChessComponent chessComponent) {
        return chessComponent.getChessColor() == chessboard.getCurrentColor();
    }

    /**
     * @param chessComponent first棋子目标移动到的棋子second
     * @return first棋子是否能够移动到second棋子位置
     */

   public static boolean handleSecond(ChessComponent chessComponent) {
        if( chessComponent.getChessColor() != chessboard.getCurrentColor() &&
                first.canMoveTo(chessboard.getChessComponents(), chessComponent.getChessboardPoint())){
            new MusicPut().start();
            return true;
        }else{
            new MusicError().start();
            return false;
        }
    }
    public static boolean drawnGame(){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(chessComponents[i][j].canMoveToPoints().size()!=0){
                    return true;
                }
            }
        }
        return false;
    }

}
