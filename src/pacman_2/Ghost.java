package pacman_2;

public class Ghost extends Character implements Runnable{

    private boolean ghostRunning = false;
	public static final int MOVE_UP = 0;
	public static final int MOVE_RIGHT = 1;
	public static final int MOVE_DOWN = 2;
	public static final int MOVE_LEFT = 3;

//	public void dead() {
//		this.coordinateX = 0;
//		this.coordinateY = 0;
//	}
    //Make the ghost run when player eats powerUp.
    public void setGhostRun() {
//		this.setColor("Blue");
        ghostRunning = true;
        // Movement, run from player
        // How long the ghost run?
        // Set the timer here.
        ghostRunning = false;
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
