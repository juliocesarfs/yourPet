package view.screens;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.ControlPet;
import model.Pet;
import view.DeletePetFrame;
import view.MainFrame;
import view.components.FormPanel;
import view.components.TitlePanel;

public class DeletePetScreen extends JPanel {
	
	public ControlPet control = new ControlPet();
	public TitlePanel titlePanel = new TitlePanel("Tem certeza que deseja excluir?");
	public FormPanel formPanel;
	
	public DeletePetScreen(DeletePetFrame currentFrame, Pet pet) {
		setLayout(new BorderLayout());
		setBackground(Color.white);
		
		this.formPanel = new FormPanel(currentFrame, pet);
		
		add("North", this.titlePanel);
		add("Center", this.formPanel);
	}

}