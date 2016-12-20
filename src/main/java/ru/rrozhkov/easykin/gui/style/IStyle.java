package ru.rrozhkov.easykin.gui.style;

public interface IStyle<T> {
	ITableStyle tableStyle();
	IDataConverter<T> dataConverter();
}
