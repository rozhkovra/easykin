package ru.rrozhkov.easykin.auto.service;

import java.util.Collection;

public interface IRepairService extends IService {
	Collection<IDetail> getDetails();
}