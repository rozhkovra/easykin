package ru.rrozhkov.easykin.model.fin.payment.impl;

import static ru.rrozhkov.easykin.model.fin.payment.PaymentCategory.AUTO;
import static ru.rrozhkov.easykin.model.fin.payment.PaymentCategory.SERVICE;
import static ru.rrozhkov.easykin.model.fin.payment.PaymentCategory.TASK;
import static ru.rrozhkov.easykin.model.fin.payment.PaymentCategory.AUTODETAIL;
import static ru.rrozhkov.easykin.model.fin.payment.PaymentCategory.AUTOREPAIR;

import java.util.Date;

import ru.rrozhkov.easykin.model.fin.Money;
import ru.rrozhkov.easykin.model.fin.payment.IPayment;
import ru.rrozhkov.easykin.model.fin.payment.PaymentStatus;

public class PaymentFactory {
	public static IPayment createAutoPayment(String comment, Money amount, Date date){
		return new Payment(AUTO, comment,amount,date,PaymentStatus.FACT);
	}
	public static IPayment createAutoRepairPayment(String comment, Money amount, Date date){
		return new Payment(AUTOREPAIR, comment,amount,date,PaymentStatus.FACT);
	}
	public static IPayment createDetailPayment(String comment, Money amount, Date date){
		return new Payment(AUTODETAIL, comment,amount,date,PaymentStatus.FACT);
	}
	public static IPayment createServiceCalcPayment(String comment, Money amount, Date date, boolean isPaid){
		if(isPaid)
			return new Payment(SERVICE, comment,amount,date,PaymentStatus.FACT);
		return new Payment(SERVICE, comment,amount,date,PaymentStatus.PLAN);
	}
	public static IPayment createTaskPayment(String comment, Money amount, Date date, ru.rrozhkov.easykin.model.task.Status status){
		if(status.isClose())
			return new Payment(TASK, comment,amount,date,PaymentStatus.FACT);
		return new Payment(TASK, comment,amount,date,PaymentStatus.PLAN);
	}
}