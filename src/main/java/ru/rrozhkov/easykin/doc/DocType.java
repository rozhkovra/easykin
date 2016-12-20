package ru.rrozhkov.easykin.doc;

public enum DocType {
	PASSPORT("Паспорт"), 
	SNILS("СНИЛС"), 
	INN("ИНН"), 
	BIRTHDOC("Свидетельство о рождении"), 
	MARRIAGEDOC("Свидетельство о браке"), 
	WORKBOOK("Трудовая книжка"), 
	DRIVERLICENSE("Водительское удостоверение"),
	TECHPASSPORT("Свидетельство о регистрации ТС"),;
    
	private final String name;       

    private DocType (String s) {
        name = s;
    }
    
    public String toString() {
        return this.name;
    }
}