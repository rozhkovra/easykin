package ru.rrozhkov.easykin.gui;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;
import java.util.Collection;

import javax.swing.JTable;

import ru.rrozhkov.easykin.gui.style.IStyle;

public class Table extends JTable implements MouseListener{
	private static final long serialVersionUID = 1L;
	
	protected IStyle style;
	protected Collection data;
	
	public Table(Collection data, IStyle style) {
		super((String[][])style.dataConverter().convert(data, style.tableStyle().getColumnNames().length)
				,style.tableStyle().getColumnNames());
		this.style = style;
		this.data = data;
	}

	@Override
	public void doLayout() {
		super.doLayout();
		style.tableStyle().setColumnStyles(this);
		style.tableStyle().setCellRenderer(this, data);
	}
	
	@SuppressWarnings("unchecked")
	public void mouseClicked(MouseEvent event) {	
		Point point = event.getPoint();
		int row,column;
		row = rowAtPoint(point);
	    column = columnAtPoint(point);
	    System.out.println(Arrays.asList(data).get(row-1));
	}
	
	@Override
	public String getColumnName(int col) {
	    return style.tableStyle().getColumnNames()[col];
	}

	public void mouseEntered(MouseEvent arg0) {
	}

	public void mouseExited(MouseEvent arg0) {
	}

	public void mousePressed(MouseEvent arg0) {
	}

	public void mouseReleased(MouseEvent arg0) {
	}
}
