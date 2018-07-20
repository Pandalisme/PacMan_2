package pacman_2;

import static pacman_2.Main.listWall;

import java.util.Random;

public class GhostMovementHandler extends Ghost implements Runnable {

//	Random rnTime = new Random();
    Random rnDirection = new Random();
    private Ghost ghost;

    public GhostMovementHandler(Ghost ghost_name) {
        this.ghost = ghost_name;
        Thread ghost_thread = new Thread(ghost_name);
        ghost_thread.start();

    }
    
    public void gameOver() {
        isGameOver = true;
    }
    
    @Override
    public void run() {
        int randomedDirection = rnDirection.nextInt(4);

        ghost.setDirection(randomedDirection);

        while (!isGameOver) {

            for (int j = 0; j < listWall.size(); j++) {
                if (ghost.isIntersectsWall(j) || ghost.isIntersectsOuterWall()) {
//                	System.out.println("Ghost collide");
                    if (ghost.getDirection() == MOVE_UP) {
                        ghost.setPosY(ghost.getPosY() + 2);
                        while (randomedDirection == MOVE_UP) {
                            randomedDirection = rnDirection.nextInt(4);
                        }
                    } else if (ghost.getDirection() == MOVE_DOWN) {
                        ghost.setPosY(ghost.getPosY() - 2);
                        while (randomedDirection == MOVE_DOWN) {
                            randomedDirection = rnDirection.nextInt(4);
                        }
                    } else if (ghost.getDirection() == MOVE_LEFT) {
                        ghost.setPosX(ghost.getPosX() + 2);
                        while (randomedDirection == MOVE_LEFT) {
                            randomedDirection = rnDirection.nextInt(4);
                        }
                    } else if (ghost.getDirection() == MOVE_RIGHT) {
                        ghost.setPosX(ghost.getPosX() - 2);
                        while (randomedDirection == MOVE_RIGHT) {
                            randomedDirection = rnDirection.nextInt(4);
                        }
                    }

                }
            }

            ghost.setDirection(randomedDirection);

            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                System.out.println(System.err);
            }

        }

    }

}
