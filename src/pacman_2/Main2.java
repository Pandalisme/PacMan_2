package pacman_2;

import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.image.BufferedImage;
import javax.swing.*;
//import java.io.*;
//import javax.imageio.ImageIO;


/**
 *
 * @author Agape Arimatea
 */
public class Main2 extends JFrame{
    
    private JPanel pnlMap;
    
    private JPanel pnlLife;
    private JLabel lblLife;
    private JPanel pnlTitleScore;
    private JLabel lblTitleScore;
    private JPanel pnlScore;
    private JLabel lblScore;
    private JPanel pnlAlias;
    private JLabel lblAlias;
    
    private JPanel pnlPacmanIcon;
    private JLabel lblPacmanIcon;
    
    private JPanel pnlBlinkyIcon;
    private JLabel lblBlinkyIcon;
    private JPanel pnlPinkyIcon;
    private JLabel lblPinkyIcon;
    private JPanel pnlInkyIcon;
    private JLabel lblInkyIcon;
    private JPanel pnlClydeIcon;
    private JLabel lblClydeIcon;
    
    public Main2(){
        initComponents();
    }
   
    
    public void initComponents(){
        setTitle("Pac-Man");
//        setResizable(false);
//        setUndecorated(true);
//        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setSize(464,615);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        getContentPane().setBackground(Color.black);

        getContentPane().setLayout(null);
        
        pnlMap = new JPanel();
        pnlMap.setBackground(Color.black);
        pnlMap.setBounds(0,0,464,615);
        pnlMap.setLayout(null);
        add(pnlMap);
        
        lblLife = new JLabel("Life : ");
        lblLife.setForeground(Color.white);
        lblLife.setFont(new Font("Emulogic",Font.PLAIN,12));
        lblLife.setBounds(5,535,90,50);
        pnlMap.add(lblLife);
    }
    
    public static void main(String[] args) {
        new Main2().setVisible(true);
    }
}


// ============================================= DOODLES ============================================================
//    private Image resizeImage(String url){
//        Image dimg = null;
//        try{
//            BufferedImage img = ImageIO.read(new File(url));
//            dimg = img.getScaledInstance(426,547,Image.SCALE_SMOOTH);//426,547
//        } catch (IOException ex){
//            ex.printStackTrace(System.err);
//        }
//        return dimg;
//    }
//        
//        pnlMap = new JPanel();
//        pnlMap.setSize(448,576);
//        pnlMap.setLocation(0,0);
//        pnlMap.setBackground(Color.black);
//        add(pnlMap,BorderLayout.NORTH);
        
//        lblMap = new JLabel("Name : ");
//        pnlMap.add(lblMap);
        
//        txtText1 = new JTextField(10);
//        pnlPanel1.add(txtText1);
        
//        lblMapIcon = new JLabel();
//        lblMapIcon.setIcon(new ImageIcon(resizeImage("D:\\Latihan\\SP 1\\PBO\\PacMan_2\\Pac-man - Copy.png")));
//        lblMapIcon.setLocation(0,0);
//        pnlMap.add(lblMapIcon);