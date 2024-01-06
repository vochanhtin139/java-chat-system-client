package com.ptq.emoji;

import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;

public class Emoji {

    private static Emoji instance;

    public static Emoji getInstance() {
        if (instance == null) {
            instance = new Emoji();
        }
        return instance;
    }

    private Emoji() {
    }

    public List<Model_Emoji> getStyle1() {
        List<Model_Emoji> list = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            list.add(new Model_Emoji(i, new ImageIcon(getClass().getResource("/com/ptq/emoji/icon/" + i + ".png"))));
        }
        return list;
    }

    public List<Model_Emoji> getStyle2() {
        List<Model_Emoji> list = new ArrayList<>();
        for (int i = 21; i <= 40; i++) {
            list.add(new Model_Emoji(i, new ImageIcon(getClass().getResource("/com/ptq/emoji/icon/" + i + ".png"))));
        }
        return list;
    }

    public Model_Emoji getImoji(int id) {
        return new Model_Emoji(id, new ImageIcon(getClass().getResource("/com/ptq/emoji/icon/" + id + ".png")));
    }
}