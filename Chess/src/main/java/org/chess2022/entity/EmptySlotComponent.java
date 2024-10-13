package org.chess2022.entity;



import org.chess2022.controller.ClickController;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 这个类表示棋盘上的空位置
 */
public class EmptySlotComponent extends ChessComponent {
    public char name;

    public EmptySlotComponent(ChessboardPoint chessboardPoint, Point location, ClickController listener, int size) {
        super(chessboardPoint, location, ChessColor.NONE, listener, size);
        name='_';
    }

    public EmptySlotComponent(ChessboardPoint chessboardPoint, ChessColor none, char c) {
        super(chessboardPoint, none, c);
    }

    @Override
    public boolean canMoveTo(ChessComponent[][] chessboard, ChessboardPoint destination) {
        return false;
    }

    @Override
    public List<ChessboardPoint> canMoveToPoints() {
        ArrayList<ChessboardPoint> points=new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(canMoveTo(Chessboard.chessComponents,new ChessboardPoint(i,j))&&Chessboard.getChessComponent(i,j).chessColor!=Chessboard.currentColor){
                    points.add(new ChessboardPoint(i,j));
                }
            }
        }
        return points;
    }
    public char getsName() {
        return name;
    }

    @Override
    public void loadResource() throws IOException {
        //No resource!
    }
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
//        g.drawImage(rookImage, 0, 0, getWidth() - 13, getHeight() - 20, this);
        g.setColor(Color.BLACK);
        if (isSelected()) { // Highlights the model if selected.
            g.setColor(Color.RED);
            g.drawOval(0, 0, getWidth() , getHeight());
        }
    }

}
