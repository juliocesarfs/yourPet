package view;

import javax.swing.JFrame;

import model.Pet;
import view.screens.EditPetScreen;

public class EditPetFrame extends JFrame {
	MainFrame mainWindow;
	
	public EditPetFrame(String title, MainFrame mainWindow, Pet pet) {
        super(title);
        this.mainWindow = mainWindow;
        setDefaultCloseOperation(CreatePetFrame.EXIT_ON_CLOSE);
        setSize(480, 450);
        setResizable(false);
        
        getContentPane().add(new EditPetScreen(this, this.mainWindow, pet));
    }

}
