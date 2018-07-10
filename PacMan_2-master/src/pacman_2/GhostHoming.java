package pacman_2;

/**
 *
 * @author Agape Arimatea
 */
public class GhostHoming extends Character {
    @Override
    public void up() {
        coordinateY++;
    }

    @Override
    public void down() {
        coordinateY--;
    }

    @Override
    public void left() {
        coordinateX--;
    }

    @Override
    public void right() {
        coordinateX++;
    }
}
