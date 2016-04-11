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

  public GUI() {
	  
    this.setTitle("Multimedia Player");
    this.setMinimumSize(new Dimension(500, 105));
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);
    this.setLayout(new BorderLayout());

    //partie GAUCHE : Boutons
    JPanel leftPanel = new JPanel();
    leftPanel.setLayout(new FlowLayout());
    leftPanel.setPreferredSize(new Dimension(180, 100));
    leftPanel.add(new JButton("<"));
    leftPanel.add(new JButton("D"));
    leftPanel.add(new JButton(">"));
    leftPanel.add(new JButton("|<<"));
    leftPanel.add(new JButton("[]"));
    leftPanel.add(new JButton(">>|"));
    
    //partie CENTRAL : Slider + Tooltip + Boutons bottom-right
    JPanel centralPanel = new JPanel();
    centralPanel.setLayout(new BorderLayout());
    //- slider
    JSlider slider = new JSlider();
    slider.setPreferredSize(new Dimension(150,150));
    //- tooltip
    TextArea text = new TextArea("Multimedia Player\n<o==========================================>", 1, 45, TextArea.SCROLLBARS_NONE);
    text.setMinimumSize(new Dimension(120, 45));
    // - boutons
    JPanel rightButtons = new JPanel();
    rightButtons.setLayout(new FlowLayout());
    rightButtons.add(new JButton("|||"));
    rightButtons.add(new JButton("[_]"));
    
    centralPanel.add(text, BorderLayout.NORTH);
    centralPanel.add(slider, BorderLayout.WEST);
    centralPanel.add(rightButtons, BorderLayout.EAST);
    
    //partie BAS : liste de lecture
    JPanel bottomPanel = new JPanel();
    bottomPanel.setVisible(true);
    bottomPanel.setPreferredSize(new Dimension(500,150));
    
    //assemblage de la fenêtre finale
    this.getContentPane().add(leftPanel, BorderLayout.WEST);
    this.getContentPane().add(centralPanel, BorderLayout.CENTER);
    //this.getContentPane().add(bottomPanel, BorderLayout.SOUTH);
    
    //Listener : redimensionnement
    this.addComponentListener(new ComponentAdapter() {
        @Override
        public void componentResized(ComponentEvent e) {
            setSize(new Dimension(getWidth(), 105));
        }
    });

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
