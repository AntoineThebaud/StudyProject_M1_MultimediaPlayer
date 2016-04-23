package ui;

// no compte rendu 
	
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Rectangle;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.table.TableColumn; 
	 
public class GUI extends JFrame {
	
  static int MVS = 105;
  
  public GUI() {
	  
    this.setTitle("Multimedia Player");
    this.setMinimumSize(new Dimension(520, MVS));
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);
    this.setLayout(new BorderLayout());
    
    //partie HAUTE : Menu

    //- GAUCHE : Boutons
    JPanel lvl2_LeftPanel = new JPanel();
    lvl2_LeftPanel.setLayout(new FlowLayout());
    lvl2_LeftPanel.setPreferredSize(new Dimension(180, MVS));
    lvl2_LeftPanel.setMinimumSize(new Dimension(180, MVS));
    lvl2_LeftPanel.add(new JButton("<"));
    lvl2_LeftPanel.add(new JButton("D"));
    lvl2_LeftPanel.add(new JButton(">"));
    lvl2_LeftPanel.add(new JButton("|<<"));
    lvl2_LeftPanel.add(new JButton("[]"));
    lvl2_LeftPanel.add(new JButton(">>|"));
    
    //- CENTRAL : Slider + Tooltip + Boutons bottom-right
    JPanel lvl2_CentralPanel = new JPanel();
    lvl2_CentralPanel.setMinimumSize(new Dimension(180, MVS));
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
    //(bouton affichage playlist)
    JButton BtShowPlaylist = new JButton("[_]");
    BtShowPlaylist.addActionListener(new ActionListener() {
    	Color cliqued = new Color(163, 184, 204);
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if(BtShowPlaylist.getBackground().equals(cliqued)) {
				BtShowPlaylist.setBackground(null);
				setSize(new Dimension(getWidth(), MVS));
			} else {
				BtShowPlaylist.setBackground(cliqued);
				setSize(new Dimension(getWidth(), 350));
			}
		}
    });
    lvl3_rightButtons.add(BtShowPlaylist);
    
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
    
    //- CENTRAL : table
    String[] entetes = {"Nom", "Auteur", "Durée"};
    Object[][] donnees = {
            {"AC_DC", "   ",  "   "},
            {"   Black Ice", "   ",  "   "},
            {"      Rock 'N Roll Train", "AC/DC",  "04:21"},
            {"      Skies On Fire", "AC/DC",  "04:21"},
            {"      Big Jack", "AC/DC",  "04:21"},
            {"      Anything Goes", "AC/DC",  "04:21"},
            {"      War Machine", "AC/DC",  "04:21"},
            {"      Smash 'N Grab", "AC/DC",  "04:21"},
            {"      Spoilin' For A Fight", "AC/DC",  "04:21"},
            {"      Wheels", "AC/DC",  "04:21"},
    };
    JTable lvl2_table = new JTable(donnees, entetes);
	// Display
    lvl2_table.setFillsViewportHeight(true);
    lvl2_table.getColumnModel().getColumn(0).setPreferredWidth(400);
	lvl2_table.getColumnModel().getColumn(1).setPreferredWidth(45);
	lvl2_table.getColumnModel().getColumn(1).setMinWidth(45);
	lvl2_table.getColumnModel().getColumn(2).setPreferredWidth(40);
	lvl2_table.getColumnModel().getColumn(2).setMinWidth(40);
    
    JPanel lvl1_Playlist = new JPanel();
    lvl1_Playlist.setVisible(true);
    lvl1_Playlist.setPreferredSize(new Dimension(500,150));
    lvl1_Playlist.setLayout(new BorderLayout());
    lvl1_Playlist.add(new JScrollPane(lvl2_table), BorderLayout.CENTER);
    lvl1_Playlist.add(lvl2_BottomPlaylist, BorderLayout.SOUTH);
    
    //assemblage de la fenêtre finale
    this.getContentPane().add(lvl1_Menu, BorderLayout.NORTH);
    this.getContentPane().add(lvl1_Playlist, BorderLayout.CENTER);
    
    // Listener : redimensionnement
    this.addComponentListener(new ComponentAdapter() {
        @Override
        public void componentResized(ComponentEvent e) {
        	if(getHeight() < 300) {
        		setSize(new Dimension(getWidth(), MVS));
        		BtShowPlaylist.setBackground(null);
        	}
        }
    });

    this.setVisible(true);
    this.pack();
  }
}
