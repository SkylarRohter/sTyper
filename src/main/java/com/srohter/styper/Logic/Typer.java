package com.srohter.styper.Logic;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Typer {
    private char[] text;
    private int delayTime;

    public Typer(char[] text, int delay) {
        this.text = text;
        this.delayTime = delay;
    }

    public void type() {
        try {
            Robot robot = new Robot();
            int illegalArg = 1;
            for (char c : text) {
                try {
                    if (Character.isLowerCase(c)) {
                        int keyCode = KeyEvent.getExtendedKeyCodeForChar(c);
                        robot.keyPress(keyCode);
                        robot.keyRelease(keyCode);
                    } else if (Character.isUpperCase(c) && !Character.isDigit(c)) {
                        int keyCode = KeyEvent.getExtendedKeyCodeForChar(c);
                        robot.keyPress(KeyEvent.VK_SHIFT);
                        robot.keyPress(keyCode);
                        robot.keyRelease(keyCode);
                        robot.keyRelease(KeyEvent.VK_SHIFT);
                    } else if (c == '"') {
                        robot.keyPress(KeyEvent.VK_SHIFT);
                        robot.keyPress(KeyEvent.VK_QUOTE);
                        robot.keyRelease(KeyEvent.VK_QUOTE);
                        robot.keyRelease(KeyEvent.VK_SHIFT);
                    } else if (c == '’') {
                        robot.keyPress(KeyEvent.VK_QUOTE);
                        robot.keyRelease(KeyEvent.VK_QUOTE);
                    } else {
                        int keyCode = KeyEvent.getExtendedKeyCodeForChar(c);
                        robot.keyPress(keyCode);
                        robot.keyRelease(keyCode);
                    }
                    Thread.sleep(delayTime);
                }catch(IllegalArgumentException iae){
                    System.out.println("IllegalArg " + illegalArg);
                    illegalArg++;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
