package org.chess2022.ui;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class User {
    private String account;
    private String password;
    public int grade=0 ;
    private final int number;
    int level=1;
    static ArrayList<User> users = new ArrayList<>();

    //构造器
    public User(String account, String password,int number) {
        this.account = account;
        this.password = password;
        this.number=number;
        users.add(this);
    }

    //ToString
    @Override
    public String toString() {
        return  "account: "+account+" grade: "+grade+" level: "+level;
    }

    //获取排名
    public static void rank() {
        Collections.sort(users, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                if (o1.getGrade() < o2.getGrade()) {
                    return 1;
                } else if (o1.getGrade() > o2.getGrade()) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
    }

    //检查账户密码
    public boolean checkIdentity(String account, String password) {
        if (this.account.equals(account) && this.password.equals(password)) {
                return true;
        } else {
                return false;
        }
    }


    public int getGrade() {
        return grade;
    }

    // TODO: 2022/5/14  得分(每赢一局调用一次)写buffer，传入当前玩家，传入读文件变数组，当前加1，再写

    public static void setGrade() {
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
        }catch(IOException e){
            e.printStackTrace() ;	// 输出信息
        }
        int[] arr1=new int[3];
        for (int i = 0; i < 3; i++) {
            arr1[i]=Integer.parseInt(arr[i]);
        }
        int curr=Integer.parseInt(curuser.number);
        arr1[curr]+=1;

        for (int i = 0; i < 3; i++) {
            if(users.get(i).getNumber()==0){users.get(i).grade=arr1[0];}
            if(users.get(i).getNumber()==1){users.get(i).grade=arr1[1];}
            if(users.get(i).getNumber()==2){users.get(i).grade=arr1[2];}
        }

        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("Chess/test.txt"), StandardCharsets.UTF_8));
            for (int i = 0; i < 3; i++) {
                try {
                    bufferedWriter.write(arr1[i]+" ");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {e.printStackTrace();
        } finally {
            try {
                if (bufferedWriter != null) {
                    bufferedWriter.close();
                    bufferedWriter.close();
                }
            } catch (Exception e) {

            }
        }

    }
    
    public String getAccount() {
        return account;
    }

    public String getPassword() {
        return password;
    }

    public int getNumber() {
        return number;
    }
}
