package view.screens;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

import controller.ControlPet;
import view.CreatePetFrame;
import view.components.FormPanel;
import view.components.TitlePanel;

public class CreatePetScreen extends JPanel {
	
	public ControlPet control = new ControlPet();
	public TitlePanel titlePanel = new TitlePanel("Inserção");
	
	
	public CreatePetScreen(CreatePetFrame currentFrame) {
		setLayout(new BorderLayout());
		setBackground(Color.white);
		
		FormPanel form = new FormPanel(currentFrame, null);
		
		add("Center", form);
		add("North", this.titlePanel);
		
	}
}