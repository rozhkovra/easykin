package ru.rrozhkov.easykin.model.task;

public enum Priority {
	IMPOTANT_FAST("Важно и �?рочно"), 
	IMPOTANT_NOFAST("Важно и не �?рочно"), 
	SIMPLE("Обычный");
	
    private final String name;       

    private Priority (String s) {
        name = s;
    }
    
    public String toString() {
        return this.name;
    }
    
    public static Priority priority(int i){
		Priority prio = null;
		switch (i) {
			case 1 : prio = IMPOTANT_FAST;break;
			case 2 : prio = IMPOTANT_NOFAST;break;
			default : prio = SIMPLE;
		}
    	return prio;
    }
}