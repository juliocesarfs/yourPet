package view.components;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class TitlePanel extends JPanel {
	
	public JLabel title;
	
	public TitlePanel(String title) {
		this.title = new JLabel(title);
		this.title.setSize(new Dimension(30, 30));
		
		
		this.title.setHorizontalTextPosition(JLabel.CENTER);
		add(this.title);
	}

}
