package ru.rrozhkov.easykin.task;

public enum Status {
	OPEN("Открыта"), 
	CLOSE("Закрыта");
	
    private final String name;       

    private Status (String s) {
        name = s;
    }
    
    public String toString() {
        return this.name;
    }
}