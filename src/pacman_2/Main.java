package pacman_2;

import java.util.List;
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
import java.util.ArrayList;
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

    public static List<GhostPatrol> listGhost = new ArrayList<>();

<<<<<<< HEAD
	private JPanel pnlMap;

	private JPanel pnlMenu;
	private JLabel lblMenu;

	private JLabel lblLife;
	private JLabel lblTitleScore;
	private JLabel lblScore;
	private JLabel lblAlias;

	// private JLabel lblPacmanIcon;

	private GhostHoming lblPinkyIcon;
	private GhostPatrol lblBlinkyIcon;
	private GhostMovementHandler blinkyMH;
	private GhostPatrol lblInkyIcon;
	private GhostMovementHandler inkyMH;
	private GhostPatrol lblClydeIcon;
	private GhostMovementHandler clydeMH;

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
		setUndecorated(true);
		setSize(448, 576);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.black);
		try {
			this.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("Pac-man - Copy.png")))));
		} catch (IOException ex) {
			ex.printStackTrace(System.err);
		}
		getContentPane().setLayout(null);

		// pnlMenu = new JPanel();
		// pnlMenu.setBounds(0, 0, 464, 615);
		// pnlMenu.setBackground(Color.black);
		// pnlMenu.setLayout(null);
		// pnlMenu.addKeyListener(this);
		// pnlMenu.setFocusable(true);
		// add(pnlMenu);
		//
		// lblMenu = new JLabel("Press any key to start");
		// lblMenu.setForeground(Color.white);
		// lblMenu.setFont(new Font("Emulogic", Font.PLAIN, 18));
		// lblMenu.setBounds(30, 10, 400, 615);
		// lblMenu.setVisible(true);
		// pnlMenu.add(lblMenu);

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
					} else {
						lblPacmanIcon.arah = lblPacmanIcon.prev_arah;
					}
					repaint();
					break;
				}
				case KeyEvent.VK_RIGHT: {
					x += 1;
					if (x > 412) {
						lblPacmanIcon.arah = 3;
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
		lblPacmanIcon.setIcon(new ImageIcon(resizeImage("pac_man_chara.png", 25, 25)));
		lblPacmanIcon.setBounds(11, 55, 25, 30);
		pnlMap.add(lblPacmanIcon);

		// Pinky = GhostHoming
		lblPinkyIcon = new GhostHoming();
		lblPinkyIcon.setIcon(new ImageIcon(resizeImage("pinky.png", 25, 25)));
		lblPinkyIcon.setBounds(202, 255, 25, 30);
		pnlMap.add(lblPinkyIcon);

		lblBlinkyIcon = new GhostPatrol();
		blinkyMH = new GhostMovementHandler(lblBlinkyIcon);
		lblBlinkyIcon.setIcon(new ImageIcon(resizeImage("blinky.png", 25, 25)));
		lblBlinkyIcon.setBounds(178, 275, 25, 30);
		pnlMap.add(lblBlinkyIcon);

		lblInkyIcon = new GhostPatrol();
		inkyMH = new GhostMovementHandler(lblInkyIcon);
		lblInkyIcon.setIcon(new ImageIcon(resizeImage("inky.png", 25, 25)));
		lblInkyIcon.setBounds(228, 275, 25, 30);
		pnlMap.add(lblInkyIcon);

		lblClydeIcon = new GhostPatrol();
		clydeMH = new GhostMovementHandler(lblClydeIcon);
		lblClydeIcon.setIcon(new ImageIcon(resizeImage("clyde.png", 25, 25)));
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

		// System.out.println(lblPacmanIcon.getX());
	}

	public static void main(String[] args) {
		new Main().setVisible(true);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// throw new UnsupportedOperationException("Not supported yet."); //To change
		// body of generated methods, choose Tools | Templates.
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// throw new UnsupportedOperationException("Not supported yet."); //To change
		// body of generated methods, choose Tools | Templates.
	}

	@Override
	public void keyPressed(KeyEvent e) {
		pnlMenu.hide();
	}
}

// ============================================= DOODLES
// ============================================================
// private Image resizeImage(String url){
// Image dimg = null;
// try{
// BufferedImage img = ImageIO.read(new File(url));
// dimg = img.getScaledInstance(426,547,Image.SCALE_SMOOTH);//426,547
// } catch (IOException ex){
// ex.printStackTrace(System.err);
// }
// return dimg;
// }
//
// pnlMap = new JPanel();
// pnlMap.setSize(448,576);
// pnlMap.setLocation(0,0);
// pnlMap.setBackground(Color.black);
// add(pnlMap,BorderLayout.NORTH);
// lblMap = new JLabel("Name : ");
// pnlMap.add(lblMap);
// txtText1 = new JTextField(10);
// pnlPanel1.add(txtText1);
// lblMapIcon = new JLabel();
// lblMapIcon.setIcon(new ImageIcon(resizeImage("D:\\Latihan\\SP
// 1\\PBO\\PacMan_2\\Pac-man - Copy.png")));
// lblMapIcon.setLocation(0,0);
// pnlMap.add(lblMapIcon);
=======
    private JPanel pnlMap;

    private JPanel pnlMenu;
    private JLabel lblMenu;
    private JLabel lblTitle;

    private JLabel lblLife;
    public static JLabel lblLifePoint = new JLabel("3");
    private JLabel lblTitleScore;
    private JLabel lblScore;
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

        listGhost.add(lblBlinkyIcon);
        listGhost.add(lblInkyIcon);
        listGhost.add(lblClydeIcon);

        Thread pacmanThread = new Thread(lblPacmanIcon);
        pacmanThread.start();

        Thread blinkytHandler = new Thread(blinkyMH);
        blinkytHandler.start();

        Thread inkyHandler = new Thread(inkyMH);
        inkyHandler.start();

        Thread clydeHandler = new Thread(clydeMH);
        clydeHandler.start();
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
>>>>>>> master
