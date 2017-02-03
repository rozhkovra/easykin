package ru.rrozhkov.easykin.context;

import java.sql.SQLException;
import java.util.Collection;

import ru.rrozhkov.easykin.data.impl.PaymentDataProvider;
import ru.rrozhkov.easykin.data.impl.SingleCollectionDataProvider;
import ru.rrozhkov.easykin.data.impl.stat.StaticAutoServiceDataProvider;
import ru.rrozhkov.easykin.data.impl.stat.StaticServiceCalcDataProvider;
import ru.rrozhkov.easykin.data.impl.stat.StaticServiceHistoryDataProvider;
import ru.rrozhkov.easykin.db.CategoryHandler;
import ru.rrozhkov.easykin.db.KinPersonHandler;
import ru.rrozhkov.easykin.db.PersonHandler;
import ru.rrozhkov.easykin.db.TaskHandler;
import ru.rrozhkov.easykin.model.auto.ICar;
import ru.rrozhkov.easykin.model.auto.service.IService;
import ru.rrozhkov.easykin.model.category.ICategory;
import ru.rrozhkov.easykin.model.family.IKinPerson;
import ru.rrozhkov.easykin.model.fin.payment.IPayment;
import ru.rrozhkov.easykin.model.person.IPerson;
import ru.rrozhkov.easykin.model.service.calc.impl.ServiceCalc;
import ru.rrozhkov.easykin.model.task.ITask;
import ru.rrozhkov.easykin.model.task.Priority;

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
				this.tasks = TaskHandler.selectForPerson(person.getId());
			else
				this.tasks = TaskHandler.select();
			this.persons = PersonHandler.select();
			this.kinPersons = KinPersonHandler.select();
			this.car = autoProvider.getSingleData();
			this.services = autoProvider.getData();
			this.calcServices = new StaticServiceCalcDataProvider().getData();
			this.payments = new PaymentDataProvider(services,calcServices).getData();
		}catch(SQLException e){
			e.printStackTrace();
		}
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