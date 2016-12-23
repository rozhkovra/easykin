package ru.rrozhkov.easykin.task;

public enum Priority {
	IMPOTANT_FAST("Важно и срочно1"), 
	IMPOTANT_NOFAST("Важно и не срочно2"), 
	SIMPLE("Обычный3");
	
    private final String name;       

    private Priority (String s) {
        name = s;
    }
    
    public String toString() {
        return this.name;
    }
}