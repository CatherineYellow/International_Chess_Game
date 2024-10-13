package org.chess2022.ui;

import org.chess2022.values.FrameMod;
import org.chess2022.view.ViewManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static org.chess2022.ui.User.users;

public class attributeListener implements ActionListener {
    private final JFrame modeFrame;

    public attributeListener(JFrame modeFrame) {
        this.modeFrame = modeFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int curr=Integer.parseInt(curuser.number);
        int j=0;
        for (int i = 0; i < 3; i++) {
            if(users.get(i).getNumber()==0&&curr==0){j=i;}
            if(users.get(i).getNumber()==1&&curr==1){j=i;}
            if(users.get(i).getNumber()==2&&curr==2){j=i;}
        }
        JOptionPane.showMessageDialog(null, users.get(j), "Attribute", 1);
    }
}
