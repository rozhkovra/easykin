package ru.rrozhkov.easykin.model.fin.payment;

public enum PaymentCategory {
	AUTO("Машина"), 
	AUTOREPAIR("Ремонт машины"), 
	AUTODETAIL("Детали дл�? машины");
	
    private final String name;       

    private PaymentCategory (String s) {
        name = s;
    }
    
    public String toString() {
        return this.name;
    }
}