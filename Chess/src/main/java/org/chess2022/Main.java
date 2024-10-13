package org.chess2022;

import org.chess2022.frame.MenuFrame;
import org.chess2022.values.FrameMod;
import org.chess2022.view.ViewManager;
import org.chess2022.ui.*;

public class Main {
    public static void main(String[] args) {
        ViewManager.show(FrameMod.Menu);
        new MusicStart().start();
    }
}
