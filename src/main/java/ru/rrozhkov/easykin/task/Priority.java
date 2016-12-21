package ru.rrozhkov.easykin.task;

public enum Priority {
	IMPOTANT_FAST("Важно и срочно"), 
	IMPOTANT_NOFAST("Важно и не срочно"), 
	SIMPLE("Обычный");
	
    private final String name;       

    private Priority (String s) {
        name = s;
    }
    
    public String toString() {
        return this.name;
    }
}