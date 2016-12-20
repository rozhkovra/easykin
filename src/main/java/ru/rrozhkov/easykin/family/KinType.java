package ru.rrozhkov.easykin.family;

public enum KinType {
	FATHER("Папа"), 
	MOTHER("Мама"), 
	SUN("Сын"), 
	DAUGHTER("Дочь");
	
    private final String name;       

    private KinType (String s) {
        name = s;
    }
    
    public String toString() {
        return this.name;
    }
}