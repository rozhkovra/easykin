package ru.rrozhkov.easykin.model.fin.payment.impl;

import static ru.rrozhkov.easykin.model.fin.payment.PaymentCategory.AUTO;
import static ru.rrozhkov.easykin.model.fin.payment.PaymentCategory.AUTODETAIL;
import static ru.rrozhkov.easykin.model.fin.payment.PaymentCategory.AUTOREPAIR;

import java.util.Date;

import ru.rrozhkov.easykin.model.fin.Money;
import ru.rrozhkov.easykin.model.fin.payment.IPayment;

public class PaymentFactory {
	public static IPayment createAutoPayment(String comment, Money amount, Date date){
		return new Payment(AUTO, comment,amount,date);
	}
	public static IPayment createAutoRepairPayment(String comment, Money amount, Date date){
		return new Payment(AUTOREPAIR, comment,amount,date);
	}
	public static IPayment createDetailPayment(String comment, Money amount, Date date){
		return new Payment(AUTODETAIL, comment,amount,date);
	}
}