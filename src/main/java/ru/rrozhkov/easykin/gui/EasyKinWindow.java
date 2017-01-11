package ru.rrozhkov.easykin.gui;

import static ru.rrozhkov.easykin.gui.PanelFactory.createPanels;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.KeyStroke;

public class EasyKinWindow extends JFrame{
	private static final long serialVersionUID = 1L;
	
	private JTabbedPane tabbedPane;
	public EasyKinWindow() throws HeadlessException {
		super();
        tabbedPane = new JTabbedPane();
        fillTabbedPane();
        
        JPanel content = new JPanel();
        content.setLayout(new BorderLayout());
        content.add(tabbedPane, BorderLayout.CENTER);        
        getContentPane().add(content);
        
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	setTitle("EasyKin");
    	createMenuBar();
    	
    	setVisible(true);
	}
	
	private void createMenuBar(){
		JMenuBar menuBar = new JMenuBar();
        
        JMenu fileMenu = new JMenu("Command");
         
        JMenuItem addItem = new JMenuItem("Add");
        addItem.addActionListener(new ActionListener() {           
            public void actionPerformed(ActionEvent e) {
        		if(getContentPane().getComponentCount()>1)
        			return;
            	Component main = getContentPane().getComponent(0);
            	getContentPane().setLayout(new GridLayout(1,2));
            	getContentPane().add(main);
                JPanel content1 = new JPanel();
                content1.setLayout(new BorderLayout());
                content1.add(FormFactory.createPanels(EasyKinWindow.this).get(tabbedPane.getTitleAt(tabbedPane.getSelectedIndex())),BorderLayout.NORTH);
                getContentPane().add(content1);        		
            }           
        });
        addItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_F4, ActionEvent.SHIFT_MASK));
        fileMenu.add(addItem);
        
        JMenuItem refreshItem = new JMenuItem("Refresh");
        refreshItem.addActionListener(new ActionListener() {           
            public void actionPerformed(ActionEvent e) {
            	repaint();
            }           
        });
        refreshItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_F5, ActionEvent.CTRL_MASK));
        fileMenu.add(refreshItem);
        
        menuBar.add(fileMenu);
        
		setJMenuBar(menuBar);
	}

	@Override
	public void repaint() {
		super.repaint();
		fillTabbedPane();
	}
	
	private void fillTabbedPane(){
        tabbedPane.removeAll();
		Map<String, JPanel> panels = createPanels();
        for(String key : panels.keySet()) {
        	tabbedPane.addTab(key, panels.get(key));
        }
        tabbedPane.getSelectedIndex();
	}
}