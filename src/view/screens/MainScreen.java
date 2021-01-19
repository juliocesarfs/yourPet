package view.screens;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;

import view.MainFrame;
import view.components.TablePanel;
import view.components.TitlePanel;

public class MainScreen extends JPanel {
	
	public MainFrame window;
	JButton btn = new JButton("Open");
	TitlePanel title = new TitlePanel("yourPet");

	public MainScreen(MainFrame currentFrame) {
		setLayout(new BorderLayout());
		setBackground(Color.white);
		
		add("North", title);
		add("Center", new TablePanel(currentFrame));
	}
}
