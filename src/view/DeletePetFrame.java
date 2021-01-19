package view;

import javax.swing.JFrame;

import model.Pet;
import view.screens.DeletePetScreen;

public class DeletePetFrame extends JFrame {
	
	
	public DeletePetFrame(String title, Pet pet) {
        super(title);
        setDefaultCloseOperation(CreatePetFrame.EXIT_ON_CLOSE);
        setSize(480, 450);
        setResizable(false);
        this.setLocationRelativeTo(null);
        
        getContentPane().add(new DeletePetScreen(this, pet));
    }
}
