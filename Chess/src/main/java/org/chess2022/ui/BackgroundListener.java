package org.chess2022.ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class BackgroundListener implements ActionListener {
    private final JFrame frame;
    private final Backgroundpanel panel;
    private File file;

    public BackgroundListener(JFrame frame, Backgroundpanel panel) {
        this.frame = frame;
        this.panel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Choose File");
        // TODO: 2022/5/14 改目录
        File currentDirectory = new File("./Chess/src/main/java/images");
        fileChooser.setCurrentDirectory(currentDirectory);
        int result = fileChooser.showOpenDialog(frame);
        if (result == JFileChooser.APPROVE_OPTION) {
            file = fileChooser.getSelectedFile();
        }
        panel.setBackgroundFile(file.getAbsolutePath());
        frame.repaint();
    }


}
