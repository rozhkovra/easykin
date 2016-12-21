package ru.rrozhkov.easykin.service.calc;

public enum CalculationType {
	HEATING("Отопление"),
	ANTENNA("Антенна"),
	INTERCOM("Домофон"),
	ELECTRICITY("Электричество"),
	GAZ("Газ"),
	WATER("Вода"),
	HOTWATER("Горячая вода"),
	HOUSE("Квартплата");
	
    private final String name;       

    private CalculationType (String s) {
        name = s;
    }
    
    public String toString() {
        return this.name;
    }
}