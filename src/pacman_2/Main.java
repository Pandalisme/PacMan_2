package pacman_2;

import java.awt.*;
import java.awt.event.ActionEvent;
//import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import javax.swing.*;
import java.io.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Pacman Group
 */
public class Main extends JFrame implements KeyListener, ActionListener {

    private JPanel pnlMap;

    private JPanel pnlMenu;
    private JLabel lblMenu;
    private JLabel lblTitle;

    private JLabel lblLife;
    private JLabel lblTitleScore;
    private JLabel lblScore;
    private JLabel lblAlias;

    private Player lblPacmanIcon;

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
    private Coins coin1;
    private Coins coin2;
    private Coins coin3;
    private Coins coin4;
    private Coins coin5;
    private Coins coin6;
    private Coins coin7;
    private Coins coin8;
    private Coins coin9;
    private Coins coin10;
    private Coins coin11;
    private Coins coin12;
    private Coins coin13;
    private Coins coin14;
    private Coins coin15;
    private Coins coin16;
    private Coins coin17;
    private Coins coin18;
    private Coins coin19;
    private Coins coin20;
    private Coins coin21;
    private Coins coin22;
    private Coins coin23;
    private Coins coin24;
    private Coins coin25;
    private Coins coin26;
    private Coins coin27;
    private Coins coin28;
    private Coins coin29;
    private Coins coin30;
    private Coins coin31;
    private Coins coin32;
    private Coins coin33;
    private Coins coin34;
    private Coins coin35;
    private Coins coin36;
    private Coins coin37;
    private Coins coin38;
    private Coins coin39;
    private Coins coin40;
    private Coins coin41;
    private Coins coin42;
    private Coins coin43;
    private Coins coin44;
    private Coins coin45;
    private Coins coin46;
    private Coins coin47;
    private Coins coin48;
    private Coins coin49;
    private Coins coin50;
    private Coins coin51;
    private Coins coin52;
    private Coins coin53;
    private Coins coin54;
    private Coins coin55;
    private Coins coin56;
    private Coins coin57;
    private Coins coin58;
    private Coins coin59;
    private Coins coin60;
    private Coins coin61;
    private Coins coin62;
    private Coins coin63;
    private Coins coin64;
    private Coins coin65;
    private Coins coin66;
    private Coins coin67;
    private Coins coin68;
    private Coins coin69;
    private Coins coin70;
    private Coins coin71;
    private Coins coin72;
    private Coins coin73;
    private Coins coin74;
    private Coins coin75;
    private Coins coin76;
    private Coins coin77;
    private Coins coin78;
    private Coins coin79;
    private Coins coin80;
    private Coins coin81;
    private Coins coin82;
    private Coins coin83;
    private Coins coin84;
    private Coins coin85;
    private Coins coin86;
    private Coins coin87;
    private Coins coin88;
    private Coins coin89;
    private Coins coin90;
    private Coins coin91;
    private Coins coin92;
    private Coins coin93;
    private Coins coin94;
    private Coins coin95;
    private Coins coin96;
    private Coins coin97;
    private Coins coin98;
    private Coins coin99;
    private Coins coin100;
    private Coins coin101;
    private Coins coin102;
    private Coins coin103;
    private Coins coin104;
    private Coins coin105;
    private Coins coin106;
    private Coins coin107;
    private Coins coin108;
    private Coins coin109;
    private Coins coin110;
    private Coins coin111;
    private Coins coin112;
    private Coins coin113;
    private Coins coin114;
    private Coins coin115;
    private Coins coin116;
    private Coins coin117;
    private Coins coin118;
    private Coins coin119;
    private Coins coin120;
    private Coins coin121;
    private Coins coin122;
    private Coins coin123;
    private Coins coin124;
    private Coins coin125;
    private Coins coin126;
    private Coins coin127;
    private Coins coin128;
    private Coins coin129;
    private Coins coin130;
    private Coins coin131;
    private Coins coin132;
    private Coins coin133;
    private Coins coin134;
    private Coins coin135;
    private Coins coin136;
    private Coins coin137;
    private Coins coin138;
    private Coins coin139;
    private Coins coin140;
    private Coins coin141;
    private Coins coin142;
    private Coins coin143;
    private Coins coin144;
    private Coins coin145;
    private Coins coin146;
    private Coins coin147;
    private Coins coin148;
    private Coins coin149;
    private Coins coin150;
    private Coins coin151;
    private Coins coin152;
    private Coins coin153;
    private Coins coin154;
    private Coins coin155;
    private Coins coin156;
    private Coins coin157;
    private Coins coin158;
    private Coins coin159;
    private Coins coin160;
    private Coins coin161;
    private Coins coin162;
    private Coins coin163;
    private Coins coin164;
    private Coins coin165;
    private Coins coin166;
    private Coins coin167;
    private Coins coin168;
    private Coins coin169;
    private Coins coin170;
    private Coins coin171;
    private Coins coin172;
    private Coins coin173;
    private Coins coin174;
    private Coins coin175;
    private Coins coin176;
    private Coins coin177;
    private Coins coin178;
    private Coins coin179;
    private Coins coin180;
    private Coins coin181;

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
        lblTitle.setFont(new Font("Emulogic", Font.PLAIN, 32));
        lblTitle.setVisible(true);
        lblTitle.setBounds(120, 160, 300, 100);
        pnlMenu.add(lblTitle);

