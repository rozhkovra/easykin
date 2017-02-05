package ru.rrozhkov.easykin.model.fin.payment;


public enum Status {
	PLAN("План"), 
	FACT("Факт");
	
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
			case 1 : stat = PLAN;break;
			case 2 : stat = FACT;break;
			default : stat = PLAN;
		}
    	return stat;
	}
	public static int status(Status status) {
		int stat = 1;
		switch (status) {
			case PLAN : stat = 1;break;
			case FACT : stat = 2;break;
			default : stat = 1;
		}
    	return stat;
	}

	public boolean isPlan() {
		return PLAN.equals(this);
	}
	
	public boolean isFact() {
		return FACT.equals(this);
	}	
}