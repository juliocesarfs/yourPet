package controller;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.sql.Date;

import javax.swing.JPanel;

import model.Pet;
import utils.Return;
import view.CreatePetFrame;
import view.MainFrame;
import view.components.Button;
import view.components.FormPanel;

public class ControlButtons {
	
	public MainFrame mainFrame;
	public CreatePetFrame createPetFrame;
	public Button btn;
	public ControlPet controlPet = new ControlPet();
	public JPanel panel;
	public Pet pet = new Pet();
	
	public ControlButtons(Button btn, JPanel panel) {
		this.btn = btn;
		this.panel = panel;
	}
	
	public void open() {
		if (this.btn.getText() == "Inserir") {
			this.createPetFrame = new CreatePetFrame("Inserir", this.mainFrame);
			this.createPetFrame.setVisible(true);
		} else {
			 if (this.btn.getText() == "Salvar") {
				FormPanel form = (FormPanel) panel;
				this.pet.setName(form.name.getText());
				this.pet.setRace(form.race.getText());
				this.pet.setGender(form.gender.getSelectedItem().toString());
				this.pet.setSpecie(form.specie.getText());
				
				String date = form.birth.getJFormattedTextField().getText();
				System.out.println(date);
				String dateArray[] = date.split("-");
				
				System.out.println(Integer.parseInt(dateArray[0]));
				
				Calendar cal = Calendar.getInstance();
				cal.set(Integer.parseInt(dateArray[0]), Integer.parseInt(dateArray[1])-1, Integer.parseInt(dateArray[2]));
				
				Date birthDate = new Date(cal.getTimeInMillis());
				
				System.out.println(birthDate.toString());
				
				this.pet.setBirth(birthDate);
				System.out.println(this.pet.getName());
				
				Return result = this.controlPet.include(this.pet);
				
				System.out.println(result.getMessage());
			 }
			this.mainFrame = new MainFrame("yourPet");
			this.mainFrame.setVisible(true);
		}
	}

}
