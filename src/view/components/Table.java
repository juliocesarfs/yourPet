package view.components;

import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.ControlPet;
import exception.PersistenceException;
import model.Pet;

public class Table extends JTable {
	
	public DefaultTableModel model = new DefaultTableModel();
	public ControlPet controlPet = new ControlPet();
	public List<Pet> list;
	
	public Table() {
		this.setModel(this.model);
		
		this.list = (List<Pet>) this.controlPet.listAll().getValue();
		
		this.model.addColumn("CODIGO");
		this.model.addColumn("NOME");
		this.model.addColumn("RAÇA");
		this.model.addColumn("ESPÉCIE");
		this.model.addColumn("IDADE");
		this.model.addColumn("SEXO");
		
		for (Pet pet : list) {
			this.model.addRow(new Object[]{pet.getId(), pet.getName(), pet.getRace(), pet.getSpecie(), pet.getAge(), pet.getGender()});
		}
	}
	
	public Pet getSelectedPet() {
		Pet pet;
		try {
			int row = this.getSelectedRow();
			int petID = (Integer) this.getValueAt(row, 0);
			
			pet = (Pet) this.controlPet.getPetById(petID).getValue();
			return pet;
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new PersistenceException("Selecione uma linha da tabela", e);
		}
	}

}
