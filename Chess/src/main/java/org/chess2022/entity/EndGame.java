package org.chess2022.entity;

import org.chess2022.controller.ClickController;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class EndGame {
    public static boolean CheckBlackMate() {
        try {
            boolean test = false;
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (Chessboard.chessComponents[i][j].chessColor == ChessColor.WHITE) {
                        assert Chessboard.getBlackKing() != null;
                        if (compare(Chessboard.chessComponents[i][j].canMoveToPoints(), Chessboard.getBlackKing().chessboardPoint)) {
                            test = true;
                            break;
                        }
                    }
                }
            }
            if (test) {
                JOptionPane.showMessageDialog(null, "Black is in check", "Warning", 1);
            }
            return true;
        }catch (Exception e){
            return false;
        }
//        boolean test = false;
//
//        for (int i = 0; i < 8; i++) {
//            for (int j = 0; j < 8; j++) {
//                if (Chessboard.chessComponents[i][j].chessColor == ChessColor.WHITE) {
//                    assert Chessboard.getBlackKing() != null;
//                    if (compare(Chessboard.chessComponents[i][j].canMoveToPoints(),Chessboard.getBlackKing().chessboardPoint)) {
//                        test = true;
//                        break;
//                    }
//                }
//            }
//        }
//        System.out.println(test);
//        System.out.println(Chessboard.getBlackKing().chessboardPoint.toString());
//        if (test) {
//            int number=0;int number1=0;
//            for (int i = 0; i < Chessboard.getBlackKing().canMoveToPoints().size(); i++) {
//                for (int j = 0; j < 8; j++) {
//                    for (int k = 0; k < 8; k++) {
//                        if (Chessboard.chessComponents[j][k].chessColor == ChessColor.WHITE) {
//                            number++;
//                            if (!compare(Chessboard.chessComponents[j][k].canMoveToPoints(),Chessboard.getBlackKing().chessboardPoint)) {
//                               number1++;
//                            }
//                        }
//                    }
//                }
//            }
//            if(number==number1){
//                return true;
//            }
//            return false;
//        } else {
//            return true;
//        }

    }

        public static boolean CheckWhiteMate() {
        try {
            boolean test = false;
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (Chessboard.chessComponents[i][j].chessColor == ChessColor.BLACK) {
                        assert Chessboard.getWhiteKing() != null;
                        if (compare(Chessboard.chessComponents[i][j].canMoveToPoints(), Chessboard.getWhiteKing().chessboardPoint)) {
                            test = true;
                            break;
                        }
                    }
                }
            }
            if (test) {
                JOptionPane.showMessageDialog(null, "White is in check", "Warning", 1);
            }
            return true;
        }catch (Exception e){
                return false;
        }
//        boolean test = false;
//        for (int i = 0; i < 8; i++) {
//            for (int j = 0; j < 8; j++) {
//                if (Chessboard.chessComponents[i][j].chessColor == ChessColor.BLACK) {
//                    assert Chessboard.getWhiteKing() != null;
//                    if (compare(Chessboard.chessComponents[i][j].canMoveToPoints(),Chessboard.getWhiteKing().chessboardPoint)) {
//                        test = true;
//                        break;
//                    }
//                }
//            }
//        }
//        System.out.println(test);
//            System.out.println(Chessboard.getWhiteKing().chessboardPoint.toString());
//        if (test) {
//            int number=0;int number1=0;
//            for (int i = 0; i < Chessboard.getWhiteKing().canMoveToPoints().size(); i++) {
//                for (int j = 0; j < 8; j++) {
//                    for (int k = 0; k < 8; k++) {
//                        if (Chessboard.chessComponents[j][k].chessColor == ChessColor.BLACK) {
//                            number++;
//                            if (!compare(Chessboard.chessComponents[j][k].canMoveToPoints(),Chessboard.getWhiteKing().chessboardPoint)) {
//                               number1++;
//                            }
//                        }
//                    }
//                }
//            }
//            if(number==number1){
//                return true;
//            }
//        } else {
//            return true;
//        }
//        return false;
    }
    public static boolean compare(List<ChessboardPoint> chessboardPoints, ChessboardPoint chessboardPoint){
        for (int i = 0; i < chessboardPoints.size(); i++) {
            if(chessboardPoints.get(i).getX()==chessboardPoint.getX()&&chessboardPoints.get(i).getY()==chessboardPoint.getY()){
                return true;
            }
        }
        return false;
    }

}
