package view;

import java.awt.event.ActionListener;

import javax.swing.*;

import view.screens.MainScreen;

public class MainFrame extends JFrame {
    public MainFrame(String title) {
        super(title);
        setDefaultCloseOperation(MainFrame.EXIT_ON_CLOSE);
        setSize(480, 450);
        setResizable(false);


        getContentPane().add(new MainScreen(this));
        setVisible(true);
    }
}