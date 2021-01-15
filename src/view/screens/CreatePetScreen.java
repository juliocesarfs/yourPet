package view.screens;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.ControlPet;
import model.Pet;
import view.CreatePetFrame;
import view.MainFrame;
import view.components.Button;
import view.components.FormPanel;
import view.components.TitlePanel;
import view.controller.ScreenTransitions;

public class CreatePetScreen extends JPanel {
	
	public ControlPet control = new ControlPet();
	public TitlePanel titlePanel = new TitlePanel("Inser��o");
	
	
	public CreatePetScreen(CreatePetFrame currentFrame) {
		setLayout(new BorderLayout());
		setBackground(Color.white);
		
		FormPanel form = new FormPanel(currentFrame, null);
		
		add("Center", form);
		add("North", this.titlePanel);
		
	}
}