package org.chess2022.frame;

import org.chess2022.values.FrameMod;
import org.chess2022.view.ViewManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonEvent implements ActionListener {

    String text;

    public ButtonEvent(String str){
        this.text=str;
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if(text.equals("Rank")) {
            ViewManager.show(FrameMod.Rank);
        }
        if(text.equals("Login")){
           ViewManager.show(FrameMod.Login);
        }
    }
}