        lblMenu = new JLabel("Press any key to start");
        lblMenu.setForeground(Color.white);
        lblMenu.setFont(new Font("Emulogic", Font.PLAIN, 12));
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
        lblLife.setFont(new Font("Emulogic", Font.PLAIN, 12));
        lblLife.setBounds(13, 534, 90, 50);
        pnlMap.add(lblLife);

        lblTitleScore = new JLabel("Score");
        lblTitleScore.setForeground(Color.white);
        lblTitleScore.setFont(new Font("Emulogic", Font.PLAIN, 18));
        lblTitleScore.setBounds(15, 7, 120, 35);
        pnlMap.add(lblTitleScore);

        lblScore = new JLabel("123");
        lblScore.setForeground(Color.white);
        lblScore.setFont(new Font("Emulogic", Font.PLAIN, 18));
        lblScore.setBounds(195, 7, 140, 35);
        pnlMap.add(lblScore);

        lblAlias = new JLabel("Pac");
        lblAlias.setForeground(Color.white);
        lblAlias.setFont(new Font("Emulogic", Font.PLAIN, 18));
        lblAlias.setBounds(358, 7, 120, 35);
        pnlMap.add(lblAlias);

        lblPacmanIcon = new Player();
        lblPacmanIcon.setIcon(new ImageIcon(resizeImage("picture/pacman.png", 25, 25)));
        lblPacmanIcon.setBounds(11, 55, 25, 30);
        lblPacmanIcon.setDoubleBuffered(true);
        pnlMap.add(lblPacmanIcon);

        lblPinkyIcon = new GhostHoming();
        lblPinkyIcon.setIcon(new ImageIcon(resizeImage("picture/pinky.png", 25, 25)));
        lblPinkyIcon.setBounds(202, 255, 25, 30);
        pnlMap.add(lblPinkyIcon);

        lblBlinkyIcon = new GhostPatrol();
        blinkyMH = new GhostMovementHandler(lblBlinkyIcon);
        lblBlinkyIcon.setIcon(new ImageIcon(resizeImage("picture/blinky.png", 25, 25)));
        lblBlinkyIcon.setBounds(178, 275, 25, 30);
        pnlMap.add(lblBlinkyIcon);

        lblInkyIcon = new GhostPatrol();
        inkyMH = new GhostMovementHandler(lblInkyIcon);
        lblInkyIcon.setIcon(new ImageIcon(resizeImage("picture/inky.png", 25, 25)));
        lblInkyIcon.setBounds(228, 275, 25, 30);
        pnlMap.add(lblInkyIcon);

