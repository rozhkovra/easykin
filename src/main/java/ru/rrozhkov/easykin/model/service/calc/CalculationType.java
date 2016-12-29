package ru.rrozhkov.easykin.model.service.calc;

public enum CalculationType {
	HEATING("Отопление"),
	ANTENNA("�?нтенна"),
	INTERCOM("Домофон"),
	ELECTRICITY("Электриче�?тво"),
	GAZ("Газ"),
	WATER("Вода"),
	HOTWATER("Гор�?ча�? вода"),
	HOUSE("Квартплата"),
	ALL("В�?е");
	
    private final String name;       

    private CalculationType (String s) {
        name = s;
    }
    
    public String toString() {
        return this.name;
    }
}