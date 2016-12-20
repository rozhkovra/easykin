package ru.rrozhkov.easykin.data.impl;

import java.util.Collection;

import ru.rrozhkov.easykin.data.ICollectionDataProvider;

public class CollectionDataProvider<T> implements ICollectionDataProvider<T> {
	protected Collection<T> collection; 
	
	public CollectionDataProvider(Collection<T> collection){
		this.collection = collection;
	}
	
	public Collection<T> getData() {		
		return collection;
	}

	public void add(T t) {
		collection.add(t);
	}
}