package org.chess2022.ui;

import org.chess2022.values.FrameMod;
import org.chess2022.view.ViewManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TWOlistener implements ActionListener {
    private final JFrame modeFrame;

    public TWOlistener(JFrame modeFrame) {
        this.modeFrame = modeFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        modeFrame.setVisible(false);
        ViewManager.show(FrameMod.Game);
    }
}
