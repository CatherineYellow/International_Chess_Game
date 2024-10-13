package org.chess2022.ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginListener implements ActionListener {
    private final JFrame loginFrame;
    private final JTextField userNameTextField;
    private final JTextField userPasswordField;

    public LoginListener(JFrame loginFrame, JTextField userNameTextField, JTextField userPasswordField) {
        this.loginFrame = loginFrame;
        this.userNameTextField=userNameTextField;
        this.userPasswordField=userPasswordField;
        curuser.number=userNameTextField.getText();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String UserName=userNameTextField.getText();
        String UserPassword=userPasswordField.getText();
        new curuser(UserName);
        for (int i = 0; i < User.users.size(); i++) {
            if (User.users.get(i).checkIdentity(UserName,UserPassword)) {
                JOptionPane.showMessageDialog(null, "Login Successfully", "Successful", 1);
                loginFrame.setVisible(false);
//                Game.fatherFrame = loginFrame;
//                Game.main(null);
                ModeChoose.main(null);
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Error", "Error", 0);
    }

}
