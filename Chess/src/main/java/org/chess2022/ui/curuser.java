package org.chess2022.ui;

public class curuser {
    static String number="1";


    public curuser(String number) {
        this.number = number;
    }

    public static void setNumber(String number) {
        curuser.number = number;
    }

    public static String getStr() {
        return number;
    }
}
