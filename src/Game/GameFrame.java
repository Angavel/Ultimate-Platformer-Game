package Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.TimerTask;
import javax.swing.JFrame;
//import javax.swing.Timer;
import java.util.Timer;
import java.util.TimerTask;


public class GameFrame extends JFrame implements KeyListener{
    static int xPos, yPos; // position of player in frame
    int time = 200; //how quickly main timer loops
    boolean isJumping = false;
    Timer t = new Timer();

//    boolean gameOver = false;

    JLabel playerSprite;



    public GameFrame(int x, int y) {
        xPos = 235; //default player start position
        yPos = 700;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("ULTIMATE PLATFORMER GAME");
        this.setSize(x, y);
        this.setLayout(null); ////
        this.addKeyListener(this);
//        gameOver = false; // Resets the game over token, stops infinite looping


        this.setVisible(true);


        playerSprite = new JLabel();
        this.add(playerSprite);
        playerSprite.setBounds(xPos, yPos, 30, 30);
//        playerSprite.setIcon(snek);
        playerSprite.setBackground(Color.BLUE);
        playerSprite.setOpaque(true);
        playerSprite.setVisible(true);




//        this.add(restartButton);
//        restartButton = new JButton();
//        restartButton.setText("Restart?"); ////////////////////button no work yet
//        restartButton.setBounds(300, 300, 100, 100);
////        restartButton.setAction(this.setGameOver(true));
//        restartButton.setEnabled(false);
//        restartButton.setVisible(false);


    } // GameFrame constructor

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W -> {
                jump("J");
            }
            case KeyEvent.VK_A -> { //moving left
                move("L");
            }
            case KeyEvent.VK_D -> { //moving right
                move("R");
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // logic for falling down/stopping?
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W -> {
                jump("");
            }
            case KeyEvent.VK_A -> { //moving left
                move("");
            }
            case KeyEvent.VK_D -> { //moving right
                move("");
            }
        }
    }


    public int get_xPos(){
        return xPos;
    }

    public int get_yPos(){
        return yPos;
    }




    ///////////////////////MOVEMENT COMMANDS
    public void jump(String s){

        if (isJumping == false && s.equals("J")) { //start jump when key pressed

            System.out.println("Key Pressed!");
            t.scheduleAtFixedRate(new TimerTask() { // creates a persistent timer instance
                public void run(){
                    System.out.println("TIMER LOOP");
                    yPos -= 20;
                    playerSprite.setLocation(xPos, yPos);
                    isJumping = true;
                } //run method for timer

         }/*timer task*/,0, 200);

        } //if statement
        else if (isJumping == true && s.equals("")){ // stop jump when key released
            t.cancel(); //kills whole Timer()
            isJumping = false;
            System.out.println("CANCELLED");
            t = new Timer(); //puts a new Timer() on the timer? I dunno it works (maybe theres a timer.pause command instead?)
        } //else statement

    }// jump method



    public void fall() {
        if (yPos < 700) {
            yPos -= 1;
        }
    }

    public void move(String s){ //TRUE is right FALSE is left
        if (s.equals("R")){
            xPos += 5;
            playerSprite.setLocation(xPos, yPos);
        } else  if (s.equals("L")){
            xPos -= 5;
            playerSprite.setLocation(xPos, yPos);
        }
    }
//////////////////////////



} //GameFrame class
