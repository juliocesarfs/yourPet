package view.components;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class TitlePanel extends JPanel {
	
	public JLabel title;
	
	public TitlePanel() {
		this.title = new JLabel("yourPet");
		title.setSize(new Dimension(30, 30));
		
		
		title.setHorizontalTextPosition(JLabel.CENTER);
		add(title);
	}

}
