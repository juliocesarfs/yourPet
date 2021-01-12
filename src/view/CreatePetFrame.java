package view;

import javax.swing.JFrame;
import javax.swing.JTextField;

import view.screens.CreatePetScreen;

public class CreatePetFrame extends JFrame {
	
	MainFrame mainWindow;
	public CreatePetFrame(String title, MainFrame mainWindow) {
        super(title);
        this.mainWindow = mainWindow;
        setDefaultCloseOperation(CreatePetFrame.EXIT_ON_CLOSE);
        setSize(480, 450);
        setResizable(false);
        
        getContentPane().add(new CreatePetScreen(this, this.mainWindow));
    }
}
