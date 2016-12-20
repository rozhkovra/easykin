package ru.rrozhkov.easykin.fin.payment;

import java.util.Date;

import ru.rrozhkov.easykin.fin.Money;

public interface IPayment {
	PaymentCategory getCategory();
	String getComment();
	Money getAmount();
	Date getDate();
}