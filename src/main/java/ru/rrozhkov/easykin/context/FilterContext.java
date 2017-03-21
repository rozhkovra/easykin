package ru.rrozhkov.easykin.context;

import ru.rrozhkov.easykin.model.task.ITask;
import ru.rrozhkov.easykin.model.task.impl.filter.PriorityFilter;
import ru.rrozhkov.easykin.model.task.impl.filter.StatusFilter;
import ru.rrozhkov.lib.collection.CollectionUtil;
import ru.rrozhkov.lib.filter.IFilter;
import ru.rrozhkov.lib.filter.util.FilterUtil;

import java.util.Collection;

/**
 * Created by rrozhkov on 3/21/2017.
 */
public class FilterContext implements IContext{
    private Collection<IFilter> filters;

    public FilterContext(Collection<IFilter> filters) {
        this.filters = filters;
    }

    public FilterContext() {
        this.filters = CollectionUtil.create();
    }

    public void add(IFilter filter){
        filters.add(filter);
    }

    public void clear(){
        filters.clear();
    }

    public Collection<ITask> filter(Collection<ITask> tasks){
        return FilterUtil.filter(tasks,filters);
    }

    public void init() {

    }
}
