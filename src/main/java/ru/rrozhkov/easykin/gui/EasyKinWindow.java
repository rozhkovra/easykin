package ru.rrozhkov.easykin.gui;

import static ru.rrozhkov.easykin.gui.PanelFactory.createPanel;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.KeyStroke;

import ru.rrozhkov.easykin.context.EasyKinContext;
import ru.rrozhkov.easykin.gui.util.ContextUtil;
import ru.rrozhkov.easykin.model.category.ICategory;

public class EasyKinWindow extends JFrame{
	private static final long serialVersionUID = 1L;
	
	private JTabbedPane tabbedPane = new JTabbedPane();
	private EasyKinContext context;
	public EasyKinWindow(EasyKinContext context) throws HeadlessException {
		super("EasyKin");
		this.context = context;
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
		ICategory currentCategory = ContextUtil.getCategoryByTabIndex(context, tabbedPane, currentTabIndex);
        Object obj = context.getObjByIndex(currentCategory, index);
        JPanel content1 = new JPanel(new BorderLayout());
        JPanel formPanel = FormFactory.getFormPanel(context, this, currentCategory, obj);
        content1.add(formPanel,BorderLayout.NORTH);

        getContentPane().setLayout(new GridLayout(1,2));
    	getContentPane().add(getContentPane().getComponent(0));
        getContentPane().add(content1);
	}
	
	private void fillTabbedPane(){
        tabbedPane.removeAll();
        for(ICategory category : context.categories()) {
        	tabbedPane.addTab(category.getName(), createPanel(this, context, category));
        }
	}
}