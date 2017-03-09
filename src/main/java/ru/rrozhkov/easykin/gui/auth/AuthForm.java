package ru.rrozhkov.easykin.gui.auth;

import ru.rrozhkov.easykin.auth.AuthManager;
import ru.rrozhkov.easykin.gui.IGUIEditor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AuthForm extends JPanel{
	private static final long serialVersionUID = 1L;
	private JTextField usernameField;
	private JTextField passwordField;
	private JLabel usernameLabel;
	private JLabel passwordLabel;
	private JButton okButton;
	private JButton cancelButton;
	private AuthManager authManager;
	private IGUIEditor parent;

	public AuthForm(IGUIEditor parent, AuthManager authManager) {
		this.authManager = authManager;
		this.parent = parent;
		fill();
	}
	
	private void fill(){
		setLayout(new GridLayout(3, 2));
		add(getUsernameLabel());
		add(getUsernameField());
		add(getPasswordLabel());
		add(getPasswordField());
		add(getOkButton());
		add(getCancelButton());
	}
	
	private JTextField getUsernameField(){
		if(usernameField == null){
			usernameField = new JTextField(250);
		}
		return usernameField;
	}

	private JTextField getPasswordField(){
		if(passwordField == null){
			passwordField = new JTextField(10);
		}
		return passwordField;
	}
	
	private JLabel getUsernameLabel(){
		if(usernameLabel == null)
			usernameLabel = new JLabel("Пользователь");
		return usernameLabel;
	}
	
	private JLabel getPasswordLabel(){
		if(passwordLabel == null)
			passwordLabel = new JLabel("Пароль");
		return passwordLabel;
	}

	public JButton getOkButton(){
	    if(okButton==null){
			okButton = new JButton("Ок");
			okButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
					if(!validate()) {
						JOptionPane.showMessageDialog((JFrame)parent, "Username or password can't be empty!!!");
						return;
					}
					authManager.signIn(getUsernameField().getText().toString(),getPasswordField().getText().toString());
					if(!authManager.isSignedIn()) {
						System.out.println("Логин/пароль не верны.");
					}
					parent.closeEditor();
				}

				private boolean validate(){
					return !getUsernameField().getText().toString().isEmpty()
							&& !getPasswordField().getText().toString().isEmpty();
				}
	        });
	    }
		return okButton;
	}
	
	private Component getCancelButton() {
	    if(cancelButton==null){
			cancelButton = new JButton("Закрыть");
			cancelButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
					parent.closeEditor();
	            }
	        });
	    }
		return cancelButton;
	}
}