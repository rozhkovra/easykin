package ru.rrozhkov.easykin.filter;

public interface IFilter<T> {
	boolean filter(T obj);
}