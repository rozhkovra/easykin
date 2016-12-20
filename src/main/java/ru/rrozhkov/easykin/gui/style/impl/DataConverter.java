package ru.rrozhkov.easykin.gui.style.impl;

import java.util.Collection;

import ru.rrozhkov.easykin.gui.style.IDataConverter;
import ru.rrozhkov.easykin.util.CollectionUtil;

public abstract class DataConverter<E> implements IDataConverter<E>{
	public String[][] convert(Collection<E> collection, int colSize){
		Collection<String[]> list = CollectionUtil.<String[]>create();
		for(E entry : collection){
			list.add(entryToStringArr(list.size()+1,entry));
		}
		return list.toArray(new String[list.size()][colSize]);
	}
	
	public abstract String[] entryToStringArr(int i, E entry);
}
