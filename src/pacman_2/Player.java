package pacman_2;
import javax.swing.*;

/**
 *
 * @author Agape Arimatea
 */
public class Player extends Character {

    private int points;
    private int life;
    private boolean powerUp;
    
    //Action-Methods
    public void eat(Character target){
        if(target instanceof GhostHoming || target instanceof GhostPatrol) {
            setLife(getLife()-1);
            isDead();
        } else {
            hitungPoint(target.name);
        }
    }
    
    public void hitungPoint(String target){
        if(target == "Coin"){
            setPoints(getPoints()+100);
        } else if (target == "Cherry"){
            setPoints(getPoints()+250);
        }
    }
    
    public void showPoint(){
        System.out.println("Score : " + getPoints());
    }
    
    public boolean isDead(){
        if(getLife() == 0){
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

}
