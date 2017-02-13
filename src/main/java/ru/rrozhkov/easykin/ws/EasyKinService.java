package ru.rrozhkov.easykin.ws;

import java.util.Collection;

import javax.jws.WebMethod;
import javax.jws.WebService;

import ru.rrozhkov.easykin.context.MasterDataContext;
import ru.rrozhkov.easykin.model.category.ICategory;
import ru.rrozhkov.easykin.model.person.IPerson;
import ru.rrozhkov.easykin.model.task.ITask;
import ru.rrozhkov.easykin.ws.bean.CategoryBean;
import ru.rrozhkov.easykin.ws.bean.PersonBean;
import ru.rrozhkov.easykin.ws.bean.TaskBean;
import ru.rrozhkov.easykin.ws.convert.WSCategoryConverter;
import ru.rrozhkov.easykin.ws.convert.WSPersonConverter;
import ru.rrozhkov.easykin.ws.convert.WSTaskConverter;
import ru.rrozhkov.lib.collection.CollectionUtil;

@WebService(serviceName="EasyKin", portName="EasyKinPort", targetNamespace="http://rrozhkov.ru/easykin")
public class EasyKinService {

	@WebMethod
	public Collection<CategoryBean> categories() {
		MasterDataContext context = new MasterDataContext();
		context.init();
		Collection<CategoryBean> beans = CollectionUtil.<CategoryBean>create();
		for(ICategory category : context.categories()){
			beans.add(new WSCategoryConverter().convert(category));
		}
		return beans;
	}
	@WebMethod
	public Collection<PersonBean> persons() {
		MasterDataContext context = new MasterDataContext();
		context.init();
		Collection<PersonBean> beans = CollectionUtil.<PersonBean>create();
		for(IPerson person : context.persons()){
			beans.add(new WSPersonConverter().convert(person));
		}
		return beans;
	}
	@WebMethod
	public Collection<TaskBean> tasks() {
		MasterDataContext context = new MasterDataContext();
		context.init();
		Collection<TaskBean> beans = CollectionUtil.<TaskBean>create();
		for(ITask task : context.tasks()){
			beans.add(new WSTaskConverter().convert(task));
		}
		return beans;
	}
}
