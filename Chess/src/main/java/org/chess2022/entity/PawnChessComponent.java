package org.chess2022.entity;



import org.chess2022.controller.ClickController;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class PawnChessComponent extends ChessComponent{
    /**
     * 黑兵和白兵的图片，static使得其可以被所有兵对象共享
     * <br>
     * FIXME: 需要特别注意此处加载的图片是没有背景底色的！！！
     */
    private static Image PAWN_WHITE;
    private static Image PAWN_BLACK;
    public char name;

    /**
     * 兵棋子对象自身的图片，是上面两种中的一种
     */
    private Image pawnImage;

    public PawnChessComponent(ChessboardPoint chessboardPoint, ChessColor black, char p) {
        super(chessboardPoint, black, p);
    }

    /**
     * 读取加载兵棋子的图片
     *
     * @throws IOException
     */
    public void loadResource() throws IOException {

        if (PAWN_WHITE == null) {
            PAWN_WHITE = ImageIO.read(new File("./Chess/src/main/java/images/pawn-white.png"));
        }

        if (PAWN_BLACK == null) {
            PAWN_BLACK = ImageIO.read(new File("./Chess/src/main/java/images/pawn-black.png"));
        }
    }


    /**
     * 在构造棋子对象的时候，调用此方法以根据颜色确定pawnImage的图片是哪一种
     *
     * @param color 棋子颜色
     */

    private void initiatePawnImage(ChessColor color) {
        try {
            loadResource();
            if (color == ChessColor.WHITE) {
                pawnImage = PAWN_WHITE;
            } else if (color == ChessColor.BLACK) {
                pawnImage = PAWN_BLACK;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public PawnChessComponent(ChessboardPoint chessboardPoint, Point location, ChessColor color, ClickController listener, int size) {
        super(chessboardPoint, location, color, listener, size);
        if(color==ChessColor.WHITE){
            name='p';
        }else {
            name='P';
        }
        initiatePawnImage(color);
    }



    @Override
    public boolean canMoveTo(ChessComponent[][] chessComponents, ChessboardPoint destination) {
        ChessboardPoint source = getChessboardPoint();
        if(source.getY()==destination.getY()) {
            if (pawnImage == PAWN_BLACK) {
                if (source.getX() == 1) {
                    if ((destination.getX() - source.getX() == 1)){
                            if (!(chessComponents[source.getX() + 1][source.getY()] instanceof EmptySlotComponent)) {
                                return false;
                            }
                        return true;
                    }else if(destination.getX()-source.getX()==2){
                        if(!(chessComponents[source.getX()+1][source.getY()]instanceof EmptySlotComponent)||!(chessComponents[source.getX()+2][source.getY()]instanceof EmptySlotComponent)){
                            return false;
                        }
                        return true;
                    } else{
                        return false;
                    }
                }else{
                    if (destination.getX() - source.getX() == 1){
                        if(!(chessComponents[source.getX()+1][source.getY()]instanceof EmptySlotComponent)){
                            return false;
                        }
                        return true;
                    }else{
                        return false;
                    }
                }
            }else{
                if (source.getX() == 6) {
                    if ((destination.getX() - source.getX() == -1)){
                        if (!(chessComponents[source.getX() - 1][source.getY()] instanceof EmptySlotComponent)) {
                            return false;
                        }
                        return true;
                    }else if(destination.getX()-source.getX()==-2){
                        if(!(chessComponents[source.getX()-1][source.getY()]instanceof EmptySlotComponent)||!(chessComponents[source.getX()-2][source.getY()]instanceof EmptySlotComponent)){
                            return false;
                        }
                        return true;
                    } else{
                        return false;
                    }
                }else{
                    if (destination.getX() - source.getX() == -1){
                        if(!(chessComponents[source.getX()-1][source.getY()]instanceof EmptySlotComponent)){
                            return false;
                        }
                        return true;
                    }else{
                        return false;
                    }
                }
            }
        }else if(Math.abs(source.getY()-destination.getY())==1){
            if (pawnImage == PAWN_BLACK){
                if(destination.getX()-source.getX()==1){
                    if(chessComponents[destination.getX()][destination.getY()]instanceof EmptySlotComponent){
                        return false;
                    }else {
                        return true;
                    }
                }
            }else{
                if(destination.getX()-source.getX()==-1){
                    if(chessComponents[destination.getX()][destination.getY()]instanceof EmptySlotComponent){
                        return false;
                    }else {
                        return true;
                    }
                }
            }
        }


        return false;
    }
  public void levelUp(ChessComponent[][] chessComponents){
        if(this.chessColor==ChessColor.BLACK){
            if(this.getChessboardPoint().getX()==7){

            }
        }
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
        g.drawImage(pawnImage, 0, 0, getWidth() , getHeight(), this);
        g.setColor(Color.BLACK);
        if (isSelected()) { // Highlights the model if selected.
            g.setColor(Color.RED);
            g.drawOval(0, 0, getWidth() , getHeight());
        }
    }
}
