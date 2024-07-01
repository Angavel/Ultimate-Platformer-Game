package Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.TimerTask;
import javax.swing.JFrame;
import java.util.Timer;
import java.util.TimerTask;


public class GameFrame extends JFrame implements KeyListener {
    static int xPos, yPos; // position of player in frame
    int refreshRate = 200; //how quickly main timer loops
    boolean isJumping = false;
    boolean isMoving = false;
    static int xMomentum, yMomentum = 0; //store speed of moving left/right and up/down
    Timer tJ = new Timer(); //for jumping
    Timer tM = new Timer(); //for moving

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
    public void keyPressed(KeyEvent e) { // begin movement when key pressed
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W -> { //jump
                Jump("J");
            }
            case KeyEvent.VK_A -> { //moving left
                Move("L");
            }
            case KeyEvent.VK_D -> { //moving right
                Move("R");
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) { //cancel movement when key released
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W -> {//jump
                Jump("");
            }
            case KeyEvent.VK_A -> { //moving left
                Move("");
            }
            case KeyEvent.VK_D -> { //moving right
                Move("");
            }
        }
    }


    public int get_xPos() {
        return xPos;
    }

    public int get_yPos() {
        return yPos;
    }


    ///////////////////////MOVEMENT COMMANDS////////////////////////////
    public void Jump(String s) {   //// MOVING Y-AXIS MOVEMENT INTO FALL() METHOD!!!!!!!

        if (isJumping == false && s.equals("J")) { //start jump when key pressed
            System.out.println("Key Pressed JUMP!");
            yPos -= 5;
            yMomentum = 40;
            isJumping = true;

        } //if statement

        else if (isJumping == true && s.equals("")) { // stop jump when key released
            isJumping = false;
            System.out.println("CANCELLED JUMP");

        } //else statement

    }// jump method


    public void Fall() {
        if (yPos > 700){ //below 700
            yMomentum = 0;
            playerSprite.setLocation(xPos, 700); //Resets sprite to floor level if ever below.
        }
        else if (yPos <= 700) {
            yPos -= yMomentum;
            if (yMomentum < 0)
                yMomentum = 0;
            if (yMomentum > 0);
                yMomentum -= 10;
            playerSprite.setLocation(xPos, yPos);
        }

    }

    public void Move(String s) { //to move either right or left. Receives string from keylistener event

        if (isMoving == false && s.equals("R")) { //start moving right when key pressed

            System.out.println("Key Pressed RIGHT!");
            tM.scheduleAtFixedRate(new TimerTask() {
                public void run() {
                    System.out.println("TIMER LOOP RIGHT");
                    xPos += 10;
                    playerSprite.setLocation(xPos, yPos);
                    isMoving = true;
                } //run method for timer

            }/*timer task*/, 0, refreshRate);

        } else if (isMoving == false && s.equals("L")) { //start moving left when key pressed

            System.out.println("Key Pressed LEFT!");
            tM.scheduleAtFixedRate(new TimerTask() {
                public void run() {
                    System.out.println("TIMER LOOP LEFT");
                    xPos -= 10;
                    playerSprite.setLocation(xPos, yPos);
                    isMoving = true;
                } //run method for timer

            }/*timer task*/, 0, refreshRate);

        } else if (isMoving == true && s.equals("")) { // stop moving either direction when key released
            tM.cancel(); //kills whole Timer()
            isMoving = false;
            System.out.println("CANCELLED MOVE");
            tM = new Timer(); //puts a new Timer() on the timer? I dunno it works (maybe theres a timer.pause command instead?)
        } //else statement
    } // Moving x-axis Method
//////////////////////////////////////////////////////////////////////////////////


} //GameFrame class
