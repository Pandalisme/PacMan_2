package pacman_2;

import java.awt.geom.Area;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

//Audio
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

//Attributes from Main
import static pacman_2.Main.coinsCounter;
import static pacman_2.Main.lblPacmanIcon;
import static pacman_2.Main.listGhost;
import static pacman_2.Main.lblLifePoint;
import static pacman_2.Main.lblScore;
import static pacman_2.Main.listCoins;
import static pacman_2.Main.listWall;

/**
 *
 * @author Agape Arimatea
 */
public class Player extends Character implements Runnable {

    private ScheduledExecutorService startDelay = Executors.newSingleThreadScheduledExecutor();

    private int points;
    private int life = 3;
    private int prev_life = life;
    private boolean powerUp;
    private int cooldownTime = 2000;
    private boolean cooldown = false;
    
    int arah = 3;
    int prev_arah;
    int tempX;
    int tempY;
    int i = 0;
    
    private boolean isGameOver;
    private Point prevPosition;
    private Clip siren;

    /**
     *
     */
    public Player() throws UnsupportedAudioFileException, IOException, LineUnavailableException { //exception harus di include
//        prev_arah = this.arah;
        this.arah = arah;

        //inisialisasi audio
        File pac_siren = new File("sounds/Pacman_Siren.wav");
        AudioInputStream audioSiren = AudioSystem.getAudioInputStream(pac_siren); //Action-Methods
        siren = AudioSystem.getClip();
        siren.open(audioSiren);
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

    public boolean intersectsGhost(int i) {
        Area areaA = new Area(lblPacmanIcon.getBounds());
        Area areaB = new Area(listGhost.get(i).getBounds());

        return areaA.intersects(areaB.getBounds2D());
    }

    public boolean intersectsCoins(int i) {
        Area areaA = new Area(lblPacmanIcon.getBounds());
        Area areaB = new Area(listCoins.get(i).getBounds());

        return areaA.intersects(areaB.getBounds2D());
    }

    public boolean intersectsWall(int i) {
        Area areaA = new Area(lblPacmanIcon.getBounds());
        Area areaB = new Area(listWall.get(i).getBounds());

        return areaA.intersects(areaB.getBounds2D());
    }

    public void gameOver() {
        isGameOver = true;
        siren.stop();
        siren.close();
    }

    //thread buat bikin suara pacman makan coin
    //Suara ada yang original tapi ga enak kalo dipake 
    Thread eatSound = new Thread(new Runnable() {
        @Override
        public void run() {
            Clip eat = null;

            File pac_eat = new File("sounds/Beep1.wav");

            AudioInputStream audioSiren;
            try {
                audioSiren = AudioSystem.getAudioInputStream(pac_eat); //Action-Methods
                eat = AudioSystem.getClip();
                eat.open(audioSiren);
                System.out.println("Success");

            } catch (UnsupportedAudioFileException ex) {
                Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
            } catch (LineUnavailableException ex) {
                Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
            }

            while (!isGameOver) {
                for (int j = 0; j < listCoins.size(); j++) {
                    if (intersectsCoins(j)) {
                        if (listCoins.get(j).isShowing() == true) {
                            eat.start();
                            eat.loop(1);
                        }
                    }
                }
            }
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    });

    @Override
    public void run() {
        int x = this.getX();
        int y = this.getY();
        this.setVisible(true);

        isGameOver = false;

        startDelay.schedule(eatSound, 1, TimeUnit.SECONDS);
        while (!isGameOver) {

            //suara pacman jalan
            siren.start();
            siren.loop(Clip.LOOP_CONTINUOUSLY);

            int xwall = 0, ywall = 0;
            if (cooldownTime == i) {
                cooldown = false;
                System.out.println("cooldown status : " + cooldown);
            }

            if (arah == 0) {
                tempY = lblPacmanIcon.getY()+1;
                y -= 1;
            } else if (arah == 1) {
                tempY = lblPacmanIcon.getY()-1;
                y += 1;
            } else if (arah == 2) {
                tempX = lblPacmanIcon.getX()+1;
                x -= 1;
            } else {
                tempX = lblPacmanIcon.getX()-1;
                x += 1;
            }

            if (x < 11) {
                if (y > 255 && y < 273) {
                    x = 411;
                } else {
                    x++;
                    siren.stop();
                }
            } else if (x > 412) {
                if (y > 255 && y < 273) {
                    x = 12;
                } else {
                    x--;
                    siren.stop();
                }
            } else if (y < 55) {
                y++;
                siren.stop();
            } else if (y > 510) {
                y--;
                siren.stop();
            }

            if (intersectsGhost(0) && cooldown == false) {
                listGhost.get(0).setVisible(false);
                cooldown = true;
                System.out.println("Collide with Blinky! : " + i);
                life--;
                System.out.println("Life : " + life);
                cooldownTime = i + 400;
                listGhost.get(0).setVisible(true);
                System.out.println("Cooldown : " + cooldownTime);

            } else if (intersectsGhost(1) && cooldown == false) {
                listGhost.get(1).setVisible(false);
                cooldown = true;
                System.out.println("Collide with Inky!   : " + i);
                life--;
                System.out.println("Life : " + life);
                cooldownTime = i + 400;
                System.out.println("Cooldown : " + cooldownTime);
                listGhost.get(1).setVisible(true);
            } else if (intersectsGhost(2) && cooldown == false) {
                listGhost.get(2).setVisible(false);
                cooldown = true;
                System.out.println("Collide with Clyde!  : " + i);
                life--;
                System.out.println("Life : " + life);
                cooldownTime = i + 400;
                System.out.println("Cooldown : " + cooldownTime);
                listGhost.get(2).setVisible(true);
            }

            lblLifePoint.setText(String.valueOf(life));

            for (int j = 0; j < listCoins.size(); j++) {
                if (intersectsCoins(j)) {
                    if (listCoins.get(j).isShowing() == true) {
                        points += 100;
                        coinsCounter--;
                        System.out.println("+Points : " + j);
                        listCoins.get(j).setVisible(false);
                        lblScore.setText(String.valueOf(points));
                    }
                }
            }

            for (int j = 0; j < listWall.size(); j++) {
                if (intersectsWall(j)) {
//                    System.out.println("Nabrak");
                    if (arah == 0) {
                        y++;
                    } else if (arah == 1) {
                        y--;
                    } else if (arah == 2) {
                        x++;
                    } else if (arah == 3) {
                        x--;
                    }
                    x = tempX;
                    y = tempY;
                }
            }

            this.setLocation(x, y);
            repaint();

            try {
                Thread.sleep(12);
            } catch (InterruptedException ex) {
                System.out.println(System.err);
            }
            i++;
        }

    }
}
