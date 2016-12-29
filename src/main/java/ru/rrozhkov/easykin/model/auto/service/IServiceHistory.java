package ru.rrozhkov.easykin.model.auto.service;

import java.util.Collection;

import ru.rrozhkov.easykin.model.auto.ICar;

public interface IServiceHistory {
	ICar getCar();
	Collection<IService> getServices();
}