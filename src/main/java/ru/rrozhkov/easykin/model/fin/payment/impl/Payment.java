package ru.rrozhkov.easykin.model.fin.payment.impl;

import java.util.Date;

import ru.rrozhkov.easykin.model.fin.Money;
import ru.rrozhkov.easykin.model.fin.payment.IPayment;
import ru.rrozhkov.easykin.model.fin.payment.PaymentCategory;

public class Payment implements IPayment {
	protected PaymentCategory category;
	protected String comment;
	protected Money amount;
	protected Date date;
	
	public Payment(PaymentCategory category, String comment, Money amount, Date date) {
		this.category = category;
		this.comment = comment;
		this.amount = amount;
		this.date = date;
	}

	public PaymentCategory getCategory() {
		return category;
	}

	public String getComment() {
		return comment;
	}

	public Money getAmount() {
		return amount;
	}

	public Date getDate() {
		return date;
	}
}