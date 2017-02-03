package ru.rrozhkov.easykin.model.fin.payment;

import java.util.Date;

import ru.rrozhkov.easykin.model.fin.Money;
import ru.rrozhkov.easykin.model.fin.Status;

public interface IPayment {
	PaymentCategory getCategory();
	String getComment();
	Money getAmount();
	Date getDate();
	Status getStatus();
}