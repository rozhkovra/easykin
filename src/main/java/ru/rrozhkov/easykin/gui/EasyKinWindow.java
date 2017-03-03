package ru.rrozhkov.easykin.gui;

import ru.rrozhkov.easykin.context.MasterDataContext;
import ru.rrozhkov.easykin.gui.image.ImageManager;
import ru.rrozhkov.easykin.gui.util.ContextUtil;
import ru.rrozhkov.easykin.gui.util.ImageUtil;
import ru.rrozhkov.easykin.model.category.ICategory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import static ru.rrozhkov.easykin.gui.PanelFactory.createPanel;

public class EasyKinWindow extends JFrame implements IGUIEditor{
	private static final long serialVersionUID = 1L;
	private JTabbedPane tabbedPane;
	private MasterDataContext context;

	public EasyKinWindow(MasterDataContext context) throws HeadlessException {
		super(ContextUtil.title());
        setIconImage(ImageManager.logo());
		this.context = context;
        fill();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	setVisible(true);
	}

    private void fill() {
        createMenuBar();
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        getContentPane().add(getMenuButtons());
        getContentPane().add(getTabbedPanel(), BorderLayout.SOUTH);
    }

 	public void edit(int index){
        closeEditor();

		ICategory currentCategory = ContextUtil.getCurrentCategory(context, getTabbedPane(false));
        Object obj = context.getObjByIndex(currentCategory, index);
        JPanel content = new JPanel(new BorderLayout());
        JPanel formPanel = FormFactory.getFormPanel(context, this, currentCategory, obj);
        content.add(formPanel,BorderLayout.NORTH);
        Container main = (Container)getContentPane().getComponent(1);
        main.setLayout(new GridLayout(1, 2));
        main.add(main.getComponent(0));
        main.add(content);
        main.validate();
	}

    public void add() {
        edit(-1);
    }

    public void closeEditor() {
        Container main = (Container)getContentPane().getComponent(1);
        if(main.getComponentCount()>1){
            Component form = main.getComponent(1);
            main.remove(form);
        }
        main.validate();
        getContentPane().validate();
    }

    public void refresh() {
        super.repaint();
        context.init();
        getTabbedPane(true);
    }

     private JTabbedPane getTabbedPane(boolean reload){
        if(tabbedPane==null){
            tabbedPane = new JTabbedPane();
        }
        if(reload){
            tabbedPane.removeAll();
            for(ICategory category : context.categories()) {
                tabbedPane.addTab(category.getName(), createPanel(this, context, category));
            }
        }
        return tabbedPane;
    }

    private JPanel getTabbedPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(getTabbedPane(true));
        return panel;
    }

    private JPanel getMenuButtons() {
        JPanel menuButtons = new JPanel();
        menuButtons.setLayout(new BoxLayout(menuButtons, BoxLayout.X_AXIS));

        ImageIcon plusIcon = ImageUtil.scaleImage(70, 70, ImageManager.plus());
        JButton plusButton = new JButton(plusIcon);
        plusButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                add();
            }
        });
        menuButtons.add(plusButton);

        ImageIcon refreshIcon = ImageUtil.scaleImage(70, 70, ImageManager.refresh());
        JButton refreshButton = new JButton(refreshIcon);
        refreshButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                refresh();
            }
        });
        menuButtons.add(refreshButton);
        return menuButtons;
    }

    private void createMenuBar(){
        JMenuItem addItem = new JMenuItem("Добавить");
        addItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, ActionEvent.SHIFT_MASK));
        addItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                add();
            }
        });

        JMenuItem refreshItem = new JMenuItem("Обновить");
        refreshItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F5, ActionEvent.CTRL_MASK));
        refreshItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                refresh();
            }
        });

        JMenu fileMenu = new JMenu("Меню");
        fileMenu.add(addItem);
        fileMenu.add(refreshItem);

        JMenuBar menuBar = new JMenuBar();
        menuBar.add(fileMenu);
        setJMenuBar(menuBar);
    }
}