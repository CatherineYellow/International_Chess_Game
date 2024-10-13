package org.chess2022.controller;
import org.chess2022.dao.Steps;
import org.chess2022.entity.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import org.chess2022.entity.ChessGameFrame;
import org.chess2022.values.FrameMod;
import org.chess2022.view.ViewManager;

import javax.swing.*;

import static org.chess2022.frame.ErrorFrame.errorLabel;

//import static org.chess2022.frame.LevelFrame.errorLabel;

public class LoadController implements ActionListener {

    ChessGameFrame frame;

    public LoadController(ChessGameFrame frame){
        this.frame=frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        frame.panel.removeAll();
        Chessboard chessboard = new Chessboard(ChessGameFrame.CHESSBOARD_SIZE,ChessGameFrame.CHESSBOARD_SIZE);
        ChessGameFrame.gameController=new GameController(chessboard);
        chessboard.setLocation(ChessGameFrame.height / 10, ChessGameFrame.height / 10);
        try {
            JFileChooser fileChooser = new JFileChooser();
            File file = null;
            fileChooser.setDialogTitle("Choose file");
            File currentDirectory = new File("C:\\Users\\lxq\\IdeaProjects\\Chess_2022");
            fileChooser.setCurrentDirectory(currentDirectory);
            int result = fileChooser.showOpenDialog(frame);
            if (result == JFileChooser.APPROVE_OPTION) {
                file = fileChooser.getSelectedFile();
            }else{
                frame.panel.removeAll();
                frame.addChessboard();
                frame.addLabel();
                frame.addRestartButton();
                frame.addLoadButton();
                frame.addRegretButton();
                frame.addBackGroundButton();
                frame.addTimeLabel();
                frame.addAttributesButton();
                frame.addSaveButton();
                chessboard.swapColor();
                if(Chessboard.currentColor== ChessColor.BLACK) {
                    ChessGameFrame.statusLabel.setText("Black Chess Round");
                }else{
                    ChessGameFrame.statusLabel.setText("White Chess Round");
                }
                frame.repaint();
                frame.panel.repaint();
                throw new Exception();
            }
            BufferedReader bufferedReader = null;
            InputStreamReader read = null;
            if (file.isFile() && file.exists()) { //判断文件是否存在
                if(!file.getName().endsWith(".txt")) {
                    frame.panel.removeAll();
                    frame.addChessboard();
                    frame.addLabel();
                    frame.addRestartButton();
                    frame.addBackGroundButton();
                    frame.addTimeLabel();
                    frame.addAttributesButton();
                    frame.addLoadButton();
                    frame.addRegretButton();
                    frame.addSaveButton();
                   Chessboard.currentColor=ChessColor.BLACK;
                    if(Chessboard.currentColor== ChessColor.BLACK) {
                        ChessGameFrame.statusLabel.setText("Black Chess Round");
                    }else{
                        ChessGameFrame.statusLabel.setText("White Chess Round");
                    }
                    frame.repaint();
                    frame.panel.repaint();
                    throw new Exception("Error Code:104");
                }
                read = new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8);
                bufferedReader = new BufferedReader(read);
                chessboard.initiateEmptyChessboard();
                for (int i = 0; i < 8; i++) {
                    String chess = bufferedReader.readLine();
                    if(chess.length()!=8){
                        frame.panel.removeAll();
                        frame.addChessboard();
                        frame.addLabel();
                        frame.addRestartButton();
                        frame.addLoadButton();
                        frame.addTimeLabel();
                        frame.addRegretButton();
                        frame.addBackGroundButton();
                        frame.addAttributesButton();
                        frame.addSaveButton();
                        chessboard.swapColor();
                        if(Chessboard.currentColor== ChessColor.BLACK) {
                            ChessGameFrame.statusLabel.setText("Black Chess Round");
                        }else{
                            ChessGameFrame.statusLabel.setText("White Chess Round");
                        }
                        frame.repaint();
                        frame.panel.repaint();
                        throw new Exception("Error Code:101");
                    }
                    for (int j = 0; j < 8; j++) {
                        switch (chess.charAt(j)) {
                            case 'R' -> chessboard.initRookOnBoard(i, j, ChessColor.BLACK);
                            case 'r' -> chessboard.initRookOnBoard(i, j, ChessColor.WHITE);
                            case 'Q' -> chessboard.initQueenOnBoard(i, j, ChessColor.BLACK);
                            case 'q' -> chessboard.initQueenOnBoard(i, j, ChessColor.WHITE);
                            case 'N' -> chessboard.initKnightOnBoard(i, j, ChessColor.BLACK);
                            case 'B' -> chessboard.initBishopOnBoard(i, j, ChessColor.BLACK);
                            case 'K' -> chessboard.initKingOnBoard(i, j, ChessColor.BLACK);
                            case 'P' -> chessboard.initPawnOnBoard(i, j, ChessColor.BLACK);
                            case 'p' -> chessboard.initPawnOnBoard(i, j, ChessColor.WHITE);
                            case 'k' -> chessboard.initKingOnBoard(i, j, ChessColor.WHITE);
                            case 'b' -> chessboard.initBishopOnBoard(i, j, ChessColor.WHITE);
                            case 'n' -> chessboard.initKnightOnBoard(i, j, ChessColor.WHITE);
                            case '_'->chessboard.initEmptyOnBoard();
                            default -> { frame.panel.removeAll();
                                frame.addChessboard();
                                frame.addLabel();
                                frame.addRestartButton();
                                frame.addLoadButton();
                                frame.addTimeLabel();
                                frame.addRegretButton();
                                frame.addSaveButton();
                                frame.addBackGroundButton();
                                frame.addAttributesButton();
                                chessboard.swapColor();
                                if(Chessboard.currentColor== ChessColor.BLACK) {
                                    ChessGameFrame.statusLabel.setText("Black Chess Round");
                                }else{
                                    ChessGameFrame.statusLabel.setText("White Chess Round");
                                }
                                frame.repaint();
                                frame.panel.repaint();
                                throw new Exception("Error Code:102");
                            }
                        }
                    }
                }
            }
            frame.panel.add(chessboard);
            chessboard.repaint();
            frame.panel.repaint();
            String next = bufferedReader.readLine();
            if (next.equals("Black")) {
                Chessboard.currentColor = ChessColor.WHITE;
                ChessGameFrame.statusLabel.setText("White Chess Round");
            } else if(next.equals("White")){
                Chessboard.currentColor = ChessColor.BLACK;
                ChessGameFrame.statusLabel.setText("Black Chess Round");
            }else{  frame.panel.removeAll();
                frame.addChessboard();
                frame.addLabel();
                frame.addRestartButton();
                frame.addBackGroundButton();
                frame.addAttributesButton();
                frame.addTimeLabel();
                frame.addLoadButton();
                frame.addRegretButton();
                chessboard.swapColor();
                if(Chessboard.currentColor== ChessColor.BLACK) {
                    ChessGameFrame.statusLabel.setText("Black Chess Round");
                }else{
                    ChessGameFrame.statusLabel.setText("White Chess Round");
                }
                frame.addSaveButton();
                frame.repaint();
                frame.panel.repaint();
                throw new Exception("Error Code:103");
            }
            String num = String.valueOf(bufferedReader.read());
            int number=Integer.parseInt(num)-48;
            Steps.saveList.clear();
            String aa;
            bufferedReader.readLine();
           while ((aa=bufferedReader.readLine())!=null){
               ChessComponent[][] hh = new ChessComponent[8][8];
                System.out.println(aa);
                String chess =aa;
                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 8; j++) {
                        switch (chess.charAt(i*8+j)) {
                            case 'R' -> hh[i][j] = new RookChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'R');
                            case 'r' -> hh[i][j] = new RookChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'r');
                            case 'Q' -> hh[i][j] = new QueenChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'Q');
                            case 'q' -> hh[i][j] = new QueenChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'q');
                            case 'N' -> hh[i][j] = new KnightChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'N');
                            case 'B' -> hh[i][j] = new BishopChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'B');
                            case 'K' -> hh[i][j] = new KingChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'K');
                            case 'P' -> hh[i][j] = new PawnChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'P');
                            case 'p' -> hh[i][j] = new PawnChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'p');
                            case 'k' -> hh[i][j] = new KingChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'k');
                            case 'b' -> hh[i][j] = new BishopChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'b');
                            case 'n' -> hh[i][j] = new KnightChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'n');
                            case '_' -> hh[i][j] = new EmptySlotComponent(new ChessboardPoint(i, j), ChessColor.NONE, '_');
                        }
                    }
                }
                Steps.saveList.add(hh);
            }
            System.out.println(Steps.saveList.size());
            read.close();
        } catch (Exception x) {
            errorLabel.setText(x.getMessage());
            ViewManager.show(FrameMod.Error);
        }
        frame.addLabel();
        frame.addRestartButton();
        frame.addLoadButton();
        frame.addRegretButton();
        frame.addTimeLabel();
        frame.addBackGroundButton();
        frame.addAttributesButton();
        frame.addSaveButton();
        chessboard.swapColor();
        if(Chessboard.currentColor== ChessColor.BLACK) {
            ChessGameFrame.statusLabel.setText("Black Chess Round");
        }else{
            ChessGameFrame.statusLabel.setText("White Chess Round");
        }
        frame.repaint();
        frame.panel.repaint();
    }
}



