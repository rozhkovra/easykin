package ru.rrozhkov.easykin.gui.style;

import java.util.Collection;

public interface IDataConverter<E> {
	String[][] convert(Collection<E> collection, int colSize);
}