package pacman_2;

import java.util.List;
import java.awt.*;
import java.awt.event.ActionEvent;
//import java.awt.event.ActionEvent;
import java.util.Arrays;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.imageio.ImageIO;

/**
 *
 * @author Pacman Group
 */
public class Main extends JFrame implements KeyListener, ActionListener{

    public static List<GhostPatrol> listGhost = new ArrayList<>();
    private Main main;
    private JPanel pnlMap;

    private JPanel pnlMenu;
    private JLabel lblMenu;
    private JLabel lblTitle;

    private JLabel lblLife;
    public static JLabel lblLifePoint = new JLabel("3");
    private JLabel lblTitleScore;
    public static JLabel lblScore;
    private JLabel lblAlias;

    public static Player lblPacmanIcon = new Player();

    // private JLabel lblPacmanIcon;
    private GhostHoming lblPinkyIcon;
    private GhostPatrol lblBlinkyIcon;
    private GhostMovementHandler blinkyMH;
    private GhostPatrol lblInkyIcon;
    private GhostMovementHandler inkyMH;
    private GhostPatrol lblClydeIcon;
    private GhostMovementHandler clydeMH;

    //Blinking effect -- Press any key
    private java.awt.Color color1 = java.awt.Color.yellow;
    private java.awt.Color color2 = java.awt.Color.white;
    private int count;
    private Timer timerBlink;

    private ScheduledExecutorService startDelay = Executors.newSingleThreadScheduledExecutor();

    // private coins
    private Coins coin;
    public static ArrayList<Coins> listCoins = new ArrayList<>();

    //Threads
    public static Thread pacmanThread;
    public static Thread blinkytHandler;
    public static Thread inkyHandler;
    public Thread clydeHandler;

    Font mainFont = null;

    public Main() {
        initComponents();
        timerBlink = new Timer(700, Main.this);

        timerBlink.start();

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
        setUndecorated(true);
        setSize(448, 576);
        setSize(448, 576);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.black);
        int stat;

