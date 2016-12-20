package ru.rrozhkov.easykin.gui;

import static ru.rrozhkov.easykin.gui.PanelFactory.createPanels;
import static ru.rrozhkov.easykin.gui.PanelFactory.createServiceForm;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import ru.rrozhkov.easykin.category.Category;

public class EasyKinWindow extends JFrame{
	private static final long serialVersionUID = 1L;
	private Map<Category, JPanel> panels;
	public EasyKinWindow() throws HeadlessException {
		super();
		this.panels = createPanels();
		
		setLayout(new GridLayout(1,2));
        final JTabbedPane tabbedPane = new JTabbedPane();
        for(Category key : panels.keySet()) {
        	tabbedPane.addTab(key.toString(), this.panels.get(key));
        }
                
        JPanel content = new JPanel();
        content.setLayout(new BorderLayout());
        content.add(tabbedPane, BorderLayout.CENTER);        
        add(content);
        
        JPanel content1 = new JPanel();
        content1.setLayout(new BorderLayout());
        content1.add(createServiceForm(),BorderLayout.NORTH);
        add(content1);
        
    	setExtendedState(JFrame.MAXIMIZED_BOTH);
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	setVisible(true);
    	setTitle("EasyKin");
	}
}
