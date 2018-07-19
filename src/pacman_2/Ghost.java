package pacman_2;

import static pacman_2.Main.listWall;

import java.awt.geom.Area;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Ghost extends Character implements Runnable{

    private boolean ghostRunning = false;
	public static final int MOVE_UP = 0;
	public static final int MOVE_RIGHT = 1;
	public static final int MOVE_DOWN = 2;
	public static final int MOVE_LEFT = 3;

	private static int timerCounter = 0;

    private int direction ;

    private int posX;
    private int posY;
    
    public Ghost() {

    }
    
    //Make the ghost run when player eats powerUp.
    public void setGhostRun(int time) {
        ghostRunning = true;
        System.out.println("Ghost is Running!");
        Timer ghostTimer = new Timer();
        timerCounter = time;
        TimerTask tt = new TimerTask() {

			@Override
			public void run() {
				timerCounter--;
				if(timerCounter <= 0 ) {
			        System.out.println("Ghost is not Running!");
			        ghostRunning = false;
					ghostTimer.cancel();
				}
			}
        };
        ghostTimer.scheduleAtFixedRate(tt, 0, 1000);
        

    }
    
    public boolean isGhostRun() {
        if (ghostRunning == true) {
            return true;

        } else {
            return false;
        }
    }


    
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

    
    //Areas
    public boolean isIntersectsWall(int i) {
        Area areaA = new Area(this.getBounds());
        Area areaB = new Area(listWall.get(i).getBounds());

        return areaA.intersects(areaB.getBounds2D());
        
    }
    public boolean isIntersectsOuterWall() {
        if(this.getPosY() <= 55 || this.getPosY() >= 510 ) {
        	return true;
        }else if(this.getPosX() <= 11 || this.getPosX() >= 412) {
        	return true;
        }
        return false;
    }

	@Override
	public void run() {
		posX = this.getX();
        posY = this.getY();

        while (true) {
            switch (this.direction) {
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
