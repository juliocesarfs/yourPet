package view.components;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;

import view.styles.CustomeBorder;

public class Button extends JButton {
	
	public Color backgroundColor = Color.white;
	public Font font = new Font("Roboto", Font.BOLD, 17);
	
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

    public Button(String title) {
 
        CustomeBorder customeBorder = new CustomeBorder();
        setBorder(customeBorder.getCompoundBorder());
        setForeground(Color.black);
        setBackground(backgroundColor);
        setText(title);
        setFont(font);
       
    }
}
