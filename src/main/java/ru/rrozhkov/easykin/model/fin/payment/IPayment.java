package ru.rrozhkov.easykin.model.fin.payment;

import java.util.Date;

import ru.rrozhkov.easykin.model.fin.Money;

public interface IPayment {
	PaymentCategory getCategory();
	String getComment();
	Money getAmount();
	Date getDate();
	PaymentStatus getStatus();
}