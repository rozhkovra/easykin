package ru.rrozhkov.easykin.util;

import java.util.Collection;
import java.util.LinkedList;

public class CollectionUtil {
	@SuppressWarnings("rawtypes")
	public static boolean isNullOrEmpty(Collection collection){
		return collection==null || collection.isEmpty();		
	}
	
	public static <T> Collection<T> copy(Collection<T> collection){
		return new LinkedList<T>(collection);
	}

	public static <T> Collection<T> merge2copy(Collection<T> collection, T obj){
		Collection<T> newCollection = new LinkedList<T>(collection);
		newCollection.add(obj);
		return newCollection;
	}
	
	public static <T> Collection<T> create(){
		return new LinkedList<T>();
	}
}