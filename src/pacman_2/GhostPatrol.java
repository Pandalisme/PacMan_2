package pacman_2;

import java.awt.geom.Area;
import java.util.Random;
import static pacman_2.Ghost.MOVE_DOWN;
import static pacman_2.Ghost.MOVE_LEFT;
import static pacman_2.Ghost.MOVE_RIGHT;
import static pacman_2.Ghost.MOVE_UP;

/**
 *
 * @author Agape Arimatea
 */
public class GhostPatrol extends Ghost implements Runnable {
	
	private int direction=0;

    private int posX;
    private int posY;
    
    public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public GhostPatrol() {

    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }
    
    private boolean isIntersectsPlayer() {
    	Area ghostArea = new Area(this.getBounds());
    	Area pacmanArea = new Area(Main.lblPacmanIcon.getBounds());
    	return ghostArea.intersects(pacmanArea.getBounds2D());
    }

    @Override
    public void run() {
        posX = this.getX();
        posY = this.getY();

        while (true) {
            switch (direction) {
                case MOVE_UP:
                    posY--;
                    break;
                case MOVE_RIGHT:
                    posX++;
                    break;
                case MOVE_DOWN:
                    posY++;
                    break;
                case MOVE_LEFT:
                    posX--;
                    break;

            }
            
            if (posX < 11) {
                posX++;
            } else if (posX > 412) {
                posX--;
            } else if (posY < 55) {
                posY++;
            } else if (posY > 505) {
                posY--;
            }
            
            if(isIntersectsPlayer() && this.isGhostRun()) {
            	this.setPosX(178);
            	this.setPosY(275);
            }
            
            this.setLocation(posX, posY);
            repaint();

            try {
                Thread.sleep(15);
            } catch (InterruptedException ex) {
                System.out.println(System.err);
            }

        }

    }
}
