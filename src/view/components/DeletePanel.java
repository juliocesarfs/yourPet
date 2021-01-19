package view.components;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controller.ControlPet;
import model.Pet;
import utils.Constants;
import utils.Return;
import view.DeletePetFrame;
import view.controller.ScreenTransitions;

public class DeletePanel extends JPanel implements ActionListener {
	
	public Label name;
	public Label race;
	public Label specie;
	public Label age;
	public Label gender;
	public Button btnConfirm;
	public Button btnBack;
	
	public ControlPet control = new ControlPet();
	public Pet pet;
	public ScreenTransitions screenTransitions = new ScreenTransitions(null);
	public DeletePetFrame currentFrame;
	public Constants constant = new Constants();
	
	public DeletePanel(DeletePetFrame currentFrame, Pet pet) {
		this.setLayout(null);
		this.setBackground(constant.COLOR_BACKGROUND);
		
		this.currentFrame = currentFrame;
		this.pet = pet;
		
		this.name = new Label("Nome: "+pet.getName());
		this.name.setBounds(150, 40, 110, 20);
		
		this.race = new Label("Raça: "+pet.getRace());
		this.race.setBounds(150, 80, 110, 20);
		
		this.specie = new Label("Espécie: "+pet.getSpecie());
		this.specie.setBounds(150, 120, 110, 20);
		
		this.age = new Label("Idade: "+pet.getAge());
		this.age.setBounds(150, 160, 110, 20);
		
		this.gender = new Label("Sexo: "+pet.getGender());
		this.gender.setBounds(150, 200, 110, 20);
		
		
		this.btnConfirm = new Button("Deletar");
		this.btnConfirm.setBounds(230, 260, 106, 50);
		this.btnConfirm.setBackground(constant.COLOR_RED);
		
		this.btnBack = new Button("Voltar");
		this.btnBack.setBounds(120, 260, 106, 50);
		this.btnBack.setBackground(constant.COLOR_YELLOW);
		
		this.btnConfirm.addActionListener(this);
		this.btnBack.addActionListener(this);
		
		add(this.name);
		add(this.race);
		add(this.specie);
		add(this.age);
		add(this.gender);
		add(this.btnBack);
		add(this.btnConfirm);
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		
		Return result = null;
		if (btn.getText() == "Deletar") {
			result = deleteAction();
			
			JOptionPane.showMessageDialog(null, result.getMessage());
		}
		this.screenTransitions.showMainFrame();
		this.currentFrame.dispose();
		
	}
	
	private Return deleteAction() {
		return this.control.delete(this.pet);
	}
	
	
	
}
