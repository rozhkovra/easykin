package ru.rrozhkov.easykin.model.auto.service;

import java.util.Collection;
import java.util.Date;

import ru.rrozhkov.easykin.model.fin.Money;

public interface IService{
	String getName();
	Money getPrice();
	Date getDate();
	Collection<IService> services();
}