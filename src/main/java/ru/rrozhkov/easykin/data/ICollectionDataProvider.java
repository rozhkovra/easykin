package ru.rrozhkov.easykin.data;

import java.util.Collection;

public interface ICollectionDataProvider<T> {
	Collection<T> getData();
}