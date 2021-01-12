package view.components;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.Properties;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import lombok.Data;
import utils.DateLabelFormatter;

public class FormPanel extends JPanel {
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
	
	public FormPanel(JFrame currentFrame) {
		setLayout(null);
		
		
		this.labelName = new JLabel("Nome:");
		this.name = new JTextField();
		this.labelName.setBounds(50, 40, 100, 20);
		this.name.setBounds(150, 40, 100, 20);
		add(this.labelName);
		add(this.name);
		
		
		this.labelRace = new JLabel("Raça:");
		this.race = new JTextField();
		this.labelRace.setBounds(50, 80, 100, 20);
		this.race.setBounds(150, 80, 100, 20);
		add(this.labelRace);
		add(this.race);
		
		this.labelSpecie = new JLabel("Espécie:");
		this.specie = new JTextField();
		this.labelSpecie.setBounds(50, 120, 100, 20);
		this.specie.setBounds(150, 120, 100, 20);
		add(this.labelRace);
		add(this.race);
		add(this.labelSpecie);
		add(this.specie);

		this.labelGender = new JLabel("Sexo:");
		String genders[] = {"F", "M"};
		this.gender = new JComboBox(genders);
		this.labelGender.setBounds(50, 160, 100, 20);
		this.gender.setBounds(150, 160, 100, 20);
		add(this.labelRace);
		add(this.race);
		add(this.labelGender);
		add(this.gender);
		
		this.labelBirth = new JLabel("Nascimento:");
		UtilDateModel model = new UtilDateModel();
		
		Properties p = new Properties();
		p.put("text.today", "Hoje");
		p.put("text.month", "Mês");
		p.put("text.year", "Ano");
		
		JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
		this.birth = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		this.labelBirth.setBounds(50, 200, 100, 20);
		this.birth.setBounds(150, 200, 120, 30);
		add(this.labelRace);
		add(this.race);
		add(this.labelBirth);
		add(this.birth);
		
		
		this.btnBack = new Button("Voltar", currentFrame, this);
		this.btnBack.setBounds(120, 260, 100, 50);
		add(btnBack);
		
		this.btnSave = new Button("Salvar", currentFrame, this);
		this.btnSave.setBounds(230, 260, 100, 50);
		add(btnSave);
		
	}
	
}
