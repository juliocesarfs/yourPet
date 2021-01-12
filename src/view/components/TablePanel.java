package view.components;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
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
	public Button btnConfirm;
	public List<Pet> list;
	public JComboBox<String> option;
	
	public ControlPet control = new ControlPet();
	DefaultTableModel model = new DefaultTableModel();
	
	public TablePanel(MainFrame currentFrame) {
		setLayout(new FlowLayout());
		
		this.table = new JTable(model);
		
		JScrollPane scroll = new JScrollPane(createTable());
		
		String options[] = {"Inserir", "Editar", "Deletar"};
		
		option = new JComboBox<String>(options);
		
		btnConfirm = new Button("Confirmar", 1, currentFrame, this);
		
		add(scroll);
		add(option);
		add(btnConfirm);
		
	}
	
	private JTable createTable() {
		this.list = (List<Pet>) this.control.listAll().getValue();
		
		this.model.addColumn("CODIGO");
		this.model.addColumn("NOME");
		this.model.addColumn("RAÇA");
		this.model.addColumn("ESPÉCIE");
		this.model.addColumn("IDADE");
		this.model.addColumn("SEXO");
		
		for (Pet pet : this.list) {
			this.model.addRow(new Object[]{pet.getId(), pet.getName(), pet.getRace(), pet.getSpecie(), "5", pet.getGender()});
		}
		
		return this.table;
    }
}
