package view.components;

import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.ControlPet;
import model.Pet;
import view.CreatePetFrame;
import view.MainFrame;

public class TablePanel extends JPanel {
	
	public JTable table;
	public Button btnEdit;
	public Button btnDelete;
	public Button btnInsert;
	public List<Pet> list;
	
	public ControlPet control = new ControlPet();
	DefaultTableModel model = new DefaultTableModel();
	
	public TablePanel(MainFrame currentFrame) {
		String [] columns = {"NOME", "RAÇA", "ESPÉCIE", "IDADE", "SEXO"};
		
		this.table = new JTable(model);
		
		JScrollPane scroll = new JScrollPane(createTable());
		
		btnInsert = new Button("Inserir", currentFrame, this);
		
		add(scroll);
		add(btnInsert);
		
	}
	
	private JTable createTable() {
		this.list = (List<Pet>) this.control.listAll().getValue();
		
		this.model.addColumn("NOME");
		this.model.addColumn("RAÇA");
		this.model.addColumn("ESPÉCIE");
		this.model.addColumn("IDADE");
		this.model.addColumn("SEXO");
		
		for (Pet pet : this.list) {
			this.model.addRow(new Object[]{pet.getName(), pet.getRace(), pet.getSpecie(), "5", pet.getGender()});
		}
		
		return this.table;
    }
}
