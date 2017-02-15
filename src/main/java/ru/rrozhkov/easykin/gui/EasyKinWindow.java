package ru.rrozhkov.easykin.gui;

import static ru.rrozhkov.easykin.gui.PanelFactory.createPanel;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.KeyStroke;

import ru.rrozhkov.easykin.context.MasterDataContext;
import ru.rrozhkov.easykin.gui.util.ContextUtil;
import ru.rrozhkov.easykin.model.category.ICategory;
import ru.rrozhkov.easykin.util.DateUtil;

public class EasyKinWindow extends JFrame implements IGUIEditor{
	private static final long serialVersionUID = 1L;
	
	private JTabbedPane tabbedPane = new JTabbedPane();
	private MasterDataContext context;
	public EasyKinWindow(MasterDataContext context) throws HeadlessException {
		super("EasyKin, "+DateUtil.formatWeek(new Date()));
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
            	add();
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

	public void edit(int index){
        if(getContentPane().getComponentCount()>1){
        	Component form = getContentPane().getComponent(1);
        	getContentPane().remove(form);
        }
			
		ICategory currentCategory = ContextUtil.getCurrentCategory(context, tabbedPane);
        Object obj = context.getObjByIndex(currentCategory, index);
        JPanel content = new JPanel(new BorderLayout());
        JPanel formPanel = FormFactory.getFormPanel(context, this, currentCategory, obj);
        content.add(formPanel,BorderLayout.NORTH);

        getContentPane().setLayout(new GridLayout(1,2));
    	getContentPane().add(getContentPane().getComponent(0));
        getContentPane().add(content);
        getContentPane().validate();
	}

    public void add() {
        edit(-1);
    }

    public void closeEditor() {
        if(getContentPane().getComponentCount()>1){
            Component form = getContentPane().getComponent(1);
            getContentPane().remove(form);
        }
        getContentPane().validate();
    }

    public void refresh() {
        super.repaint();
        fillTabbedPane();
    }

    private void fillTabbedPane(){
        tabbedPane.removeAll();
        for(ICategory category : context.categories()) {
        	tabbedPane.addTab(category.getName(), createPanel(this, context, category));
        }
	}
}