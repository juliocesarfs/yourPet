package view.screens;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.ControlPet;
import model.Pet;
import utils.Return;
import view.MainFrame;

public class TesteScreen extends JPanel implements ActionListener {
	
	ControlPet control = new ControlPet();
	Pet pet = null;
	JButton btn = new JButton("Voltar");
	MainFrame mainWindow;
	
	public TesteScreen(MainFrame mainWindow) {
		this.mainWindow = mainWindow;
		setLayout(new BorderLayout());
		setBackground(Color.white);
		
		
		pet = (Pet) control.getPetById(2).getValue();
		
		add("North", btn);
		
		btn.addActionListener(this);
		add(new JLabel(pet.getName()));
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		mainWindow.setVisible(true);
	}

}