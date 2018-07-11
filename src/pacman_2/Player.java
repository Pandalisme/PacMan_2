package pacman_2;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JLabel;
import java.io.*;
import javax.imageio.ImageIO;

/**
 *
 * @author Agape Arimatea
 */
public class Player extends Character implements Runnable{

    private int points;
    private int life;
    private boolean powerUp;
    int arah = 3;

    public Player() {
        this.arah = arah;
    }

    //Action-Methods
    public void eat(Character target) {
        if (target instanceof GhostHoming || target instanceof GhostPatrol) {
            setLife(getLife() - 1);
            isDead();
        } else {
            hitungPoint(target.name);
        }
    }

    public void hitungPoint(String target) {
        if (target == "Coin") {
            setPoints(getPoints() + 100);
        } else if (target == "Cherry") {
            setPoints(getPoints() + 250);
        }
    }

    public void showPoint() {
        System.out.println("Score : " + getPoints());
    }

    public boolean isDead() {
        if (getLife() == 0) {
            return true;
        } else {
            return false;
        }
    }

    //Getter-Setter
    public int getPoints() {
        return points;
    }

    public int getLife() {
        return life;
    }

    public boolean isPowerUp() {
        return powerUp;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public void setPowerUp(boolean isPowerUp) {
        this.powerUp = isPowerUp;
    }

    @Override
    public void run() {
        int x = this.getX();
        int y = this.getY();
        this.setVisible(true);

        for (int i = 0;; i++) {
            if (arah == 0) {
                y -= 1;
            } else if (arah == 1) {
                y += 1;
            } else if (arah == 2){
                x -= 1;
            } else {
                x += 1;
            }
            this.setLocation(x, y);
            repaint();

            try {
                Thread.sleep(12);
            } catch (InterruptedException ex) {
                System.out.println(System.err);
            }
        }

    }
}
