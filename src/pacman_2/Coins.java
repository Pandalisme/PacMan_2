/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacman_2;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author User
 */
public class Coins extends JLabel{
    private int points;
    
    public Coins(int x, int y){
        show();
        this.setLocation(x, y);
        this.setSize(5, 5);
        
    }
    
    public Coins(int x, int y, int a, int b){
        show();
        this.setBounds(x, y, a, b);
    }
    
    

    private Image resizeImage(String url, int width, int height) {
        Image dimg = null;
        try {
            BufferedImage img = ImageIO.read(new File(url));
            dimg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        } catch (IOException ex) {
            ex.printStackTrace(System.err);
        }
        return dimg;
    }
    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
    
    public void show(){
        this.setIcon(new ImageIcon(resizeImage("D:\\Latihan\\SP 1\\PBO\\PacMan_2\\coin.png", 8, 8)));
    }
}
