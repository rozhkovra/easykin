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
	
	private JTabbedPane tabbedPane = new JTabbedPane();
	public EasyKinWindow() throws HeadlessException {
		super("EasyKin");
        fillTabbedPane();
        createMenuBar();
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(tabbedPane, BorderLayout.CENTER);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		int currentTabIndex = tabbedPane.getSelectedIndex();
        Object obj = null;
    	getContentPane().setLayout(new GridLayout(1,2));
    	getContentPane().add(getContentPane().getComponent(0));
        if(index!=-1){
        	JPanel panel = (JPanel)tabbedPane.getComponentAt(currentTabIndex);
        	if(panel instanceof TablePanel){
        		obj = ((TablePanel)panel).getTable().getObjByIndex(index);
        	}
        }
        JPanel content1 = new JPanel(new BorderLayout());
        JPanel formPanel = FormFactory.createPanels(EasyKinWindow.this, obj).get(tabbedPane.getTitleAt(currentTabIndex));
        content1.add(formPanel,BorderLayout.NORTH);
        getContentPane().add(content1);
        super.repaint();
	}
	
	private void fillTabbedPane(){
        tabbedPane.removeAll();
		Map<String, JPanel> panels = createPanels(this);
        for(String key : panels.keySet()) {
        	tabbedPane.addTab(key, panels.get(key));
        }
	}
}