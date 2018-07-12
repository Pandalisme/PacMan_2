package pacman_2;

import java.util.Random;

public class GhostMovementHandler extends GhostPatrol implements Runnable {

	Random rnTime = new Random();
	Random rnDirection = new Random();
	private GhostPatrol ghost;

	public GhostMovementHandler(GhostPatrol ghost_name) {
		this.ghost = ghost_name;
		Thread ghost_thread = new Thread(ghost_name);
		ghost_thread.start();

	
	}
	@Override
	public void run() {

		while (true) {

			int time = rnTime.nextInt(2000)+500;
			int direction = rnDirection.nextInt(4);
			ghost.setDirection(direction);
			
			try {
				Thread.sleep(time);
			} catch (InterruptedException ex) {
				System.out.println(System.err);
			}

		}

	}

}