        lblClydeIcon = new GhostPatrol();
        clydeMH = new GhostMovementHandler(lblClydeIcon);
        lblClydeIcon.setIcon(new ImageIcon(resizeImage("picture/clyde.png", 25, 25)));
        lblClydeIcon.setBounds(247, 255, 25, 30);
        pnlMap.add(lblClydeIcon);

        Thread pacmanThread = new Thread(lblPacmanIcon);
        pacmanThread.start();

        Thread blinkytHandler = new Thread(blinkyMH);
        blinkytHandler.start();

        Thread inkyHandler = new Thread(inkyMH);
        inkyHandler.start();

        Thread clydeHandler = new Thread(clydeMH);
        clydeHandler.start();

        //Set coins
        //row 1
        coin = new Coins(20, 70);
        pnlMap.add(coin);
        coin1 = new Coins(40, 70);
        pnlMap.add(coin1);
        coin2 = new Coins(60, 70);
        pnlMap.add(coin2);
        coin3 = new Coins(80, 70);
        pnlMap.add(coin3);
        coin4 = new Coins(100, 70);
        pnlMap.add(coin4);
        coin5 = new Coins(120, 70);
        pnlMap.add(coin5);
        coin6 = new Coins(140, 70);
        pnlMap.add(coin6);
        coin7 = new Coins(160, 70);
        pnlMap.add(coin7);
        coin8 = new Coins(180, 70);
        pnlMap.add(coin8);
        coin9 = new Coins(200, 70);
        pnlMap.add(coin9);
        coin10 = new Coins(240, 70);
        pnlMap.add(coin10);
        coin11 = new Coins(260, 70);
        pnlMap.add(coin11);
        coin12 = new Coins(280, 70);
        pnlMap.add(coin12);
        coin13 = new Coins(300, 70);
        pnlMap.add(coin13);
        coin14 = new Coins(320, 70);
        pnlMap.add(coin14);
        coin15 = new Coins(340, 70);
        pnlMap.add(coin15);
        coin16 = new Coins(360, 70);
        pnlMap.add(coin16);
        coin17 = new Coins(380, 70);
        pnlMap.add(coin17);
        coin18 = new Coins(400, 70);
        pnlMap.add(coin18);
        coin19 = new Coins(420, 70);
        pnlMap.add(coin19);

        //row2
        coin20 = new Coins(20, 90);
        pnlMap.add(coin20);
        coin21 = new Coins(100, 90);
        pnlMap.add(coin21);
        coin22 = new Coins(200, 90);
        pnlMap.add(coin22);
        coin23 = new Coins(240, 90);
        pnlMap.add(coin23);
        coin24 = new Coins(340, 90);
        pnlMap.add(coin24);
        coin25 = new Coins(420, 90);
        pnlMap.add(coin25);

