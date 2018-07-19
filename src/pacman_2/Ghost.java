package pacman_2;

import java.util.Timer;
import java.util.TimerTask;

public class Ghost extends Character implements Runnable{

    private boolean ghostRunning = false;
	public static final int MOVE_UP = 0;
	public static final int MOVE_RIGHT = 1;
	public static final int MOVE_DOWN = 2;
	public static final int MOVE_LEFT = 3;

	private static int timerCounter = 0;
//	public void dead() {
//		this.coordinateX = 0;
//		this.coordinateY = 0;
//	}
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

    // Use this method when player is powering up or not
    // It decides when the player can eat the ghost?
    public boolean isGhostRun() {
        if (ghostRunning == true) {
            return true;

        } else {
            return false;
        }
    }

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
