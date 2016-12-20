package ru.rrozhkov.easykin.auto.service;

import java.util.Date;

import ru.rrozhkov.easykin.fin.Money;

public interface IDetail {
	String getName();
	Money getPrice();
	Date getBuyDate();
}