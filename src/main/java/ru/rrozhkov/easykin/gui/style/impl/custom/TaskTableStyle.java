package ru.rrozhkov.easykin.gui.style.impl.custom;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.Collection;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import ru.rrozhkov.easykin.gui.style.impl.TableStyle;
import ru.rrozhkov.easykin.task.ITask;
import ru.rrozhkov.easykin.task.Priority;
import ru.rrozhkov.easykin.task.Status;

public class TaskTableStyle extends TableStyle<ITask>  {
	public int[] getColumnAlignment() {
		return new int[]{JLabel.CENTER,JLabel.LEFT,JLabel.CENTER,JLabel.CENTER,JLabel.CENTER,JLabel.CENTER};
	}
	
	public String[] getColumnNames() {
		return new String[]{"№","Описание","Дата", "Приоритет", "Категория", "Статус"};
	}
	
	public void setColumnStyles(JTable table){
	    super.setColumnStyles(table);
	    table.getColumnModel().getColumn(0).setPreferredWidth(50);
	    table.getColumnModel().getColumn(1).setMinWidth(300);
	    table.getColumnModel().getColumn(1).setMaxWidth(400);
	    table.getColumnModel().getColumn(2).setMinWidth(100);
	    table.getColumnModel().getColumn(2).setMaxWidth(200);
	    table.getColumnModel().getColumn(3).setMinWidth(150);
	    table.getColumnModel().getColumn(3).setMaxWidth(200);
	    table.getColumnModel().getColumn(4).setMinWidth(100);
	    table.getColumnModel().getColumn(4).setMaxWidth(200);
	    table.getColumnModel().getColumn(5).setMinWidth(100);
	    table.getColumnModel().getColumn(5).setMaxWidth(200);
	}

	@Override
	public void setCellRenderer(JTable table, final Collection<ITask> data) {
		table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer()
		{
		    @Override
		    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
		    {
		        final Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		        ITask task = (ITask) ((List)data).get(row);		        		
		        if(Status.CLOSE.equals(task.getStatus()))
		        	c.setBackground(Color.GREEN);		        
		        else{
	        		c.setBackground(Color.WHITE);
		        	if(Priority.IMPOTANT_FAST.equals(task.getPriority())
		        			|| Priority.IMPOTANT_NOFAST.equals(task.getPriority()))
		        		c.setBackground(Color.YELLOW);
		        }
		        if (Priority.IMPOTANT_FAST.equals(task.getPriority())){
		           c.setFont(c.getFont().deriveFont(Font.BOLD,15));
		           
		        } else {  
	        	   c.setFont(c.getFont().deriveFont(Font.PLAIN,12));
		        }
		        setHorizontalAlignment(getColumnAlignment()[column]);
		        return c;
		    }
		    
		});
	}
}
