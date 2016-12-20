package ru.rrozhkov.easykin.fin.payment.impl;

import static ru.rrozhkov.easykin.fin.payment.PaymentCategory.AUTO;
import static ru.rrozhkov.easykin.fin.payment.PaymentCategory.AUTODETAIL;
import static ru.rrozhkov.easykin.fin.payment.PaymentCategory.AUTOREPAIR;

import java.util.Date;

import ru.rrozhkov.easykin.auto.service.IDetail;
import ru.rrozhkov.easykin.auto.service.IService;
import ru.rrozhkov.easykin.auto.service.impl.RepairService;
import ru.rrozhkov.easykin.fin.Money;
import ru.rrozhkov.easykin.fin.payment.IPayment;

public class PaymentFactory {
	public static IPayment createAutoPayment(String comment, Money amount, Date date){
		return new Payment(AUTO, comment,amount,date);
	}
	public static IPayment createAutoRepairPayment(String comment, Money amount, Date date){
		return new Payment(AUTOREPAIR, comment,amount,date);
	}
	public static IPayment createDetailPayment(IDetail detail){
		return new Payment(AUTODETAIL, detail.getName(),detail.getPrice(),detail.getBuyDate());
	}
	public static IPayment createServicePayment(IService entry) {
		if(entry instanceof RepairService){
			return createAutoRepairPayment(entry.getName(),entry.getPrice(),entry.getDate());
		}
		return createAutoPayment(entry.getName(),entry.getPrice(),entry.getDate()); 
	}
}