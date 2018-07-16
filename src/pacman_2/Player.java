package pacman_2;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Area;
import javax.swing.JLabel;
import java.io.*;
import javax.imageio.ImageIO;
import static pacman_2.Main.lblPacmanIcon;
import static pacman_2.Main.listGhost;
import static pacman_2.Main.lblLifePoint;

/**
 *
 * @author Agape Arimatea
 */
public class Player extends Character implements Runnable {

    private int points;
    private int life = 3;
    private int prev_life = life;
    private boolean powerUp;
    private int cooldownTime = 2000;
    private boolean cooldown = false;
    int arah = 3;
    int prev_arah;

    public Player() {
//        prev_arah = this.arah;
        this.arah = arah;
    }

    //Action-Methods

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

    public boolean intersectsGhost(int i) {
        Area areaA = new Area(lblPacmanIcon.getBounds());
        Area areaB = new Area(listGhost.get(i).getBounds());

        return areaA.intersects(areaB.getBounds2D());
    }

    @Override
    public void run() {
        int x = this.getX();
        int y = this.getY();
        this.setVisible(true);

        for (int i = 0;; i++) {
            if (cooldownTime == i) {
                cooldown = false;
                System.out.println("cooldown status : " + cooldown);
            }
            
            if (arah == 0) {
                y -= 1;
            } else if (arah == 1) {
                y += 1;
            } else if (arah == 2) {
                x -= 1;
            } else {
                x += 1;
            }

            if (x < 11) {
                x++;
            } else if (x > 412) {
                x--;
            } else if (y < 55) {
                y++;
            } else if (y > 505) {
                y--;
            }

            if (intersectsGhost(0) && !cooldown) {
                cooldown = true;
                System.out.println("Collide with Blinky! : " + i);
                setLife(getLife() - 1);
                cooldownTime = i + 400;
                System.out.println("Life : " + getLife());
            } else if (intersectsGhost(1) && !cooldown) {
                cooldown = true;
                System.out.println("Collide with Inky!   : " + i);
                setLife(getLife() - 1);
                System.out.println("Life : " + getLife());
                cooldownTime = i + 400;
            } else if (intersectsGhost(2) && !cooldown) {
                cooldown = true;
                System.out.println("Collide with Clyde!  : " + i);
                setLife(getLife() - 1);
                System.out.println("Life : " + getLife());
                cooldownTime = i + 400;
            }

            lblLifePoint.setText(String.valueOf(getLife()));

            this.setLocation(x, y);
            repaint();

            try {
                Thread.sleep(11);
            } catch (InterruptedException ex) {
                System.out.println(System.err);
            }
        }

    }
}
