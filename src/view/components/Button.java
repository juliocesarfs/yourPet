package view.components;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import controller.ControlButtons;
import view.CreatePetFrame;
import view.styles.CustomeBorder;

public class Button extends JButton implements ActionListener {
	
	public Color backgroundColor = Color.white;
	public Font font = new Font("Roboto", Font.BOLD, 17);
	public JFrame closeWindow, openWindow;
	public ControlButtons controlBtn;
	
    public Color getBackgroundColor() {
		return backgroundColor;
	}

	public void setBackgroundColor(Color backgroundColor) {
		this.backgroundColor = backgroundColor;
	}

	public Font getFont() {
		return font;
	}

	public void setFont(Font font) {
		this.font = font;
	}

    public Button(String title, JFrame closeWindow, JFrame openWindow) {
    	this.closeWindow = closeWindow;
    	this.openWindow = openWindow;
    	
        CustomeBorder customeBorder = new CustomeBorder();
        setBorder(customeBorder.getCompoundBorder());
        setForeground(Color.gray);
        setBackground(backgroundColor);
        setText(title);
        setFont(font);
        addActionListener(this);
        
        controlBtn = new ControlButtons(this);
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		this.closeWindow.dispose();
		this.controlBtn.open();
	}
}
