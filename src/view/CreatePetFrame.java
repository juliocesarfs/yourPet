package view;

import javax.swing.JFrame;

import view.screens.CreatePetScreen;

public class CreatePetFrame extends JFrame {
	
	public CreatePetFrame(String title) {
        super(title);
        setDefaultCloseOperation(CreatePetFrame.EXIT_ON_CLOSE);
        setSize(480, 450);
        setResizable(false);
        
        setVisible(true);
        this.setLocationRelativeTo(null);
        
        getContentPane().add(new CreatePetScreen(this));
    }
}
