package ru.rrozhkov.easykin.context;

import ru.rrozhkov.easykin.model.category.ICategory;
import ru.rrozhkov.easykin.model.task.ITask;
import ru.rrozhkov.lib.collection.CollectionUtil;
import ru.rrozhkov.lib.filter.IFilter;
import ru.rrozhkov.lib.filter.util.FilterUtil;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by rrozhkov on 3/21/2017.
 */
public class FilterContext implements IContext{
    protected Collection<IFilter> filters;
    protected Map<ICategory, Collection<IFilter>> filterMap;

    public FilterContext(Collection<IFilter> filters) {
        this.filters = filters;
    }

    public FilterContext(Map<ICategory, Collection<IFilter>> map) {
        this.filterMap = map;
    }

    public FilterContext() {
        this.filters = CollectionUtil.create();
        this.filterMap = new HashMap<ICategory, Collection<IFilter>>();
    }

    public void add(IFilter filter){
        filters.add(filter);
    }

    public void add(ICategory category, IFilter filter){
        if(!filterMap.containsKey(category))
            filterMap.put(category, CollectionUtil.<IFilter>create());
        filterMap.get(category).add(filter);
    }

    public void clear(){
        filters.clear();
        filterMap.clear();
    }

    public void init() {

    }
}
