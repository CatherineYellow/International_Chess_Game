package org.chess2022.ui;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class Login {
    public static void main(String[] args) {
        // 登录窗口
        JFrame loginFrame = new JFrame("Login");
        loginFrame.setSize(250,300);
        loginFrame.setLocationRelativeTo(null);
        loginFrame.setResizable(false);
//        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //面板
        Backgroundpanel Panel = new Backgroundpanel("Chess/src/main/java/images/loginP.png");
        loginFrame.add(Panel);

        //标签输入框按钮
        Dimension labelDimension = new Dimension(300, 30);
        Dimension textDimension = new Dimension(200, 30);

        JLabel userName = new JLabel("Username",JLabel.CENTER);
        userName.setPreferredSize(labelDimension);
        JTextField userNameTextField =new JTextField() ;
        userNameTextField.setPreferredSize(textDimension);

        JLabel userPassword = new JLabel("Password",JLabel.CENTER);
        userPassword.setPreferredSize(labelDimension);
        JPasswordField userPasswordField = new JPasswordField();
        userPasswordField.setPreferredSize(textDimension);

//        JLabel kong=new JLabel("\n",JLabel.CENTER);
//        Dimension KongDimension = new Dimension(250, 50);
//        userPassword.setPreferredSize(KongDimension);
        JLabel kong = new JLabel("",JLabel.CENTER);
        kong.setPreferredSize(new Dimension(200,15));
//        ImageIcon icon = new ImageIcon("Chess/src/main/java/images/loginP.png");
//        ImageUtil.scaledImage(30, 20, icon);
        //创建按钮
        JButton login=new JButton("Login");




        Panel.add(userName);
        Panel.add(userNameTextField);
        Panel.add(userPassword);
        Panel.add(userPasswordField);
        Panel.add(kong);
        Panel.add(login);
        // TODO: 2022/5/17 倒计时 
//        new Count().start();
//        Panel.add(Count.jLabel);
       
        //用户及登录界面
        new User("0","0",0);
        new User("1","1",1);
        new User("2","2",2);

        BufferedReader buf = null ;		// 声明对象
        try {
            // TODO: 2022/5/16 改为当前路径
            buf = new BufferedReader(new FileReader("./Chess/test.txt")) ;	// 将字节流变为字符流
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String str = null ;	// 接收输入内容
        String[] arr=new String[3];

        try{
            str = buf.readLine();	// 读取一行数据
            arr=str.split(" ");
            System.out.println(arr[2]);
        }catch(IOException e){
            e.printStackTrace() ;	// 输出信息
        }
        int[] arr1=new int[3];
        for (int i = 0; i < 3; i++) {
            arr1[i]=Integer.parseInt(arr[i]);
        }
        int curr=Integer.parseInt(curuser.number);
        for (int i = 0; i < 3; i++) {
            User.users.get(i).grade=arr1[i];
        }


        //监听器
        LoginListener loginListener=new LoginListener(loginFrame,userNameTextField,userPasswordField);
//        MusicStart musicListener=new MusicStart();

        // TODO: 2022/5/17 音乐 
//        new MusicStart().start();
//        new MusicError().start();
//        new Count().start();
        login.addActionListener(loginListener);
//        login.addActionListener(musicListener);

        loginFrame.setVisible(true);
    }



}
