package ru.rrozhkov.easykin.gui;

import static ru.rrozhkov.easykin.gui.PanelFactory.createPanels;
import static ru.rrozhkov.easykin.gui.PanelFactory.createTaskForm;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class EasyKinWindow extends JFrame{
	private static final long serialVersionUID = 1L;
	private Map<String, JPanel> panels;
	public EasyKinWindow() throws HeadlessException {
		super();
		this.panels = createPanels();
		
        final JTabbedPane tabbedPane = new JTabbedPane();
        for(String key : panels.keySet()) {
        	tabbedPane.addTab(key, this.panels.get(key));
        }
                
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
                content1.add(createTaskForm(EasyKinWindow.this),BorderLayout.NORTH);
                getContentPane().add(content1);        		
            }           
        });
        fileMenu.add(addItem);
        
        menuBar.add(fileMenu);
        
		setJMenuBar(menuBar);
	}

	@Override
	public void repaint() {
		super.repaint();
    	Component main = getContentPane().getComponent(0);
    	Component form = getContentPane().getComponent(1);
    	getContentPane().remove(form);
    	getContentPane().setLayout(new BorderLayout());
    	getContentPane().add(main);
	}
}
