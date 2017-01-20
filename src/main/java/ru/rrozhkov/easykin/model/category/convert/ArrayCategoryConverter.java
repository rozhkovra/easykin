package ru.rrozhkov.easykin.model.category.convert;

import java.util.Collection;

import ru.rrozhkov.easykin.model.category.ICategory;
import ru.rrozhkov.easykin.model.convert.IConverter;
import ru.rrozhkov.easykin.util.CollectionUtil;

public class ArrayCategoryConverter implements IConverter<Collection<ICategory>, String[]> {

	public String[] convert(Collection<ICategory> categories) {
		Collection<String> items = CollectionUtil.<String>create(); 
		for(ICategory category : categories)
			items.add(category.getName());
		return items.toArray(new String[items.size()]);
	}

}
