package pacman_2;

/**
 *
 * @author Agape Arimatea
 */
public abstract class Character extends Master implements Movement {

    protected String name;
    protected int movementSpeed;
    protected String imgUrl;

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getName() {
        return name;
    }

    public int getMovementSpeed() {
        return movementSpeed;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMovementSpeed(int movementSpeed) {
        this.movementSpeed = movementSpeed;
    }
}
