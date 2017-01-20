package ru.rrozhkov.easykin.model.convert;

public interface IConverter<T,E> {
	E convert(T entry);
}