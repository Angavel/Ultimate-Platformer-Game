package Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;

class GameFrame extends JFrame implements KeyListener {
    int x, y; // size of window in pixels
    int time = 200; //how quickly main timer loops
    boolean gameOver = false;

    public GameFrame(int x, int y) {
        this.x = x;
        this.y = y;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("ULTIMATE PLATFORMER GAME");
        this.setSize(this.x, this.y); //stackoverflow says delete this?
        this.setLayout(null);
        this.addKeyListener(this);
        gameOver = false; // Resets the game over token, stops infinite looping

        JLabel playerSprite = new JLabel();
        playerSprite.setBounds(200, 200, 30, 30);
//        playerSprite.setIcon(snek);
        playerSprite.setBackground(Color.BLUE);
        playerSprite.setOpaque(true);

        JButton restartButton = new JButton();
        restartButton.setText("Restart?"); ////////////////////button no work yet
        restartButton.setBounds(300, 300, 100, 100);
//        restartButton.setAction(this.setGameOver(true));
        restartButton.setEnabled(false);
        restartButton.setVisible(false);

        this.add(restartButton);
        this.add(playerSprite);

        this.setVisible(true);
    }



    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W -> {
                // logic for jumping up?
            }// does a thing when W pressed
            case KeyEvent.VK_S -> {
                //falling through platforms (maybe too ambitious)
            }
            case KeyEvent.VK_A -> {
                //moving left
            }
            case KeyEvent.VK_D -> {
                //moving right

            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // logic for falling down?
    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

} //GameFrame class