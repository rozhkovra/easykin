package ru.rrozhkov.easykin.task;

public enum Status {
	OPEN("Открыто"), 
	CLOSE("Закрыто");
	
    private final String name;       

    private Status (String s) {
        name = s;
    }
    
    public String toString() {
        return this.name;
    }
}