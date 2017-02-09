package ru.rrozhkov.easykin.gui;

import java.util.Collection;

import javax.swing.JPanel;

import ru.rrozhkov.easykin.context.EasyKinContext;
import ru.rrozhkov.easykin.gui.auto.AutoPanel;
import ru.rrozhkov.easykin.gui.auto.CarForm;
import ru.rrozhkov.easykin.gui.style.impl.custom.CommentStyle;
import ru.rrozhkov.easykin.gui.style.impl.custom.FamilyStyle;
import ru.rrozhkov.easykin.gui.style.impl.custom.PaymentStyle;
import ru.rrozhkov.easykin.gui.style.impl.custom.ServiceCalcStyle;
import ru.rrozhkov.easykin.gui.style.impl.custom.ServiceStyle;
import ru.rrozhkov.easykin.gui.style.impl.custom.TaskStyle;
import ru.rrozhkov.easykin.model.category.ICategory;
import ru.rrozhkov.easykin.model.family.KinType;
import ru.rrozhkov.easykin.model.family.impl.filter.KinFilterFactory;
import ru.rrozhkov.easykin.model.fin.payment.Status;
import ru.rrozhkov.easykin.model.fin.payment.impl.filter.PaymentFilterFactory;
import ru.rrozhkov.easykin.model.task.IComment;
import ru.rrozhkov.easykin.model.task.impl.filter.TaskFilterFactory;
import ru.rrozhkov.lib.filter.util.FilterUtil;

public class PanelFactory {
	private static JPanel createFamilyPanel(EasyKinWindow parent, EasyKinContext context){		
		return new TablePanel(parent, new Table(context.kinPersons(), new FamilyStyle()));
	}
	private static JPanel createChildPanel(EasyKinWindow parent, EasyKinContext context){
		return new TablePanel(parent, new Table(FilterUtil.filter(context.kinPersons(), KinFilterFactory.create(new KinType[]{KinType.SUN, KinType.DAUGHTER})), new FamilyStyle()));
	}
	public static JPanel createAutoServicePanel(EasyKinWindow parent, EasyKinContext context){
		return new TablePanel(parent, new Table(context.services(), new ServiceStyle()));
	}
	private static JPanel createHomePanel(EasyKinWindow parent, EasyKinContext context) {
		return new TablePanel(parent, new Table(FilterUtil.filter(context.tasks(), TaskFilterFactory.createOnlyHomeFilter()), new TaskStyle()));
	}
	private static JPanel createFinPanel(EasyKinWindow parent, EasyKinContext context) {
		return new TablePanel(parent, new Table(FilterUtil.filter(context.payments(), PaymentFilterFactory.createStatusFilter(Status.PLAN)), new PaymentStyle()));
	}
	private static JPanel createWorkPanel(EasyKinWindow parent, EasyKinContext context) {
		return new TablePanel(parent, new Table(FilterUtil.filter(context.tasks(), TaskFilterFactory.createOnlyWorkFilter()), new TaskStyle()));
	}
	private static JPanel createPaymentPanel(EasyKinWindow parent, EasyKinContext context) {
		return new TablePanel(parent, new Table(FilterUtil.filter(context.payments(), PaymentFilterFactory.createStatusFilter(Status.FACT)), new PaymentStyle()));
	}
	private static JPanel createTaskPanel(EasyKinWindow parent, EasyKinContext context){
		return new TablePanel(parent, new Table(context.tasks(), new TaskStyle()));
	}
	public static JPanel createServicePanel(EasyKinWindow parent, EasyKinContext context){
		return new TablePanel(parent, new Table(context.calcs(), new ServiceCalcStyle()));
	}
	private static JPanel createDocPanel() {
		return new JPanel();
	}
	public static JPanel createCarPanel(EasyKinContext context) {
		return new CarForm(context.car());
	}
	private static JPanel createAutoPanel(EasyKinWindow parent, EasyKinContext context) {
		return new AutoPanel(parent, context);
	}
	public static JPanel createTaskCommentPanel(EasyKinWindow parent, Collection<IComment> comments){
		return new TablePanel(parent, new Table(comments, new CommentStyle()));
	}	
	public static JPanel createPanel(EasyKinWindow parent, EasyKinContext context, ICategory category){
		if(category.getId()==1){
			 return createHomePanel(parent, context);
		}else if(category.getId()==2){
			return createChildPanel(parent, context);
		}else if(category.getId()==3){
			return createFamilyPanel(parent, context);
		}else if(category.getId()==4){
			return createAutoPanel(parent, context);
		}else if(category.getId()==5){
			return createFinPanel(parent, context);
		}else if(category.getId()==6){
			return createPaymentPanel(parent, context);
		}else if(category.getId()==7){
			return createDocPanel();
		}else if(category.getId()==8){
			return createWorkPanel(parent, context);
		}else if(category.getId()==9){
			return createTaskPanel(parent, context);
		}else if(category.getId()==10){
			return createServicePanel(parent, context);
		}
        return new JPanel();
	}
}