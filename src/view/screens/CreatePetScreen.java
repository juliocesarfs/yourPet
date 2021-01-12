package view.screens;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.ControlPet;
import model.Pet;
import view.CreatePetFrame;
import view.MainFrame;
import view.components.Button;
import view.components.FormPanel;
import view.components.TitlePanel;

public class CreatePetScreen extends JPanel  {
	
	public ControlPet control = new ControlPet();
	public Button btnBack;
	public TitlePanel titlePanel = new TitlePanel("Inserção");
	
	public CreatePetScreen(CreatePetFrame currentFrame, MainFrame mainWindow) {
		setLayout(new BorderLayout());
		setBackground(Color.white);
		
		FormPanel form = new FormPanel();
		
		btnBack = new Button("Voltar", currentFrame, mainWindow);
		
		
		
		add("Center", form);
		add("North", this.titlePanel);
		add("South", btnBack);
	}
}