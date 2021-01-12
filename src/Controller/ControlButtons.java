package controller;

import view.CreatePetFrame;
import view.MainFrame;
import view.components.Button;

public class ControlButtons {
	
	public MainFrame mainFrame;
	public CreatePetFrame createPetFrame;
	public Button btn;
	
	public ControlButtons(Button btn) {
		this.btn = btn;
	}
	
	public void open() {
		if (this.btn.getText() == "Inserir") {
			this.createPetFrame = new CreatePetFrame("Inserir", this.mainFrame);
			this.createPetFrame.setVisible(true);
			
		} else {
			this.mainFrame = new MainFrame("yourPet");
			this.mainFrame.setVisible(true);
		}
	}

}
