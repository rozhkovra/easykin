package ru.rrozhkov.easykin.model.doc;

public enum DocType {
	PASSPORT("Па�?порт"), 
	SNILS("С�?ИЛС"), 
	INN("И�?�?"), 
	BIRTHDOC("Свидетель�?тво о рождении"), 
	MARRIAGEDOC("Свидетель�?тво о браке"), 
	WORKBOOK("Трудова�? книжка"), 
	DRIVERLICENSE("Водитель�?кое удо�?товерение"),
	TECHPASSPORT("Свидетель�?тво о реги�?трации ТС"),;
    
	private final String name;       

    private DocType (String s) {
        name = s;
    }
    
    public String toString() {
        return this.name;
    }
}