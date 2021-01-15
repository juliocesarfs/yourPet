package controller;

import java.util.Calendar;
import java.sql.Date;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;

import model.Pet;
import utils.Return;
import view.CreatePetFrame;
import view.DeletePetFrame;
import view.EditPetFrame;
import view.MainFrame;
import view.components.Button;
import view.components.FormPanel;
import view.components.TablePanel;

public class ControlButtons {
	
	public MainFrame mainFrame;
	public CreatePetFrame createPetFrame;
	public EditPetFrame editPetFrame;
	public DeletePetFrame deletePetFrame;
	public Button btn;
	public ControlPet controlPet = new ControlPet();
	public JPanel panel;
	public Pet pet = new Pet();
	
	public ControlButtons(Button btn, JPanel panel) {
		this.btn = btn;
		this.panel = panel;
	}
	
	public void open() {
		if (this.btn.getID() == 1) {
			TablePanel tablePanel = (TablePanel) panel;
			
			String boxSelected = tablePanel.option.getSelectedItem().toString();
			if (boxSelected == "Inserir") {
				this.createPetFrame = new CreatePetFrame("Inserir", this.mainFrame);
				this.createPetFrame.setVisible(true);
				
			} else if (boxSelected == "Editar") {
				JTable table = tablePanel.table;
				
				
				this.editPetFrame = new EditPetFrame("Edição", this.mainFrame, this.pet);
				this.editPetFrame.setVisible(true);
				
			} else if (boxSelected == "Deletar") {
				JTable table = tablePanel.table;
				int row = table.getSelectedRow();
				int petID = (Integer) table.getValueAt(row, 0);
				
				this.pet = (Pet) this.controlPet.getPetById(petID).getValue();
				
				this.deletePetFrame = new DeletePetFrame("Exclusão", this.mainFrame, this.pet);
				this.deletePetFrame.setVisible(true);
			}
			
			
		} else {
			 if (this.btn.getText() == "Salvar") {
				saveAction();
			 }
			this.mainFrame = new MainFrame("yourPet");
			this.mainFrame.setVisible(true);
		}
	}

	private Return saveAction() {
		try {
			FormPanel form = (FormPanel) this.panel;
			this.pet.setName(form.name.getText());
			this.pet.setRace(form.race.getText());
			this.pet.setGender(form.gender.getSelectedItem().toString());
			this.pet.setSpecie(form.specie.getText());
			
			String date = form.birth.getJFormattedTextField().getText();
			String dateArray[] = date.split("-");
			
			Calendar cal = Calendar.getInstance();
			cal.set(Integer.parseInt(dateArray[0]), Integer.parseInt(dateArray[1])-1, Integer.parseInt(dateArray[2]));
			
			Date birthDate = new Date(cal.getTimeInMillis());
			
			this.pet.setBirth(birthDate);
		} catch (NumberFormatException e) {
			return new Return(false, "Preencha todos os campos!", null);
		}
		
		Return result = this.controlPet.include(this.pet);
		
		return result;
	}

}
