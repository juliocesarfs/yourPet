package view;

import javax.swing.JFrame;
import javax.swing.JTextField;

import view.screens.TesteScreen;

public class TesteFrame extends JFrame {
	
	MainFrame mainWindow;
	public TesteFrame(String title, MainFrame mainWindow) {
        super(title);
        this.mainWindow = mainWindow;
        setDefaultCloseOperation(TesteFrame.HIDE_ON_CLOSE);
        setSize(480, 450);
        setResizable(false);
        
        getContentPane().add(new TesteScreen(this.mainWindow));

        setVisible(true);
    }
}
