package ru.rrozhkov.easykin.context;

import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ru.rrozhkov.easykin.data.impl.PaymentDataProvider;
import ru.rrozhkov.easykin.data.impl.stat.StaticServiceCalcDataProvider;
import ru.rrozhkov.easykin.data.impl.stat.StaticServiceHistoryDataProvider;
import ru.rrozhkov.easykin.db.impl.CategoryHandler;
import ru.rrozhkov.easykin.db.impl.KinPersonHandler;
import ru.rrozhkov.easykin.db.impl.PersonHandler;
import ru.rrozhkov.easykin.model.auto.ICar;
import ru.rrozhkov.easykin.model.auto.service.IService;
import ru.rrozhkov.easykin.model.category.ICategory;
import ru.rrozhkov.easykin.model.doc.IDoc;
import ru.rrozhkov.easykin.model.family.IKinPerson;
import ru.rrozhkov.easykin.model.family.KinType;
import ru.rrozhkov.easykin.model.family.impl.filter.KinFilterFactory;
import ru.rrozhkov.easykin.model.fin.payment.IPayment;
import ru.rrozhkov.easykin.model.fin.payment.Status;
import ru.rrozhkov.easykin.model.fin.payment.impl.filter.PaymentFilterFactory;
import ru.rrozhkov.easykin.model.person.IPerson;
import ru.rrozhkov.easykin.model.service.calc.impl.ServiceCalc;
import ru.rrozhkov.easykin.model.task.ITask;
import ru.rrozhkov.easykin.model.task.Priority;
import ru.rrozhkov.easykin.model.task.impl.TaskBuilder;
import ru.rrozhkov.easykin.model.task.impl.filter.TaskFilterFactory;
import ru.rrozhkov.lib.collection.CollectionUtil;
import ru.rrozhkov.lib.data.impl.SingleCollectionDataProvider;
import ru.rrozhkov.lib.filter.util.FilterUtil;

public class EasyKinContext {
	private IPerson person;
	private Collection<ICategory> categories;
	private Collection<ITask> tasks;
	private Collection<IPerson> persons;
	private Collection<IKinPerson> kinPersons;
	private Collection<IPayment> payments;
	private Collection<IService> services;
	private Collection<ServiceCalc> calcServices;
	private ICar car;
	private Map<ICategory, Collection> categoryData = new HashMap<ICategory, Collection>();

	public EasyKinContext() {
	}

	public EasyKinContext(IPerson person) {
		this.person = person;
	}
	
	public void init(){
		try{
			SingleCollectionDataProvider<IService, ICar> autoProvider = new StaticServiceHistoryDataProvider();
			this.categories = CategoryHandler.select();
			if(person!=null)
				this.tasks = TaskBuilder.build(person.getId());
			else
				this.tasks = TaskBuilder.build();
			this.persons = PersonHandler.select();
			this.kinPersons = KinPersonHandler.select();
			this.car = autoProvider.getSingleData();
			this.services = autoProvider.getData();
			this.calcServices = new StaticServiceCalcDataProvider().getData();
			this.payments = new PaymentDataProvider(this).getData();
		}catch(SQLException e){
			e.printStackTrace();
		}
		initCategoryData();
	}

	private void initCategoryData() {
		categoryData.clear();
		for(ICategory category : categories){
			if(category.getId()==1){
				categoryData.put(category, FilterUtil.filter(tasks(), TaskFilterFactory.createOnlyHomeFilter()));
			}else if(category.getId()==2){
				categoryData.put(category, FilterUtil.filter(kinPersons(), KinFilterFactory.create(new KinType[]{KinType.SUN, KinType.DAUGHTER})));
			}else if(category.getId()==3){
				categoryData.put(category, kinPersons());
			}else if(category.getId()==4){
				categoryData.put(category, services());
			}else if(category.getId()==5){
				categoryData.put(category, FilterUtil.filter(payments(), PaymentFilterFactory.createStatusFilter(Status.PLAN)));
			}else if(category.getId()==6){
				categoryData.put(category, FilterUtil.filter(payments(), PaymentFilterFactory.createStatusFilter(Status.FACT)));
			}else if(category.getId()==7){
				categoryData.put(category, CollectionUtil.<IDoc>create());
			}else if(category.getId()==8){
				categoryData.put(category, FilterUtil.filter(tasks(), TaskFilterFactory.createOnlyWorkFilter()));
			}else if(category.getId()==9){
				categoryData.put(category, tasks());
			}else if(category.getId()==10){
				categoryData.put(category, calcs());
			}
		}
	}
	
	public Object getObjByIndex(ICategory category, int index){
		if(index > categoryData.get(category).size()-1 || index < 0)
			return null;		
		return ((List)categoryData.get(category)).get(index);
	}


	public Collection<ICategory> categories() {
		return categories;
	}

	public Collection<ITask> tasks() {
		return tasks;
	}
	
	public Priority[] priorities(){
		return new Priority[]{
			Priority.IMPOTANT_FAST,
			Priority.IMPOTANT_NOFAST,
			Priority.SIMPLE
			};
	}

	public ru.rrozhkov.easykin.model.task.Status[] statuses(){
		return new ru.rrozhkov.easykin.model.task.Status[]{
				ru.rrozhkov.easykin.model.task.Status.OPEN,
				ru.rrozhkov.easykin.model.task.Status.CLOSE
			};
	}

	public Collection<IPerson> persons() {
		return persons;
	}

	public Collection<IKinPerson> kinPersons() {
		return kinPersons;
	}

	public Collection<IPayment> payments() {
		return payments;
	}

	public Collection<IService> services() {
		return services;
	}

	public ICar car() {
		return car;
	}

	public Collection<ServiceCalc> calcs() {
		return calcServices;
	}
}