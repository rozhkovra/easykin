package ru.rrozhkov.easykin.person;

public enum Sex {
	MALE("М"), 
	FEMALE("Ж");
	
    private final String name;       

    private Sex (String s) {
        name = s;
    }
    
    public String toString() {
        return this.name;
    }
}