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
import ru.rrozhkov.easykin.model.service.calc.CalculationType;
import ru.rrozhkov.easykin.model.service.calc.ICalculation;
import ru.rrozhkov.easykin.model.service.calc.impl.Calculation;
import ru.rrozhkov.easykin.model.service.calc.impl.ServiceCalc;

public class ServiceCalcTableStyle extends TableStyle<ServiceCalc>  {
	public int[] getColumnAlignment() {
		return new int[]{JLabel.LEFT,JLabel.CENTER,JLabel.RIGHT
				,JLabel.RIGHT,JLabel.RIGHT,JLabel.RIGHT,JLabel.RIGHT,JLabel.RIGHT,JLabel.RIGHT,JLabel.RIGHT,JLabel.RIGHT,JLabel.RIGHT};
	}
	
	public String[] getColumnNames() {
		return new String[]{"Период","Дата", "Вода", "Гор.вода", "Свет", "Газ", "Отопление", "Антенна", "Домофон", "Квартплата", "Кап.ремонт", "Итого"};
	}
	
	public void setColumnStyles(JTable table){
	    super.setColumnStyles(table);
	    table.getColumnModel().getColumn(0).setMinWidth(150);
	    table.getColumnModel().getColumn(0).setMaxWidth(150);
	    table.getColumnModel().getColumn(1).setMinWidth(100);
	    table.getColumnModel().getColumn(1).setMaxWidth(100);
	    table.getColumnModel().getColumn(2).setMinWidth(70);
	    table.getColumnModel().getColumn(2).setMaxWidth(100);
	    table.getColumnModel().getColumn(3).setMinWidth(70);
	    table.getColumnModel().getColumn(3).setMaxWidth(100);
	    table.getColumnModel().getColumn(4).setMinWidth(70);
	    table.getColumnModel().getColumn(4).setMaxWidth(100);
	    table.getColumnModel().getColumn(5).setMinWidth(70);
	    table.getColumnModel().getColumn(5).setMaxWidth(100);
	    table.getColumnModel().getColumn(6).setMinWidth(70);
	    table.getColumnModel().getColumn(6).setMaxWidth(100);
	    table.getColumnModel().getColumn(7).setMinWidth(70);
	    table.getColumnModel().getColumn(7).setMaxWidth(100);
	    table.getColumnModel().getColumn(8).setMinWidth(70);
	    table.getColumnModel().getColumn(8).setMaxWidth(100);
	    table.getColumnModel().getColumn(9).setMinWidth(70);
	    table.getColumnModel().getColumn(9).setMaxWidth(100);
	    table.getColumnModel().getColumn(10).setMinWidth(70);
	    table.getColumnModel().getColumn(10).setMaxWidth(100);
	}
	
	@Override
	public void setCellRenderer(JTable table, final Collection<ServiceCalc> data) {
		table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer()
		{
		    @Override
		    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
		    {
		        final Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		        Collection<ICalculation> calcs = ((List<ServiceCalc>)data).get(0).calcs();
		        for(ICalculation calc : calcs){
		        	if(column==2){
		        		if(CalculationType.WATER.equals(calc.getType())
		        				&&((Calculation)calc).isPaid()){
		        			c.setBackground(Color.GREEN);
		        			c.setFont(c.getFont().deriveFont(Font.BOLD,15));
		        		}else
		        			c.setBackground(Color.YELLOW); 
		        	}else if(column==3){
		        		if(CalculationType.HOTWATER.equals(calc.getType())
		        				&&((Calculation)calc).isPaid()){
		        			c.setBackground(Color.GREEN);
		        			c.setFont(c.getFont().deriveFont(Font.BOLD,15));
		        		}else
		        			c.setBackground(Color.YELLOW); 
		        	}else if(column==4){
		        		if(CalculationType.ELECTRICITY.equals(calc.getType())
		        				&&((Calculation)calc).isPaid()){
		        			c.setBackground(Color.GREEN);
		        			c.setFont(c.getFont().deriveFont(Font.BOLD,15));
		        		}else
		        			c.setBackground(Color.YELLOW); 
		        	}else if(column==5){
		        		if(CalculationType.GAZ.equals(calc.getType())
		        				&&((Calculation)calc).isPaid()){
		        			c.setBackground(Color.GREEN);
		        			c.setFont(c.getFont().deriveFont(Font.BOLD,15));
		        		}else
		        			c.setBackground(Color.YELLOW); 
		        	}else if(column==6){
		        		if(CalculationType.HEATING.equals(calc.getType())
		        				&&((Calculation)calc).isPaid()){
		        			c.setBackground(Color.GREEN);
		        			c.setFont(c.getFont().deriveFont(Font.BOLD,15));
		        		}else
		        			c.setBackground(Color.YELLOW); 
		        	}else if(column==7){
		        		if(CalculationType.ANTENNA.equals(calc.getType())
		        				&&((Calculation)calc).isPaid()){
		        			c.setBackground(Color.GREEN);
		        			c.setFont(c.getFont().deriveFont(Font.BOLD,15));
		        		}else
		        			c.setBackground(Color.YELLOW); 
		        	}else if(column==8){
		        		if(CalculationType.INTERCOM.equals(calc.getType())
		        				&&((Calculation)calc).isPaid()){
		        			c.setBackground(Color.GREEN);
		        			c.setFont(c.getFont().deriveFont(Font.BOLD,15));
		        		}else
		        			c.setBackground(Color.YELLOW); 
		        	}else if(column==9){
		        		if(CalculationType.HOUSE.equals(calc.getType())
		        				&&((Calculation)calc).isPaid()){
		        			c.setBackground(Color.GREEN);
		        			c.setFont(c.getFont().deriveFont(Font.BOLD,15));
		        		}else
		        			c.setBackground(Color.YELLOW); 
		        	}else if(column==10){
		        		if(CalculationType.REPAIR.equals(calc.getType())
		        				&&((Calculation)calc).isPaid()){
		        			c.setBackground(Color.GREEN);
		        			c.setFont(c.getFont().deriveFont(Font.BOLD,15));
		        		}else
		        			c.setBackground(Color.YELLOW); 
		        	}else
		        		c.setBackground(Color.WHITE);
		        }
		        setHorizontalAlignment(getColumnAlignment()[column]);
		        return c;
		    }
		    
		});
	}
}
