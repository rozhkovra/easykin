package ru.rrozhkov.easykin.gui.auth;

import ru.rrozhkov.easykin.auth.AuthManager;
import ru.rrozhkov.easykin.gui.Form;
import ru.rrozhkov.easykin.gui.IGUIEditor;
import ru.rrozhkov.easykin.gui.util.GuiUtil;

import javax.swing.*;
import java.awt.*;

public class AuthForm extends Form {
	private static final long serialVersionUID = 1L;
	private JTextField usernameField;
	private JTextField passwordField;
	private Component usernameLabel;
	private Component passwordLabel;
	private AuthManager authManager;

	public AuthForm(final IGUIEditor parent, AuthManager authManager) {
		super(parent);
		this.authManager = authManager;
		fill();
	}
	
	protected void fill(){
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
			usernameField = new JTextField(50);
			usernameField.addKeyListener(keyListener());
		}
		return usernameField;
	}

	private JTextField getPasswordField(){
		if(passwordField == null){
			passwordField = new JTextField(50);
			passwordField.addKeyListener(keyListener());
		}
		return passwordField;
	}
	
	private Component getUsernameLabel(){
		if(usernameLabel == null)
			usernameLabel = GuiUtil.label("Пользователь");
		return usernameLabel;
	}
	
	private Component getPasswordLabel(){
		if(passwordLabel == null)
			passwordLabel = GuiUtil.label("Пароль");
		return passwordLabel;
	}

	protected void ok(){
		if (!validateData()) {
			JOptionPane.showMessageDialog((JFrame) parent, "Username or password can't be empty!!!");
			return;
		}
		authManager.signIn(getUsernameField().getText().toString(), getPasswordField().getText().toString());
		if (!authManager.isSignedIn()) {
			JOptionPane.showMessageDialog((JFrame) parent, "Username or password incorrect!!!");
		} else
			parent.closeEditor();
	}

	protected boolean validateData(){
		return !getUsernameField().getText().toString().isEmpty()
				&& !getPasswordField().getText().toString().isEmpty();
	}
}