package view.components;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controller.ControlPet;
import model.Pet;
import utils.Return;
import view.DeletePetFrame;
import view.controller.ScreenTransitions;

public class DeletePanel extends JPanel implements ActionListener {
	
	public JLabel name;
	public JLabel race;
	public JLabel specie;
	public JLabel age;
	public JLabel gender;
	public Button btnConfirm;
	public Button btnBack;
	
	public ControlPet control = new ControlPet();
	public Pet pet;
	public ScreenTransitions screenTransitions = new ScreenTransitions(null);
	public DeletePetFrame currentFrame;
	
	public DeletePanel(DeletePetFrame currentFrame, Pet pet) {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		this.currentFrame = currentFrame;
		this.pet = pet;
		
		this.name = new JLabel("Nome: "+pet.getName());
		this.race = new JLabel("Raça: "+pet.getRace());
		this.specie = new JLabel("Espécie: "+pet.getSpecie());
		this.age = new JLabel("Idade: "+pet.getAge());
		this.gender = new JLabel("Sexo: "+pet.getGender());
		
		this.btnConfirm = new Button("Deletar");
		this.btnBack = new Button("Voltar");
		
		this.btnConfirm.addActionListener(this);
		this.btnBack.addActionListener(this);
		
		add(this.name);
		add(this.race);
		add(this.specie);
		add(this.age);
		add(this.gender);
		add(this.btnConfirm);
		add(this.btnBack);
		
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		
		Return result = null;
		if (btn.getText() == "Deletar") {
			result = deleteAction();
			
			if (!result.isSucess())
				JOptionPane.showMessageDialog(null, "Erro ao deletar Pet");
			else
				JOptionPane.showMessageDialog(null, "Pet deletado com sucesso");
		}
		this.screenTransitions.showMainFrame();
		this.currentFrame.dispose();
		
	}
	
	private Return deleteAction() {
		return this.control.delete(this.pet);
	}
	
	
	
}
