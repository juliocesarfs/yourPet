package view.screens;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

import controller.ControlPet;
import model.Pet;
import view.DeletePetFrame;
import view.components.DeletePanel;
import view.components.TitlePanel;

public class DeletePetScreen extends JPanel {
	
	public ControlPet control = new ControlPet();
	public TitlePanel titlePanel = new TitlePanel("Tem certeza que deseja excluir?");
	
	
	public DeletePetScreen(DeletePetFrame currentFrame, Pet pet) {
		setLayout(new BorderLayout());
		setBackground(Color.white);
		
		DeletePanel deletePanel = new DeletePanel(currentFrame, pet);
		
		
		add("North", this.titlePanel);
		add("Center", deletePanel);
	}

}
