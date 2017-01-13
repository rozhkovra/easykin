package ru.rrozhkov.easykin.gui;

import static ru.rrozhkov.easykin.gui.PanelFactory.createPanels;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.List;
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
        createMenuBar();
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(tabbedPane, BorderLayout.CENTER);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	setTitle("EasyKin");
    	
    	setVisible(true);
	}
	
	private void createMenuBar(){
        JMenuItem addItem = new JMenuItem("Add");
        addItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, ActionEvent.SHIFT_MASK));
        addItem.addActionListener(new ActionListener() {           
            public void actionPerformed(ActionEvent e) {
            	edit(-1);
            }           
        });
        
        JMenuItem refreshItem = new JMenuItem("Refresh");
        refreshItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F5, ActionEvent.CTRL_MASK));
        refreshItem.addActionListener(new ActionListener() {           
            public void actionPerformed(ActionEvent e) {
            	repaint();
            }           
        });
        
        JMenu fileMenu = new JMenu("Command");
        fileMenu.add(addItem);
        fileMenu.add(refreshItem);

		JMenuBar menuBar = new JMenuBar();        
        menuBar.add(fileMenu);
		setJMenuBar(menuBar);
	}

	@Override
	public void repaint() {
		super.repaint();
		fillTabbedPane();
	}
	
	public void edit(int index){
		if(getContentPane().getComponentCount()>1)
			return;
    	Component main = getContentPane().getComponent(0);
    	getContentPane().setLayout(new GridLayout(1,2));
    	getContentPane().add(main);
        Object obj = null;
        if(index!=-1){
        	JPanel panel = (JPanel)tabbedPane.getComponentAt(tabbedPane.getSelectedIndex());
        	if(panel instanceof TablePanel){
        		List list = (List)((TablePanel)panel).getTable().getData();
        		obj = list.get(index);
        	}
        }
        JPanel content1 = new JPanel();
        content1.setLayout(new BorderLayout());
        JPanel formPanel = FormFactory.createPanels(EasyKinWindow.this, obj).get(tabbedPane.getTitleAt(tabbedPane.getSelectedIndex()));
        content1.add(formPanel,BorderLayout.NORTH);
        getContentPane().add(content1);  
	}
	
	private void fillTabbedPane(){
        tabbedPane.removeAll();
		Map<String, JPanel> panels = createPanels(this);
        for(String key : panels.keySet()) {
        	tabbedPane.addTab(key, panels.get(key));
        }
	}
}