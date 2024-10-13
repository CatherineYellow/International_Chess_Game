package org.chess2022.ui;

import javax.swing.*;
import java.awt.*;

public class Rank {
    public static void main(String[] args) {
        JFrame rankFrame=new JFrame("Rank");
        rankFrame.setSize(350,400);
        rankFrame.setLocationRelativeTo(null);
        rankFrame.setResizable(false);


        Backgroundpanel Panel=new Backgroundpanel("Chess/src/main/java/images/rankP.png");
        rankFrame.add(Panel);

        Dimension labelDimension1 = new Dimension(100, 30);
        Dimension labelDimension2 = new Dimension(110, 30);
        Font labelFont1 = new Font("MV Boli", Font.BOLD, 30);
        Font labelFont2 = new Font("Times New Roman",Font.BOLD,25);


        JLabel UserName = new JLabel("User");
        UserName.setPreferredSize(labelDimension1);
        UserName.setFont(labelFont1);
        JLabel Grade = new JLabel("Grade");
        Grade.setPreferredSize(labelDimension2);
        Grade.setFont(labelFont1);
        JLabel Rank = new JLabel("Rank");
        Rank.setPreferredSize(labelDimension1);
        Rank.setFont(labelFont1);

        Panel.add(UserName);
        Panel.add(Grade);
        Panel.add(Rank);

        User.rank();
        for (int i = 0; i < User.users.size(); i++) {
            String name=User.users.get(i).getAccount();
            int grade=User.users.get(i).getGrade();

            JLabel UserName1 = new JLabel(name);
            UserName1.setPreferredSize(labelDimension1);
            UserName1.setFont(labelFont2);
            JLabel Grade1 = new JLabel(String.valueOf(grade));
            Grade1.setPreferredSize(labelDimension2);
            Grade1.setFont(labelFont2);
            JLabel Rank1 = new JLabel(String.valueOf(i+1));
            Rank1.setPreferredSize(labelDimension1);
            Rank1.setFont(labelFont2);
            Panel.add(UserName1);
            Panel.add(Grade1);
            Panel.add(Rank1);
        }

        rankFrame.setVisible(true);
    }
}
