package ui;

// no compte rendu 
	
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Rectangle;
import java.awt.TextArea;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider; 
	 
public class GUI extends JFrame {
	
  static int VHS = 105;
  
  public GUI() {
	  
    this.setTitle("Multimedia Player");
    this.setMinimumSize(new Dimension(520, VHS));
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);
    this.setLayout(new BorderLayout());
    
    //partie HAUTE : Menu

    //- GAUCHE : Boutons
    JPanel leftPanel = new JPanel();
    leftPanel.setLayout(new FlowLayout());
    leftPanel.setPreferredSize(new Dimension(180, VHS));
    leftPanel.setMinimumSize(new Dimension(180, VHS));
    leftPanel.add(new JButton("<"));
    leftPanel.add(new JButton("D"));
    leftPanel.add(new JButton(">"));
    leftPanel.add(new JButton("|<<"));
    leftPanel.add(new JButton("[]"));
    leftPanel.add(new JButton(">>|"));
    
    //- CENTRAL : Slider + Tooltip + Boutons bottom-right
    JPanel centralPanel = new JPanel();
    centralPanel.setMinimumSize(new Dimension(180, VHS));
    centralPanel.setLayout(new BorderLayout());
    //- slider
    JPanel sliderPanel = new JPanel();
    JSlider slider = new JSlider();
    sliderPanel.add(slider, BorderLayout.NORTH);
    //- tooltip
    TextArea text = new TextArea("Multimedia Player\n<o==========================================>", 1, 45, TextArea.SCROLLBARS_NONE);
    text.setMinimumSize(new Dimension(120, 45));
    // - boutons
    JPanel rightButtons = new JPanel();
    rightButtons.setLayout(new FlowLayout());
    rightButtons.add(new JButton("|||"));
    rightButtons.add(new JButton("[_]"));
    
    centralPanel.add(text, BorderLayout.NORTH);
    centralPanel.add(sliderPanel, BorderLayout.WEST);
    centralPanel.add(rightButtons, BorderLayout.EAST);
    
    JPanel menu = new JPanel();
    menu.setLayout(new BorderLayout());
    menu.add(leftPanel, BorderLayout.WEST);
    menu.add(centralPanel, BorderLayout.CENTER);
    
    //partie BASSE : liste de lecture
    
    JPanel playlist = new JPanel();
    playlist.setVisible(true);
    playlist.setPreferredSize(new Dimension(500,150));
    playlist.setLayout(new BorderLayout());
    playlist.add(new JButton("Some stuff"), BorderLayout.CENTER);
    playlist.add(new JButton("Some stuff"), BorderLayout.NORTH);
    playlist.add(new JButton("Some stuff"), BorderLayout.SOUTH);
    playlist.add(new JButton("Some stuff"), BorderLayout.WEST);
    playlist.add(new JButton("Some stuff"), BorderLayout.EAST);
    
    //assemblage de la fenêtre finale
    this.getContentPane().add(menu, BorderLayout.NORTH);
    this.getContentPane().add(playlist, BorderLayout.SOUTH);
    
    //TODO : à décommenter 
    //Listener : redimensionnement
//    this.addComponentListener(new ComponentAdapter() {
//        @Override
//        public void componentResized(ComponentEvent e) {
//            setSize(new Dimension(getWidth(), 105));
//        }
//    });

    this.setVisible(true);
    this.pack();
  }
  
  //dans le constructeur :
  //this.addComponentListener(new GUIListener(this));
  
  public class GUIListener extends ComponentAdapter {
	
	GUI g;
	public GUIListener(GUI g) {
		this.g = g;
	}
	@Override
    public void componentResized(ComponentEvent e) {
		g.setSize(new Dimension(g.getWidth(), 100));
    }
  }
}
