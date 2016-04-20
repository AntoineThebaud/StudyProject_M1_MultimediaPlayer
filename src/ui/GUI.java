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
import javax.swing.JTextField;
import javax.swing.JTextPane; 
	 
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
    JPanel lvl2_LeftPanel = new JPanel();
    lvl2_LeftPanel.setLayout(new FlowLayout());
    lvl2_LeftPanel.setPreferredSize(new Dimension(180, VHS));
    lvl2_LeftPanel.setMinimumSize(new Dimension(180, VHS));
    lvl2_LeftPanel.add(new JButton("<"));
    lvl2_LeftPanel.add(new JButton("D"));
    lvl2_LeftPanel.add(new JButton(">"));
    lvl2_LeftPanel.add(new JButton("|<<"));
    lvl2_LeftPanel.add(new JButton("[]"));
    lvl2_LeftPanel.add(new JButton(">>|"));
    
    //- CENTRAL : Slider + Tooltip + Boutons bottom-right
    JPanel lvl2_CentralPanel = new JPanel();
    lvl2_CentralPanel.setMinimumSize(new Dimension(180, VHS));
    lvl2_CentralPanel.setLayout(new BorderLayout());
    //- slider
    JPanel lvl3_sliderPanel = new JPanel();
    JSlider lvl4_slider = new JSlider();
    lvl3_sliderPanel.add(lvl4_slider, BorderLayout.NORTH);
    //- tooltip
    TextArea lvl3_text = new TextArea("Multimedia Player\n<o==========================================>", 1, 45, TextArea.SCROLLBARS_NONE);
    lvl3_text.setMinimumSize(new Dimension(120, 45));
    // - boutons
    JPanel lvl3_rightButtons = new JPanel();
    lvl3_rightButtons.setLayout(new FlowLayout());
    lvl3_rightButtons.add(new JButton("|||"));
    lvl3_rightButtons.add(new JButton("[_]"));
    
    lvl2_CentralPanel.add(lvl3_text, BorderLayout.NORTH);
    lvl2_CentralPanel.add(lvl3_sliderPanel, BorderLayout.WEST);
    lvl2_CentralPanel.add(lvl3_rightButtons, BorderLayout.EAST);
    
    JPanel lvl1_Menu = new JPanel();
    lvl1_Menu.setLayout(new BorderLayout());
    lvl1_Menu.add(lvl2_LeftPanel, BorderLayout.WEST);
    lvl1_Menu.add(lvl2_CentralPanel, BorderLayout.CENTER);
    
    //partie BASSE : liste de lecture
    
    //- BAS : Boutons à gauche, barre de recherche à droite
    //- boutons gauche
    JPanel lvl3_BottomLeftButtons = new JPanel();
    lvl3_BottomLeftButtons.setLayout(new FlowLayout());
    lvl3_BottomLeftButtons.add(new JButton(" + "));
    lvl3_BottomLeftButtons.add(new JButton("~~>"));
    lvl3_BottomLeftButtons.add(new JButton("->-<-"));
    //- barre de recherche
    JTextField lvl3_BottomSearchBar = new JTextField(" search ...");
    lvl3_BottomSearchBar.setPreferredSize(new Dimension(180, 8));
    //- texte central
    JTextField lvl3_BottomText = new JTextField("15 éléments");
    lvl3_BottomText.setHorizontalAlignment(JTextField.CENTER);
    lvl3_BottomText.setEditable(false);
    lvl3_BottomSearchBar.setMaximumSize(new Dimension(70, 8));
    
    JPanel lvl2_BottomPlaylist = new JPanel();
    lvl2_BottomPlaylist.setLayout(new BorderLayout());
    lvl2_BottomPlaylist.add(lvl3_BottomLeftButtons, BorderLayout.WEST);
    lvl2_BottomPlaylist.add(lvl3_BottomSearchBar, BorderLayout.EAST);
    lvl2_BottomPlaylist.add(lvl3_BottomText, BorderLayout.CENTER);
    
    JPanel lvl1_Playlist = new JPanel();
    lvl1_Playlist.setVisible(true);
    lvl1_Playlist.setPreferredSize(new Dimension(500,150));
    lvl1_Playlist.setLayout(new BorderLayout());
    lvl1_Playlist.add(new JButton("Some stuff"), BorderLayout.CENTER);
    lvl1_Playlist.add(new JButton("Some stuff"), BorderLayout.NORTH);
    lvl1_Playlist.add(lvl2_BottomPlaylist, BorderLayout.SOUTH);
    lvl1_Playlist.add(new JButton("Some stuff"), BorderLayout.WEST);
    lvl1_Playlist.add(new JButton("Some stuff"), BorderLayout.EAST);
    
    //assemblage de la fenêtre finale
    this.getContentPane().add(lvl1_Menu, BorderLayout.NORTH);
    this.getContentPane().add(lvl1_Playlist, BorderLayout.CENTER);
    
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
  
//  public class GUIListener extends ComponentAdapter {
//	
//	GUI g;
//	public GUIListener(GUI g) {
//		this.g = g;
//	}
//	@Override
//    public void componentResized(ComponentEvent e) {
//		g.setSize(new Dimension(g.getWidth(), 100));
//    }
//  }
}
