package view.components;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import controller.ControlPet;
import exception.PersistenceException;
import model.Pet;
import utils.Constants;
import utils.Return;
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
	
	public Constants constant;
	
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
		
		this.constant = new Constants();
		
		this.btnInsert.setBackground(constant.COLOR_GREEN);
		this.btnEdit.setBackground(constant.COLOR_PURPLE);
		this.btnDelete.setBackground(constant.COLOR_RED);
		
		this.setBackground(constant.COLOR_BACKGROUND);
		
		
		add(scroll);
		add(this.btnInsert);
		add(this.btnEdit);
		add(this.btnDelete);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Button btn = (Button) e.getSource();
		Return result = this.actionButton(btn);
		
		if (!result.isSucess())
			JOptionPane.showMessageDialog(null, result.getMessage());
	}
	
	
	private Return actionButton(Button btn) {
		Pet pet = null;
		try {
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
		} catch (PersistenceException e) {
			return new Return(false, "Selecione uma linha da tabela", null);
		}
		
		return new Return(true, "Botão acionado com sucesso", null);
	}
}
