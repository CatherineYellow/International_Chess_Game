package org.chess2022.entity;

import org.chess2022.controller.ClickController;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent  extends ChessComponent{
    /**
     * 黑车和白车的图片，static使得其可以被所有车对象共享
     * <br>
     * FIXME: 需要特别注意此处加载的图片是没有背景底色的！！！
     */
    private static Image QUEEN_WHITE;
    private static Image QUEEN_BLACK;
    public char name;

    /**
     * 车棋子对象自身的图片，是上面两种中的一种
     */
    private Image queenImage;

    public QueenChessComponent(ChessboardPoint chessboardPoint, ChessColor black, char q) {
        super(chessboardPoint, black, q);
    }

    /**
     * 读取加载车棋子的图片
     *
     * @throws IOException
     */
    public void loadResource() throws IOException {
        if (QUEEN_WHITE == null) {
            QUEEN_WHITE = ImageIO.read(new File("./Chess/src/main/java/images/queen-white.png"));
        }

        if (QUEEN_BLACK == null) {
            QUEEN_BLACK = ImageIO.read(new File("./Chess/src/main/java/images/queen-black.png"));
        }
    }


    /**
     * 在构造棋子对象的时候，调用此方法以根据颜色确定rookImage的图片是哪一种
     *
     * @param color 棋子颜色
     */

    private void initiateQueenImage(ChessColor color) {
        try {
            loadResource();
            if (color == ChessColor.WHITE) {
                queenImage = QUEEN_WHITE;
            } else if (color == ChessColor.BLACK) {
                queenImage = QUEEN_BLACK;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public QueenChessComponent(ChessboardPoint chessboardPoint, Point location, ChessColor color, ClickController listener, int size) {
        super(chessboardPoint, location, color, listener, size);
        if(color==ChessColor.WHITE){
            name='q';
        }else {
            name='Q';
        }
        initiateQueenImage(color);
    }

    /**
     * 车棋子的移动规则
     *
     * @param chessComponents 棋盘
     * @param destination     目标位置，如(0, 0), (0, 7)等等
     * @return 车棋子移动的合法性
     */

    @Override
    public boolean canMoveTo(ChessComponent[][] chessComponents, ChessboardPoint destination) {
        ChessboardPoint source = getChessboardPoint();
        if (Math.abs(source.getX() - destination.getX()) == Math.abs(source.getY() - destination.getY())) {
            int row1 = source.getX();
            int row2 = destination.getX();
            int col1 = source.getY();
            int col2 = destination.getY();
            if (row1 > row2) {
                if (col1 > col2) {
                    for (int i = 1; i < row1 - row2; i++) {
                        if (!(chessComponents[row1 - i][col1 - i] instanceof EmptySlotComponent)) {
                            return false;
                        }
                    }
                } else {
                    for (int i = 1; i < row1 - row2; i++) {
                        if (!(chessComponents[row1 - i][col1 + i] instanceof EmptySlotComponent)) {
                            return false;
                        }
                    }
                }
            } else {
                if (col1 > col2) {
                    for (int i = 1; i < row2 - row1; i++) {
                        if (!(chessComponents[row1 + i][col1 - i] instanceof EmptySlotComponent)) {
                            return false;
                        }
                    }
                } else {
                    for (int i = 1; i < row2 - row1; i++) {
                        if (!(chessComponents[row1 + i][col1 + i] instanceof EmptySlotComponent)) {
                            return false;
                        }
                    }
                }
            }
        } else if (source.getX() == destination.getX()) {
            int row = source.getX();
            for (int col = Math.min(source.getY(), destination.getY()) + 1;
                 col < Math.max(source.getY(), destination.getY()); col++) {
                if (!(chessComponents[row][col] instanceof EmptySlotComponent)) {
                    return false;
                }
            }
        } else if (source.getY() == destination.getY()) {
            int col = source.getY();
            for (int row = Math.min(source.getX(), destination.getX()) + 1;
                 row < Math.max(source.getX(), destination.getX()); row++) {
                if (!(chessComponents[row][col] instanceof EmptySlotComponent)) {
                    return false;
                }
            }
        } else { // Not on the same row or the same column.
            return false;
        }
        return true;
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

    /**
     * 注意这个方法，每当窗体受到了形状的变化，或者是通知要进行绘图的时候，就会调用这个方法进行画图。
     *
     * @param g 可以类比于画笔
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
//        g.drawImage(rookImage, 0, 0, getWidth() - 13, getHeight() - 20, this);
        g.drawImage(queenImage, 0, 0, getWidth() , getHeight(), this);
        g.setColor(Color.BLACK);
        if (isSelected()) { // Highlights the model if selected.
            g.setColor(Color.RED);
            g.drawOval(0, 0, getWidth() , getHeight());
        }
    }
}