        //Registering external Fonts
        try {
            BufferedInputStream fontFileStream = new BufferedInputStream(new FileInputStream("fonts/emulogic.ttf"));
            mainFont = Font.createFont(Font.TRUETYPE_FONT, fontFileStream);

            GraphicsEnvironment genv = GraphicsEnvironment.getLocalGraphicsEnvironment();
            genv.registerFont(mainFont);

            mainFont = mainFont.deriveFont(12f);
            System.out.println("Font loaded.");

        } catch (IOException | FontFormatException ex) {
            System.out.println("Error : " + ex.getMessage());
        }
        try {
            this.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("picture/map.png")))));
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

        lblTitle = new JLabel("PACMAN");
        lblTitle.setForeground(Color.white);
        lblTitle.setFont(mainFont.deriveFont(32f));
        lblTitle.setVisible(true);
        lblTitle.setBounds(120, 160, 300, 100);
        pnlMenu.add(lblTitle);

        lblMenu = new JLabel("Press any key to start");
        lblMenu.setForeground(Color.white);
        lblMenu.setFont(mainFont.deriveFont(12f));
        lblMenu.setBounds(90, 10, 400, 615);
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
                        if (y > 55) {
                            lblPacmanIcon.arah = 0;
                            lblPacmanIcon.prev_arah = lblPacmanIcon.arah;
                        } else {
                            lblPacmanIcon.arah = lblPacmanIcon.prev_arah;
                        }
                        repaint();
                        break;
                    }
                    case KeyEvent.VK_DOWN: {
                        y += 1;
                        if (y < 505) {
                            lblPacmanIcon.arah = 1;
                            lblPacmanIcon.prev_arah = lblPacmanIcon.arah;
                        } else {
                            lblPacmanIcon.arah = lblPacmanIcon.prev_arah;
                        }

                        repaint();
                        break;
                    }
                    case KeyEvent.VK_LEFT: {
                        x -= 1;
                        if (x > 11) {
                            lblPacmanIcon.arah = 2;
                            lblPacmanIcon.prev_arah = lblPacmanIcon.arah;
                        } else {
                            lblPacmanIcon.arah = lblPacmanIcon.prev_arah;
                        }
                        repaint();
                        break;
                    }
                    case KeyEvent.VK_RIGHT: {
                        x += 1;
                        if (x < 412) {
                            lblPacmanIcon.arah = 3;
                            lblPacmanIcon.prev_arah = lblPacmanIcon.arah;
                        } else {
                            lblPacmanIcon.arah = lblPacmanIcon.prev_arah;
                        }
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
        lblLife.setFont(mainFont.deriveFont(12f));
        lblLife.setBounds(13, 534, 90, 50);
        pnlMap.add(lblLife);

        lblLifePoint.setForeground(Color.white);
        lblLifePoint.setFont(mainFont.deriveFont(12f));
        lblLifePoint.setBounds(113, 534, 90, 50);
        pnlMap.add(lblLifePoint);

        lblTitleScore = new JLabel("Score");
        lblTitleScore.setForeground(Color.white);
        lblTitleScore.setFont(mainFont.deriveFont(18f));
        lblTitleScore.setBounds(15, 7, 120, 35);
        pnlMap.add(lblTitleScore);

        lblScore = new JLabel("0");
        lblScore.setForeground(Color.white);
        lblScore.setFont(mainFont.deriveFont(18f));
        lblScore.setBounds(195, 7, 140, 35);
        pnlMap.add(lblScore);

        lblAlias = new JLabel("Pac");
        lblAlias.setForeground(Color.white);
        lblAlias.setFont(mainFont.deriveFont(18f));
        lblAlias.setBounds(358, 7, 120, 35);
        pnlMap.add(lblAlias);

        lblPacmanIcon.setIcon(new ImageIcon(resizeImage("picture/pacman.png", 25, 25)));
        lblPacmanIcon.setBounds(11, 263, 25, 25);
        lblPacmanIcon.setDoubleBuffered(true);
        pnlMap.add(lblPacmanIcon);

        lblPinkyIcon = new GhostHoming();
        lblPinkyIcon.setIcon(new ImageIcon(resizeImage("picture/pinky.png", 25, 25)));
        lblPinkyIcon.setBounds(202, 255, 25, 30);
        pnlMap.add(lblPinkyIcon);

        lblBlinkyIcon = new GhostPatrol();
        lblBlinkyIcon.setIcon(new ImageIcon(resizeImage("picture/blinky.png", 25, 25)));
        lblBlinkyIcon.setBounds(178, 275, 25, 30);
        pnlMap.add(lblBlinkyIcon);
        blinkyMH = new GhostMovementHandler(lblBlinkyIcon);

        lblInkyIcon = new GhostPatrol();
        lblInkyIcon.setIcon(new ImageIcon(resizeImage("picture/inky.png", 25, 25)));
        lblInkyIcon.setBounds(228, 275, 25, 30);
        pnlMap.add(lblInkyIcon);
        inkyMH = new GhostMovementHandler(lblInkyIcon);

        lblClydeIcon = new GhostPatrol();
        lblClydeIcon.setIcon(new ImageIcon(resizeImage("picture/clyde.png", 25, 25)));
        lblClydeIcon.setBounds(247, 255, 25, 30);
        pnlMap.add(lblClydeIcon);
        clydeMH = new GhostMovementHandler(lblClydeIcon);

        listGhost.add(lblBlinkyIcon);
        listGhost.add(lblInkyIcon);
        listGhost.add(lblClydeIcon);

        pacmanThread = new Thread(lblPacmanIcon);
        blinkytHandler = new Thread(blinkyMH);
        inkyHandler = new Thread(inkyMH);
        clydeHandler = new Thread(clydeMH);
        Thread mainThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    if (lblPacmanIcon.getLife() <= 0) {
                        lblPacmanIcon.gameOver();
                        pnlMap.setFocusable(false);
                    }
                    try {
                        Thread.sleep (10);
                    }
                    catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        mainThread.start();

        pacmanThread.start();
        blinkytHandler.start();
        inkyHandler.start();
        clydeHandler.start();

        //Set posisi coin dan wall
        //array 2 dimensi posisi dari label coin dan wall pada map
        int[][] temp = new int[23][21];
        for (int i = 0; i < 23; i++) {
            Arrays.fill(temp[i], 1);
        }

        //set posisi wall baris 1-9
        for (int i = 1; i < 10; i++) {
            if (i != 3 && i != 6) {
                //kiri
                for (int j = 1; j < 4; j++) {
                    temp[i][j] = 0;
                }
                //kanan
                for (int j = 17; j < 20; j++) {
                    temp[i][j] = 0;
                }
            }

            //sisi kanan
            if (i == 1 || i == 2) {
                for (int j = 5; j < 9; j++) {
                    temp[i][j] = 0;
                }
                for (int j = 12; j < 16; j++) {
                    temp[i][j] = 0;
                }
            }

            //wall paling ujung2 kanan dan kiri
            if (i == 7 || i == 8 || i == 9) {
                temp[i][0] = 0;
                temp[i][20] = 0;
            }

            //tengah kosong
            if (i >= 4) {
                for (int j = 5; j < 16; j++) {
                    temp[i][j] = 2;
                }
            }

        }

        //baris 11 
        for (int i = 0; i < 21; i++) {
            temp[10][i] = 2;
        }

        //set posisi wall baris 12-21
        for (int i = 11; i < 22; i++) {
            if (i < 15) {
                //kiri
                for (int j = 0; j < 4; j++) {
                    temp[i][j] = 0;
                }
                //kanan
                for (int j = 17; j < 21; j++) {
                    temp[i][j] = 0;
                }
            }
            //tengah kosong
            if (i < 15) {
                for (int j = 5; j < 16; j++) {
                    temp[i][j] = 2;
                }
            } else if (i >= 15 && i < 22) {
                if (i == 16) {
                    //kiri
                    for (int j = 1; j < 4; j++) {
                        temp[i][j] = 0;
                    }
                    for (int j = 5; j < 9; j++) {
                        temp[i][j] = 0;
                    }
                    //kanan
                    for (int j = 17; j < 20; j++) {
                        temp[i][j] = 0;
                    }
                    for (int j = 12; j < 16; j++) {
                        temp[i][j] = 0;
                    }
                } else if (i == 17) {
                    //kiri
                    for (int j = 1; j < 20; j++) {
                        if (j == 3 || j == 17) {
                            temp[i][j] = 0;
                        }
                    }
                } else if (i == 18) {
                    //kiri
                    for (int j = 0; j < 8; j++) {
                        if (j == 2 || j == 4 || j == 6) {
                            temp[i][j] = 1;
                        } else {
                            temp[i][j] = 0;
                        }
                    }
                    for (int j = 8; j < 21; j++) {
                        if (j == 14 || j == 16 || j == 18) {
                            temp[i][j] = 1;
                        } else {
                            temp[i][j] = 0;
                        }
                    }
                } else if (i == 19) {
                    for (int j = 5; j < 16; j++) {
                        if (j == 5 || j == 10 || j == 15) {
                            temp[i][j] = 0;
                        }
                    }
                } else if (i == 20) {
                    for (int j = 1; j < 9; j++) {
                        temp[i][j] = 0;
                    }
                    for (int j = 10; j < 20; j++) {
                        if (j == 11) {
                            temp[i][j] = 1;
                        } else {
                            temp[i][j] = 0;
                        }
                    }
                } else if (i == 21) {
                    for (int j = 1; j < 20; j++) {
                        if (j == 9 || j == 11) {
                            temp[i][j] = 1;
                        } else {
                            temp[i][j] = 0;
                        }

                    }
                }
            }
        }

        //wall tengah baris 1 - 3
        for (int i = 0; i < 3; i++) {
            temp[i][10] = 0;
        }

        temp[15][10] = 0;
        temp[16][10] = 0;

        //print coin
        int y1 = 70;
        for (int i = 0; i < 23; i++) {
            int x1 = 20;
            for (int j = 0; j < 21; j++) {
                //coin
                if (temp[i][j] == 1) {
                    coin = new Coins(x1, y1);
                    pnlMap.add(coin);
                    listCoins.add(coin);
                } else if (temp[i][j] == 0) {
                    //tembok
                    JLabel wall = new JLabel();
                    wall.setBounds(x1 - 4, y1 - 4, 10, 10);
                    wall.setIcon(new ImageIcon("picture/testwall.png"));
                    pnlMap.add(wall);
                }
                if (j == 10) {
                    x1 += 25;
                } else {
                    x1 += 20;
                }

            }
            if (i == 9 || i == 15 || i == 17) {
                y1 += 25;
            } else if (i == 21) {
                y1 += 15;
            } else {
                y1 += 20;
            }
        }
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
        timerBlink.stop();

        Thread pacmanThread = new Thread(lblPacmanIcon);
        startDelay.schedule(pacmanThread, 2, TimeUnit.SECONDS);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (count % 2 == 0) {
            lblMenu.setForeground(color1);
        } else {
            lblMenu.setForeground(color2);
        }
        count++;
    }
}
