package view.screens;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

import controller.ControlPet;
import model.Pet;
import view.EditPetFrame;
import view.MainFrame;
import view.components.FormPanel;
import view.components.TitlePanel;

public class EditPetScreen extends JPanel {
	
	public ControlPet control = new ControlPet();
	public TitlePanel titlePanel = new TitlePanel("Edição");
	
	public EditPetScreen(EditPetFrame currentFrame, Pet pet) {
		setLayout(new BorderLayout());
		setBackground(Color.white);
		
		FormPanel form = new FormPanel(currentFrame, pet);		
		
		add("Center", form);
		add("North", this.titlePanel);
	}

}
