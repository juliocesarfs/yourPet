package view.components;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import view.controller.ScreenTransitions;

public class TablePanel extends JPanel implements ActionListener {
	
	public MainFrame currentFrame;
	
	public Table table;
	public Button btnInsert;
	public Button btnEdit;
	public Button btnDelete;
	public List<Pet> list;
	
	public ControlPet control = new ControlPet();
	public ScreenTransitions screenTransitions;
	
	public TablePanel(MainFrame currentFrame) {
		setLayout(new FlowLayout());
		this.currentFrame = currentFrame;
		this.table = new Table();
		
		JScrollPane scroll = new JScrollPane(table);
		
		this.btnInsert = new Button("Inserir");
		this.btnEdit = new Button("Editar");
		this.btnDelete = new Button("Deletar");
		
		this.btnInsert.addActionListener(this);
		this.btnEdit.addActionListener(this);
		this.btnDelete.addActionListener(this);
		
		
		add(scroll);
		add(this.btnInsert);
		add(this.btnEdit);
		add(this.btnDelete);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Button btn = (Button) e.getSource();
		this.actionButton(btn);
		
	}
	
	
	private void actionButton(Button btn) {
		Pet pet = null;
		switch (btn.getText()) {
		case "Inserir":
			 this.screenTransitions = new ScreenTransitions(null);
			this.screenTransitions.showCreatePetFrame();
			this.currentFrame.dispose();
			break;
		case "Editar":
			pet = this.table.getSelectedPet();
			this.screenTransitions = new ScreenTransitions(pet);
			this.screenTransitions.showEditPetFrame();
			this.currentFrame.dispose();
			break;
		case "Deletar":
			pet = this.table.getSelectedPet();
			this.screenTransitions = new ScreenTransitions(pet);
			this.screenTransitions.showDeletePetFrame();
			this.currentFrame.dispose();
			break;
		}
	}
	
	
	
}
