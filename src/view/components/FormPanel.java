package view.components;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.Calendar;
import java.util.Properties;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.jdatepicker.DateModel;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import controller.ControlPet;
import lombok.Data;
import model.Pet;
import utils.DateLabelFormatter;
import utils.Return;
import view.DeletePetFrame;
import view.controller.ScreenTransitions;

public class FormPanel extends JPanel implements ActionListener	{
	public JTextField name;
	public JTextField race;
	public JTextField specie;
	public JComboBox<String> gender;
	
	public JLabel labelName;
	public JLabel labelRace;
	public JLabel labelSpecie;
	public JLabel labelGender;
	public JLabel labelBirth;
	
	public JDatePickerImpl birth;
	
	public Button btnBack;
	public Button btnSave;
	
	public ScreenTransitions screenTransitions;
	public ControlPet controlPet = new ControlPet();
	public Pet pet = new Pet();
	
	
	public JFrame currentFrame;
	
	public FormPanel(JFrame currentFrame, Pet pet) {
		
		setLayout(null);
		
		if (pet != null) 
			this.pet = pet;
		
		this.currentFrame = currentFrame;
		this.screenTransitions = new ScreenTransitions(pet);
		
		
		this.labelName = new JLabel("Nome:");
		this.name = new JTextField();
		this.labelName.setBounds(50, 40, 100, 20);
		this.name.setBounds(150, 40, 100, 20);
		
		this.labelRace = new JLabel("Raça:");
		this.race = new JTextField();
		this.labelRace.setBounds(50, 80, 100, 20);
		this.race.setBounds(150, 80, 100, 20);
		
		this.labelSpecie = new JLabel("Espécie:");
		this.specie = new JTextField();
		this.labelSpecie.setBounds(50, 120, 100, 20);
		this.specie.setBounds(150, 120, 100, 20);
		

		this.labelGender = new JLabel("Sexo:");
		String genders[] = {"F", "M"};
		this.gender = new JComboBox(genders);
		this.labelGender.setBounds(50, 160, 100, 20);
		this.gender.setBounds(150, 160, 100, 20);
		
		
		this.labelBirth = new JLabel("Nascimento:");
		UtilDateModel model = new UtilDateModel();
		
		Properties p = new Properties();
		p.put("text.today", "Hoje");
		p.put("text.month", "Mês");
		p.put("text.year", "Ano");
		
		JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
		DateLabelFormatter dateFormatter = new DateLabelFormatter();
		
		this.birth = new JDatePickerImpl(datePanel, dateFormatter);
		this.labelBirth.setBounds(50, 200, 100, 20);
		this.birth.setBounds(150, 200, 120, 30);
		
		add(this.labelRace);
		add(this.race);
		add(this.labelBirth);
		add(this.birth);
		add(this.labelName);
		add(this.name);
		add(this.labelRace);
		add(this.race);
		add(this.labelSpecie);
		add(this.specie);
		add(this.labelGender);
		add(this.gender);
		
		
		this.btnBack = new Button("Voltar", this);
		this.btnBack.setBounds(120, 260, 100, 50);
		btnBack.addActionListener(this);
		add(btnBack);
		
		this.btnSave = new Button("Salvar", this);
		this.btnSave.setBounds(230, 260, 100, 50);
		btnSave.addActionListener(this);
		add(btnSave);
		
		if (pet != null) {
			this.name.setText(pet.getName());
			this.race.setText(pet.getRace());
			this.specie.setText(pet.getSpecie());
			this.gender.setSelectedItem(pet.getGender());
			model.setValue(pet.getBirth());
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Button btn = (Button) e.getSource();
		buttonAction(btn);
	}
	
	private void buttonAction(Button btn) {
		
		
		switch (btn.getText()) {
			case "Salvar":
				Return result = null;
				result = this.saveOrUpdate();		
				
				if (!result.isSucess()) {
					JOptionPane.showMessageDialog(null, result.getMessage());
				} else {
					this.screenTransitions.showMainFrame();
					this.currentFrame.dispose();
					JOptionPane.showMessageDialog(null, result.getMessage());
				}
				break;
				
			default:
				this.screenTransitions.showMainFrame();
				this.currentFrame.dispose();
		}
	}
	
	private Return saveOrUpdate() {
		if (this.currentFrame.getTitle() == "Edição")
			return updateAction();
		else
			return saveAction();
	}
	
	private Return saveAction() {
		createPet();
		Return result = this.controlPet.include(this.pet);
		
		return result;
	}
	
	private Return updateAction() {
		createPet();
		Return result = this.controlPet.update(this.pet);
		
		return result;
	}
	
	
	private Return createPet() {
		try {
			this.pet.setName(this.name.getText());
			this.pet.setRace(this.race.getText());
			this.pet.setGender(this.gender.getSelectedItem().toString());
			this.pet.setSpecie(this.specie.getText());
			
			String date = this.birth.getJFormattedTextField().getText();
			String dateArray[] = date.split("-");
			
			Calendar cal = Calendar.getInstance();
			cal.set(Integer.parseInt(dateArray[0]), Integer.parseInt(dateArray[1])-1, Integer.parseInt(dateArray[2]));
			
			Date birthDate = new Date(cal.getTimeInMillis());
			
			this.pet.setBirth(birthDate);
			
		} catch (NumberFormatException e) {
			return new Return(false, "Preencha todos os campos!", null);
		}
		
		return new Return(true, "Pet preenchido com sucesso", null);
	}
}






















