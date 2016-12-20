package ru.rrozhkov.easykin.auto.service;

import java.util.Collection;

import ru.rrozhkov.easykin.auto.ICar;

public interface IServiceHistory {
	ICar getCar();
	Collection<IService> getServices();
}