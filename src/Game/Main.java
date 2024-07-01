package Game;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import java.util.Timer;
import java.util.TimerTask;

public class Main {
    public static void main(String[] args) {

        GameFrame w = new GameFrame(500, 800);
        Timer t = new Timer();
        t.scheduleAtFixedRate(new TimerTask() { // tells the Timer() object to do something
            public void run() {
                System.out.print("Main Loop");
                w.Fall();
                w.Move();
            } //run method for timer

        }/*timer task*/, 0, 40);

    } // main method

} // main class
