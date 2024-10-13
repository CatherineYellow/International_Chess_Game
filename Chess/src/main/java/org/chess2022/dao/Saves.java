package org.chess2022.dao;

import org.chess2022.entity.Chessboard;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Saves {
    public static int i;

    public static void save() {
        ArrayList<String> save = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            String a = "";
            for (int j = 0; j < 8; j++) {
                a += Chessboard.chessComponents[i][j].getsName();
            }
            save.add(a);
        }
        save.add(Chessboard.currentColor.toString());
        save.add(String.valueOf(Steps.saveList.size()));
        for (int i = 0; i < Steps.saveList.size(); i++) {
            StringBuilder a = new StringBuilder();
            for (int k = 0; k < 8; k++) {
                for (int j = 0; j < 8; j++) {
                    a.append(Steps.saveList.get(i)[k][j].getsName());
                }
            }
            save.add(a.toString());
        }
        createTxt(save);
    }

    private static void createTxt(List<String> userCodes) {
        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("File" + i + ".txt"), StandardCharsets.UTF_8));
            i++;
            for (String userCode : userCodes) {
                bufferedWriter.write(userCode);
                bufferedWriter.newLine();
            }
        } catch (Exception e) {
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
}
