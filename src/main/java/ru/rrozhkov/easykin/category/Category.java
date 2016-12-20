package ru.rrozhkov.easykin.category;

public enum Category {
	HOME("Дом"), 
	CHILD("Дети"), 
	FAMILY("Семья"), 
	AUTO("Машина"), 
	FIN("Финансы"), 
	PAYMENT("Платежи"), 
	DOC("Документы"), 
	WORK("Работа"),
	TASK("Задачи");
	
    private final String name;       

    private Category (String s) {
        name = s;
    }
    
    public String toString() {
        return this.name;
    }

}