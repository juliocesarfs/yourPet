package view;

import java.awt.event.ActionListener;

import javax.swing.*;

import view.screens.MainScreen;

public class MainFrame extends JFrame {
	public CreatePetFrame createPetFrame;
	//EditPetFrame
	//DeletePetFrame
	
    public MainFrame(String title) {
        super(title);
        setDefaultCloseOperation(MainFrame.EXIT_ON_CLOSE);
        setSize(500, 600);
        setResizable(false);

        getContentPane().add(new MainScreen(this, this.createPetFrame));
        setVisible(true);
    }
}