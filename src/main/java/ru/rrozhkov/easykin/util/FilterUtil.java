package ru.rrozhkov.easykin.util;

import java.util.Collection;

import ru.rrozhkov.easykin.report.IFilter;

public class FilterUtil {
	public static <T> Collection<T> filter(Collection<T> collection, Collection<IFilter> filters){
		if (CollectionUtil.isNullOrEmpty(filters))
			return collection;
		Collection<T> filteredCollection = CollectionUtil.copy(collection);
		for(IFilter filter : filters){
			filteredCollection = filter(filteredCollection,filter);
		}
		return filteredCollection;
	}
	
	public static <T> Collection<T> filter(Collection<T> collection, IFilter filter){
		if (filter == null)
			return collection;
		Collection<T> filtered = CollectionUtil.copy(collection);
		for(T obj : collection){
			filter.setObj(obj);
			if(!filter.filter())
				filtered.remove(obj);
		}
		return filtered;
	}
}