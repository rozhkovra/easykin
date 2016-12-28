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

	public static Status status(int status) {
		Status stat = null;
		switch (status) {
			case 1 : stat = OPEN;break;
			case 2 : stat = CLOSE;break;
			default : stat = OPEN;
		}
    	return stat;
	}
}