        //row3
        coin26 = new Coins(20, 110);
        pnlMap.add(coin26);
        coin27 = new Coins(100, 110);
        pnlMap.add(coin27);
        coin28 = new Coins(200, 110);
        pnlMap.add(coin28);
        coin29 = new Coins(240, 110);
        pnlMap.add(coin29);
        coin30 = new Coins(340, 110);
        pnlMap.add(coin30);
        coin31 = new Coins(420, 110);
        pnlMap.add(coin31);
        //row4
        coin32 = new Coins(20, 130);
        pnlMap.add(coin32);
        coin33 = new Coins(40, 130);
        pnlMap.add(coin33);
        coin34 = new Coins(60, 130);
        pnlMap.add(coin34);
        coin35 = new Coins(80, 130);
        pnlMap.add(coin35);
        coin36 = new Coins(100, 130);
        pnlMap.add(coin36);
        coin37 = new Coins(120, 130);
        pnlMap.add(coin37);
        coin38 = new Coins(140, 130);
        pnlMap.add(coin38);
        coin39 = new Coins(160, 130);
        pnlMap.add(coin39);
        coin40 = new Coins(180, 130);
        pnlMap.add(coin40);
        coin41 = new Coins(200, 130);
        pnlMap.add(coin41);
        coin42 = new Coins(220, 130);
        pnlMap.add(coin42);
        coin43 = new Coins(240, 130);
        pnlMap.add(coin43);
        coin44 = new Coins(260, 130);
        pnlMap.add(coin44);
        coin45 = new Coins(280, 130);
        pnlMap.add(coin45);
        coin46 = new Coins(300, 130);
        pnlMap.add(coin46);
        coin47 = new Coins(320, 130);
        pnlMap.add(coin47);
        coin48 = new Coins(340, 130);
        pnlMap.add(coin48);
        coin49 = new Coins(360, 130);
        pnlMap.add(coin49);
        coin50 = new Coins(380, 130);
        pnlMap.add(coin50);
        coin51 = new Coins(400, 130);
        pnlMap.add(coin51);
        coin52 = new Coins(420, 130);
        pnlMap.add(coin52);
        //row5
        coin53 = new Coins(20, 150);
        pnlMap.add(coin53);
        coin54 = new Coins(100, 150);
        pnlMap.add(coin54);
        coin55 = new Coins(340, 150);
        pnlMap.add(coin55);
        coin56 = new Coins(420, 150);
        pnlMap.add(coin56);
        //row6
        coin54 = new Coins(20, 170);
        pnlMap.add(coin54);
        coin55 = new Coins(100, 170);
        pnlMap.add(coin55);
        coin56 = new Coins(340, 170);
        pnlMap.add(coin56);
        coin57 = new Coins(420, 170);
        pnlMap.add(coin57);
        //row7
        coin55 = new Coins(20, 190);
        pnlMap.add(coin55);
        coin56 = new Coins(40, 190);
        pnlMap.add(coin56);
        coin57 = new Coins(60, 190);
        pnlMap.add(coin57);
        coin58 = new Coins(80, 190);
        pnlMap.add(coin58);
        coin59 = new Coins(100, 190);
        pnlMap.add(coin59);
        coin60 = new Coins(340, 190);
        pnlMap.add(coin60);
        coin61 = new Coins(360, 190);
        pnlMap.add(coin61);
        coin62 = new Coins(380, 190);
        pnlMap.add(coin62);
        coin63 = new Coins(400, 190);
        pnlMap.add(coin63);
        coin64 = new Coins(420, 190);
        pnlMap.add(coin64);
        //row8
        coin65 = new Coins(100, 210);
        pnlMap.add(coin65);
        coin66 = new Coins(340, 210);
        pnlMap.add(coin66);
        //row9
        coin67 = new Coins(100, 230);
        pnlMap.add(coin67);
        coin68 = new Coins(340, 230);
        pnlMap.add(coin68);
        //row10
        coin69 = new Coins(100, 250);
        pnlMap.add(coin69);
        coin70 = new Coins(340, 250);
        pnlMap.add(coin70);
        //row11
        coin71 = new Coins(20, 275);
        pnlMap.add(coin71);
        coin72 = new Coins(40, 275);
        pnlMap.add(coin72);
        coin73 = new Coins(60, 275);
        pnlMap.add(coin73);
        coin74 = new Coins(80, 275);
        pnlMap.add(coin74);
        coin75 = new Coins(100, 275);
        pnlMap.add(coin75);
        coin76 = new Coins(120, 275);
        pnlMap.add(coin76);
        coin77 = new Coins(340, 275);
        pnlMap.add(coin77);
        coin78 = new Coins(360, 275);
        pnlMap.add(coin78);
        coin79 = new Coins(380, 275);
        pnlMap.add(coin79);
        coin80 = new Coins(400, 275);
        pnlMap.add(coin80);
        coin81 = new Coins(420, 275);
        pnlMap.add(coin81);
        //row12
        coin82 = new Coins(100, 295);
        pnlMap.add(coin82);
        coin83 = new Coins(340, 295);
        pnlMap.add(coin83);
        //row13
        coin84 = new Coins(100, 315);
        pnlMap.add(coin84);
        coin85 = new Coins(340, 315);
        pnlMap.add(coin85);
        //row14
        coin86 = new Coins(100, 335);
        pnlMap.add(coin86);
        coin87 = new Coins(340, 335);
        pnlMap.add(coin87);
        coin88 = new Coins(100, 355);
        pnlMap.add(coin88);
        coin89 = new Coins(340, 355);
        pnlMap.add(coin89);
        //row15
        coin90 = new Coins(20, 370);
        pnlMap.add(coin90);
        coin91 = new Coins(40, 370);
        pnlMap.add(coin91);
        coin92 = new Coins(60, 370);
        pnlMap.add(coin92);
        coin94 = new Coins(80, 370);
        pnlMap.add(coin94);
        coin95 = new Coins(100, 370);
        pnlMap.add(coin95);
        coin96 = new Coins(120, 370);
        pnlMap.add(coin96);
        coin97 = new Coins(140, 370);
        pnlMap.add(coin97);
        coin98 = new Coins(160, 370);
        pnlMap.add(coin98);
        coin99 = new Coins(180, 370);
        pnlMap.add(coin99);
        coin100 = new Coins(200, 370);
        pnlMap.add(coin100);
        coin101 = new Coins(240, 370);
        pnlMap.add(coin101);
        coin102 = new Coins(260, 370);
        pnlMap.add(coin102);
        coin103 = new Coins(280, 370);
        pnlMap.add(coin103);
        coin104 = new Coins(300, 370);
        pnlMap.add(coin104);
        coin105 = new Coins(320, 370);
        pnlMap.add(coin105);
        coin106 = new Coins(340, 370);
        pnlMap.add(coin106);
        coin107 = new Coins(360, 370);
        pnlMap.add(coin107);
        coin108 = new Coins(380, 370);
        pnlMap.add(coin108);
        coin109 = new Coins(400, 370);
        pnlMap.add(coin109);
        coin110 = new Coins(420, 370);
        pnlMap.add(coin110);
        //row16
        coin111 = new Coins(20, 390);
        pnlMap.add(coin111);
        coin112 = new Coins(100, 390);
        pnlMap.add(coin112);
        coin113 = new Coins(200, 390);
        pnlMap.add(coin113);
        coin114 = new Coins(240, 390);
        pnlMap.add(coin114);
        coin115 = new Coins(340, 390);
        pnlMap.add(coin115);
        coin116 = new Coins(420, 390);
        pnlMap.add(coin116);
        //row17
        coin117 = new Coins(20, 410);
        pnlMap.add(coin117);
        coin118 = new Coins(100, 410);
        pnlMap.add(coin118);
        coin119 = new Coins(200, 410);
        pnlMap.add(coin119);
        coin117 = new Coins(240, 410);
        pnlMap.add(coin117);
        coin118 = new Coins(340, 410);
        pnlMap.add(coin118);
        coin119 = new Coins(420, 410);
        pnlMap.add(coin119);
        //row18
        coin118 = new Coins(20, 430);
        pnlMap.add(coin118);
        coin119 = new Coins(40, 430);
        pnlMap.add(coin119);
        coin120 = new Coins(60, 430);
        pnlMap.add(coin120);
        coin121 = new Coins(100, 430);
        pnlMap.add(coin121);
        coin122 = new Coins(120, 430);
        pnlMap.add(coin122);
        coin123 = new Coins(140, 430);
        pnlMap.add(coin123);
        coin124 = new Coins(160, 430);
        pnlMap.add(coin124);
        coin125 = new Coins(180, 430);
        pnlMap.add(coin125);
        coin126 = new Coins(200, 430);
        pnlMap.add(coin126);
        coin127 = new Coins(220, 430);
        pnlMap.add(coin127);
        coin128 = new Coins(260, 430);
        pnlMap.add(coin128);
        coin128 = new Coins(240, 430);
        pnlMap.add(coin128);
        coin129 = new Coins(280, 430);
        pnlMap.add(coin129);
        coin130 = new Coins(300, 430);
        pnlMap.add(coin130);
        coin131 = new Coins(320, 430);
        pnlMap.add(coin131);
        coin132 = new Coins(340, 430);
        pnlMap.add(coin132);
        coin133 = new Coins(380, 430);
        pnlMap.add(coin133);
        coin134 = new Coins(400, 430);
        pnlMap.add(coin134);
        coin135 = new Coins(420, 430);
        pnlMap.add(coin135);
        //row19
        coin136 = new Coins(60, 450);
        pnlMap.add(coin136);
        coin137 = new Coins(100, 450);
        pnlMap.add(coin137);
        coin138 = new Coins(160, 450);
        pnlMap.add(coin138);
        coin139 = new Coins(280, 450);
        pnlMap.add(coin139);
        coin140 = new Coins(340, 450);
        pnlMap.add(coin140);
        coin141 = new Coins(380, 450);
        pnlMap.add(coin141);
        //row20
        coin142 = new Coins(20, 470);
        pnlMap.add(coin142);
        coin143 = new Coins(40, 470);
        pnlMap.add(coin143);
        coin144 = new Coins(60, 470);
        pnlMap.add(coin144);
        coin145 = new Coins(80, 470);
        pnlMap.add(coin145);
        coin146 = new Coins(100, 470);
        pnlMap.add(coin146);
        coin147 = new Coins(160, 470);
        pnlMap.add(coin147);
        coin148 = new Coins(180, 470);
        pnlMap.add(coin148);
        coin149 = new Coins(200, 470);
        pnlMap.add(coin149);
        coin150 = new Coins(240, 470);
        pnlMap.add(coin150);
        coin151 = new Coins(260, 470);
        pnlMap.add(coin151);
        coin152 = new Coins(280, 470);
        pnlMap.add(coin152);
        coin153 = new Coins(340, 470);
        pnlMap.add(coin153);
        coin154 = new Coins(360, 470);
        pnlMap.add(coin154);
        coin155 = new Coins(380, 470);
        pnlMap.add(coin155);
        coin156 = new Coins(400, 470);
        pnlMap.add(coin156);
        coin157 = new Coins(420, 470);
        pnlMap.add(coin157);
        //row21
        coin158 = new Coins(20, 490);
        pnlMap.add(coin158);
        coin159 = new Coins(200, 490);
        pnlMap.add(coin159);
        coin160 = new Coins(240, 490);
        pnlMap.add(coin160);
        coin161 = new Coins(420, 490);
        pnlMap.add(coin161);
        //row122
        coin162 = new Coins(20, 510);
        pnlMap.add(coin162);
        coin163 = new Coins(40, 510);
        pnlMap.add(coin163);
        coin164 = new Coins(60, 510);
        pnlMap.add(coin164);
        coin165 = new Coins(80, 510);
        pnlMap.add(coin165);
        coin166 = new Coins(100, 510);
        pnlMap.add(coin166);
        coin167 = new Coins(120, 510);
        pnlMap.add(coin167);
        coin168 = new Coins(140, 510);
        pnlMap.add(coin168);
        coin169 = new Coins(160, 510);
        pnlMap.add(coin169);
        coin170 = new Coins(180, 510);
        pnlMap.add(coin170);
        coin171 = new Coins(200, 510);
        pnlMap.add(coin171);
        coin172 = new Coins(240, 510);
        pnlMap.add(coin172);
        coin172 = new Coins(260, 510);
        pnlMap.add(coin172);
        coin173 = new Coins(280, 510);
        pnlMap.add(coin173);
        coin174 = new Coins(300, 510);
        pnlMap.add(coin174);
        coin175 = new Coins(320, 510);
        pnlMap.add(coin175);
        coin176 = new Coins(340, 510);
        pnlMap.add(coin176);
        coin177 = new Coins(360, 510);
        pnlMap.add(coin177);
        coin178 = new Coins(380, 510);
        pnlMap.add(coin178);
        coin180 = new Coins(400, 510);
        pnlMap.add(coin180);
        coin181 = new Coins(420, 510);
        pnlMap.add(coin181);

        

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
