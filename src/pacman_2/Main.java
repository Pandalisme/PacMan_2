package pacman_2;

import java.awt.*;
//import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import javax.swing.*;
import java.io.*;
import javax.imageio.ImageIO;

/**
 *
 * @author Agape Arimatea - Michael Nathaniel
 */
public class Main extends JFrame implements KeyListener {

    private JPanel pnlMap;

    private JPanel pnlMenu;
    private JLabel lblMenu;

    private JLabel lblLife;
    private JLabel lblTitleScore;
    private JLabel lblScore;
    private JLabel lblAlias;

//    private JLabel lblPacmanIcon;
    private JLabel lblBlinkyIcon;
    private JLabel lblPinkyIcon;
    private JLabel lblInkyIcon;
    private JLabel lblClydeIcon;
    
    private Player lblPacmanIcon;

    public Main() {
        initComponents();
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

    public void initComponents() {
        setTitle("Pac-Man");
        setResizable(false);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setSize(464, 615);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.black);
        try {
            this.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("D:\\Latihan\\SP 1\\PBO\\PacMan_2\\Pac-man - Copy.png")))));
        } catch (IOException ex) {
            ex.printStackTrace(System.err);
        }
        getContentPane().setLayout(null);
        
        pnlMenu = new JPanel();
        pnlMenu.setBounds(0, 0, 464, 615);
        pnlMenu.setBackground(Color.black);
        pnlMenu.setLayout(null);
        pnlMenu.addKeyListener(this);
        pnlMenu.setFocusable(true);
        add(pnlMenu);

        lblMenu = new JLabel("Press any key to start");
        lblMenu.setForeground(Color.white);
        lblMenu.setFont(new Font("Emulogic", Font.PLAIN, 18));
        lblMenu.setBounds(30, 10, 400, 615);
        lblMenu.setVisible(true);
        pnlMenu.add(lblMenu);
        
        pnlMap = new JPanel();
        pnlMap.setOpaque(false);
        pnlMap.setLayout(null);
        pnlMap.setBounds(0, 0, 464, 615);
        pnlMap.setFocusable(true);
        pnlMap.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int x = lblPacmanIcon.getX();
                int y = lblPacmanIcon.getY();
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP: {
                        y -= 1;
                        lblPacmanIcon.arah = 0;
                        repaint();
                        break;
                    }
                    case KeyEvent.VK_DOWN: {
                        y += 1;
                        lblPacmanIcon.arah = 1;
                        repaint();
                        break;
                    }
                    case KeyEvent.VK_LEFT: {
                        x -= 1;
                        lblPacmanIcon.arah = 2;
                        repaint();
                        break;
                    } case KeyEvent.VK_RIGHT: {
                        x += 1;
                        lblPacmanIcon.arah = 3;
                        repaint();
                        break;
                    } 
                    default:
                        break;
                }
                lblPacmanIcon.setLocation(x, y);
            }
        });
        add(pnlMap);

        lblLife = new JLabel("Life : ");
        lblLife.setForeground(Color.white);
        lblLife.setFont(new Font("Emulogic", Font.PLAIN, 12));
        lblLife.setBounds(8, 541, 90, 50);
        pnlMap.add(lblLife);

        lblTitleScore = new JLabel("Score");
        lblTitleScore.setForeground(Color.white);
        lblTitleScore.setFont(new Font("Emulogic", Font.PLAIN, 18));
        lblTitleScore.setBounds(10, 10, 120, 35);
        pnlMap.add(lblTitleScore);

        lblScore = new JLabel("123");
        lblScore.setForeground(Color.white);
        lblScore.setFont(new Font("Emulogic", Font.PLAIN, 18));
        lblScore.setBounds(200, 10, 140, 35);
        pnlMap.add(lblScore);

        lblAlias = new JLabel("Pac");
        lblAlias.setForeground(Color.white);
        lblAlias.setFont(new Font("Emulogic", Font.PLAIN, 18));
        lblAlias.setBounds(353, 10, 120, 35);
        pnlMap.add(lblAlias);

        lblPacmanIcon = new Player();
        lblPacmanIcon.setIcon(new ImageIcon(resizeImage("D:\\Latihan\\SP 1\\PBO\\PacMan_2\\pac_man_chara.png", 25, 25)));
        lblPacmanIcon.setBounds(50, 59, 25, 30);
        pnlMap.add(lblPacmanIcon);

        
        
        lblBlinkyIcon = new JLabel();
        lblBlinkyIcon.setIcon(new ImageIcon(resizeImage("D:\\Latihan\\SP 1\\PBO\\PacMan_2\\blinky.png", 25, 25)));
        lblBlinkyIcon.setBounds(185,280,25,30);
        pnlMap.add(lblBlinkyIcon);
        
        lblPinkyIcon = new JLabel();
        lblPinkyIcon.setIcon(new ImageIcon(resizeImage("D:\\Latihan\\SP 1\\PBO\\PacMan_2\\pinky.png", 25, 25)));
        lblPinkyIcon.setBounds(205,260,25,30);
        pnlMap.add(lblPinkyIcon);
        
        lblInkyIcon = new JLabel();
        lblInkyIcon.setIcon(new ImageIcon(resizeImage("D:\\Latihan\\SP 1\\PBO\\PacMan_2\\inky.png", 25, 25)));
        lblInkyIcon.setBounds(230,280,25,30);
        pnlMap.add(lblInkyIcon);
        
        lblClydeIcon = new JLabel();
        lblClydeIcon.setIcon(new ImageIcon(resizeImage("D:\\Latihan\\SP 1\\PBO\\PacMan_2\\clyde.png", 25, 25)));
        lblClydeIcon.setBounds(250,260,25,30);
        pnlMap.add(lblClydeIcon);

        
        
        Thread pacmanThread = new Thread(lblPacmanIcon);
        pacmanThread.start();
        
//        System.out.println(lblPacmanIcon.getX());
    }

    public static void main(String[] args) {
        new Main().setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        pnlMenu.hide();
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
