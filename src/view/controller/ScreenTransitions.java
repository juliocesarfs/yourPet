package view.controller;

import model.Pet;
import view.CreatePetFrame;
import view.DeletePetFrame;
import view.EditPetFrame;
import view.MainFrame;

public class ScreenTransitions {
	
	public MainFrame mainFrame;
	public CreatePetFrame createPetFrame;
	public DeletePetFrame deletePetFrame;
	public EditPetFrame editPetFrame;
	public Pet pet;
	
	public ScreenTransitions(Pet pet) {
		this.pet = pet;
	}
	
	public void showMainFrame() {
		this.mainFrame = new MainFrame("yourPet");
		this.mainFrame.setVisible(true);
	}
	
	public void showCreatePetFrame() {
		this.createPetFrame = new CreatePetFrame("Inserção");
		this.createPetFrame.setVisible(true);
	}
	
	public void showEditPetFrame() {
		this.editPetFrame = new EditPetFrame("Edição", this.pet);
		this.editPetFrame.setVisible(true);
	}

}
