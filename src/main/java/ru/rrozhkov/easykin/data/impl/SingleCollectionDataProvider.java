package ru.rrozhkov.easykin.data.impl;

import java.util.Collection;

import ru.rrozhkov.easykin.data.ISingleDataProvider;

public abstract class SingleCollectionDataProvider<T, E> extends CollectionDataProvider<T> implements ISingleDataProvider<E>{
	private E obj;
	public SingleCollectionDataProvider(Collection<T> collection, E obj) {
		super(collection);
		this.obj = obj;
	}
	public E getSingleData(){
		return this.obj;
	}
}